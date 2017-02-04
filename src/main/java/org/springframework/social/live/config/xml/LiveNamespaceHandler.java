package org.springframework.social.live.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.AbstractProviderConfigNamespaceHandler;

public class LiveNamespaceHandler extends AbstractProviderConfigNamespaceHandler {

	@Override
	protected AbstractProviderConfigBeanDefinitionParser getProviderConfigBeanDefinitionParser() {

		return new LiveConfigBeanDefinitionParser();
	}

}
