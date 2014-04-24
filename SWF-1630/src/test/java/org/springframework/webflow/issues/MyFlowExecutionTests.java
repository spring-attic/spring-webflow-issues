package org.springframework.webflow.issues;

import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

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

		MutableAttributeMap input = new LocalAttributeMap();
		MockExternalContext context = new MockExternalContext();

		startFlow(input, context);

		assertCurrentStateEquals("view");
		assertResponseWrittenEquals("view", context);
	}

	public void testEndFlow() {
		setCurrentState("view");

		MockExternalContext context = new MockExternalContext();
		context.setEventId("continue");
		resumeFlow(context);

		assertFlowExecutionEnded();
		assertFlowExecutionOutcomeEquals("done");
	}

}
