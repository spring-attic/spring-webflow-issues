package org.springframework.webflow.issues;

import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.MockParameterMap;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

import foo.bar.HighLevelBean;

public class MyFlowExecutionTests extends AbstractXmlFlowExecutionTests {

	@Override
	protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
		return resourceFactory.createFileResource("src/main/webapp/WEB-INF/myflow/myflow.xml");
	}

	@Override
	protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
		// Register beans here..
		// MyService myService = ... ;
		// builderContext.registerBean("myService", myService);
	}

	public void testStartFlow() {

		MockExternalContext context = new MockExternalContext();

		startFlow(new LocalAttributeMap(), context);

		assertCurrentStateEquals("view");
		assertResponseWrittenEquals("view", context);
	}

	public void testEndFlow() {
		setCurrentState("view");

		getFlowScope().put("myBean", new HighLevelBean());
		
		MockExternalContext context = new MockExternalContext();
		MockParameterMap mockParameterMap = new MockParameterMap();
		mockParameterMap.put("elements[12131200321321300].a", "aaaa");
				
		context.setRequestParameterMap(mockParameterMap);
		context.setEventId("continue");
		resumeFlow(context);

		MockExternalContext context2 = new MockExternalContext();
		context2.setEventId("continue");
		resumeFlow(context2);
		
		assertFlowExecutionEnded();
		assertFlowExecutionOutcomeEquals("done");
	}

}
