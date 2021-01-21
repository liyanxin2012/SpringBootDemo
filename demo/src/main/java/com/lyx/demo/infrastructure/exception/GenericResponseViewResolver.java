package com.lyx.demo.infrastructure.exception;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

/**
 * Generic Response View Resolver
 *
 * @author Ryan
 */
@Service
public class GenericResponseViewResolver implements ViewResolver {

	/**
	 * View Name
	 */
	public static final String VIEW_NAME = "GenericResponseView";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		if (VIEW_NAME.equals(viewName)) {
			return new MappingJackson2JsonView();
		}

		return null;
	}
}
