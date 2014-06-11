package swf1506;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.ServletContextAware;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.definition.FlowDefinition;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.definition.TransitionDefinition;
import org.springframework.webflow.execution.EnterStateVetoException;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListener;
import org.springframework.webflow.execution.FlowSession;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.View;

public class MyListener implements HttpSessionListener, FlowExecutionListener, ServletContextAware {


	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.addListener(this);
	}

	// HttpSessionListener

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSessionListener.sessionCreated");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSessionListener.sessionDestroyed");
	}

	// FlowExecutionListener

	@Override
	public void requestSubmitted(RequestContext context) {
	}

	@Override
	public void requestProcessed(RequestContext context) {
	}

	@Override
	public void sessionCreating(RequestContext context, FlowDefinition definition) {
		System.out.println("FlowExecutionListener.sessionCreating");
	}

	@Override
	public void sessionStarting(RequestContext context, FlowSession session, MutableAttributeMap<?> input) {
		System.out.println("FlowExecutionListener.sessionStarting");
	}

	@Override
	public void sessionStarted(RequestContext context, FlowSession session) {
	}

	@Override
	public void eventSignaled(RequestContext context, Event event) {
	}

	@Override
	public void transitionExecuting(RequestContext context,
			TransitionDefinition transition) {
	}

	@Override
	public void stateEntering(RequestContext context, StateDefinition state)
			throws EnterStateVetoException {
	}

	@Override
	public void stateEntered(RequestContext context,
			StateDefinition previousState, StateDefinition state) {
	}

	@Override
	public void viewRendering(RequestContext context, View view,
			StateDefinition viewState) {
	}

	@Override
	public void viewRendered(RequestContext context, View view,
			StateDefinition viewState) {
	}

	@Override
	public void paused(RequestContext context) {
	}

	@Override
	public void resuming(RequestContext context) {
	}

	@Override
	public void sessionEnding(RequestContext context, FlowSession session,
			String outcome, MutableAttributeMap<?> output) {
	}

	@Override
	public void sessionEnded(RequestContext context, FlowSession session,
			String outcome, AttributeMap<?> output) {
	}

	@Override
	public void exceptionThrown(RequestContext context,
			FlowExecutionException exception) {
	}

}
