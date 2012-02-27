package org.springframework.webflow.issues;

import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

public class PhonebookFlowExecutionTests extends AbstractXmlFlowExecutionTests {

	@Override
	protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
		return resourceFactory.createFileResource("src/main/webapp/WEB-INF/phonebook/phonebook-flow.xml");
	}

	@Override
	protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
		// register beans -- e.g. builderContext.registerBean("phoneService", phoneService);
	}

	public void testStartFlow() {

		MutableAttributeMap input = new LocalAttributeMap();
		MockExternalContext context = new MockExternalContext();

		startFlow(input, context);

		assertCurrentStateEquals("showNumbers");
		assertResponseWrittenEquals("showNumbers", context);
	}

	public void testEndFlow() {
		setCurrentState("showNumbers");

		MockExternalContext context = new MockExternalContext();
		context.setEventId("continue");
		resumeFlow(context);

		assertFlowExecutionEnded();
		assertFlowExecutionOutcomeEquals("done");
	}

}
