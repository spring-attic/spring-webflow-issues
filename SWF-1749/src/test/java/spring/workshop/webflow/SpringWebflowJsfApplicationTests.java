package spring.workshop.webflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = {SpringWebflowJsfApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringWebflowJsfApplicationTests {

	private static final String BASE_URL = "http://localhost:8080";
	private static final List<String> PREDICTABLE_VIEWSTATES = new ArrayList<>();
	private static TestRestTemplate restTemplate;
	
	@BeforeClass
	public static void setupRestTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		HttpClient httpClient = HttpClientBuilder
				.create()
                .setRedirectStrategy(new LaxRedirectStrategy())
                .build();
		requestFactory.setHttpClient(httpClient);
		RestTemplate rt = new RestTemplateBuilder()
				.rootUri(BASE_URL)
				.requestFactory(requestFactory)
				.build();
		restTemplate = new TestRestTemplate(rt);
	}
	
	@BeforeClass
	public static void setupPredictableViewStates() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				PREDICTABLE_VIEWSTATES.add("e" + i + "s" + j);
			}
		}
	}
	
	private String getJSessionIdCookie() {
		ResponseEntity<String> response;
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("username", "admin");
		params.add("password", "admin");
		params.add("submit", "Login");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		response = restTemplate.exchange(
				"/j_spring_security_check",
				HttpMethod.POST,
				new HttpEntity<>(params, headers),
				String.class);
		assertEquals(302, response.getStatusCode().value());
		assertEquals("http://localhost:8080/ui/person/list", response.getHeaders().getLocation().toString());
		
		String jSessionIdCookie = response.getHeaders().get(HttpHeaders.SET_COOKIE).get(0).split(";")[0];
		assertTrue(jSessionIdCookie.contains("JSESSIONID="));
		return jSessionIdCookie;
	}
	
	private String getViewState(String html) {
		String pattern = "<input type=\"hidden\" name=\"javax\\.faces\\.ViewState\" id=\"javax\\.faces\\.ViewState\" value=\"(.*)\" />";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(html);
        m.find();
		return m.group(1);
	}
	
	@Test
	public void viewStateShouldntBePredictable() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.COOKIE, getJSessionIdCookie());
		
		ResponseEntity<String> response = restTemplate.exchange(
				"/ui/person/list",
				HttpMethod.GET,
				new HttpEntity<>(headers),
                String.class);
		assertEquals(302, response.getStatusCode().value());
		assertEquals("http://localhost:8080/ui/person/list?execution=e1s1", response.getHeaders().getLocation().toString());
		
		response = restTemplate.exchange(
				"/ui/person/list?execution=e1s1",
				HttpMethod.GET,
				new HttpEntity<>(headers),
                String.class);
		assertEquals(200, response.getStatusCode().value());
		
		// The next assertion should succeed, as the CSRF token shouldn't be predictable, but it fails
		assertFalse(PREDICTABLE_VIEWSTATES.contains(getViewState(response.getBody())));
	}
	
	@Test
	public void sameRequestShouldFailSecondTime() throws InterruptedException {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.COOKIE, getJSessionIdCookie());
		ResponseEntity<String> response;
		
		response = restTemplate.exchange(
				"/ui/person/list",
				HttpMethod.GET,
				new HttpEntity<>(headers),
                String.class);
		assertEquals(302, response.getStatusCode().value());
		assertEquals("http://localhost:8080/ui/person/list?execution=e1s1", response.getHeaders().getLocation().toString());
		
		response = restTemplate.exchange(
				"/ui/person/list?execution=e1s1",
				HttpMethod.GET,
				new HttpEntity<>(headers),
                String.class);
		assertEquals(200, response.getStatusCode().value());
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("javax.faces.ViewState", getViewState(response.getBody()));
		params.add("j_idt6:j_idt14", "");
		params.add("j_idt6", "j_idt6");
		
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		
		response = restTemplate.exchange(
				"/ui/person/list?execution=e1s1",
				HttpMethod.POST,
				new HttpEntity<>(params, headers),
                String.class);
		assertEquals(302, response.getStatusCode().value());
		assertEquals("http://localhost:8080/ui/person/list?execution=e1s2", response.getHeaders().getLocation().toString());
		
		response = restTemplate.exchange(
				"/ui/person/list?execution=e1s1",
				HttpMethod.POST,
				new HttpEntity<>(params, headers),
                String.class);
		
		// The next assertion should succeed, as we sent the same request (with the same CSRF token) twice, but it fails
		assertTrue(response.getStatusCode().is4xxClientError());
	}
	
}
