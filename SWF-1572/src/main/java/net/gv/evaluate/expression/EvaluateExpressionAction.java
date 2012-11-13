package net.gv.evaluate.expression;

import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

@Component
public class EvaluateExpressionAction {
	
	public void test(RequestContext context, Object obj) {
		System.out.println(obj);
	}
		
}