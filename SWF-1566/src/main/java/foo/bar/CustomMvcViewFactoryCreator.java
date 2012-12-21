package foo.bar;

import org.springframework.binding.convert.ConversionService;
import org.springframework.binding.expression.Expression;
import org.springframework.binding.expression.ExpressionParser;
import org.springframework.binding.expression.beanwrapper.BeanWrapperExpressionParser;
import org.springframework.validation.Validator;
import org.springframework.webflow.engine.builder.BinderConfiguration;
import org.springframework.webflow.execution.ViewFactory;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.validation.ValidationHintResolver;

public class CustomMvcViewFactoryCreator extends MvcViewFactoryCreator {

	@Override
	public ViewFactory createViewFactory(Expression viewId,
			ExpressionParser expressionParser,
			ConversionService conversionService,
			BinderConfiguration binderConfiguration, Validator validator,
			ValidationHintResolver validationHintResolver) {

		BeanWrapperExpressionParser bwExpressionParser = new BeanWrapperExpressionParser(conversionService);
		bwExpressionParser.setAutoGrowNestedPaths(true);
		bwExpressionParser.setAutoGrowCollectionLimit(1000);

		return super.createViewFactory(viewId, bwExpressionParser, conversionService,
				binderConfiguration, validator, validationHintResolver);
	}





}
