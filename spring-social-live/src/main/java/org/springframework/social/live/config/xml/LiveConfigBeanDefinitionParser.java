package org.springframework.social.live.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.live.config.LiveApiHelper;
import org.springframework.social.live.connect.LiveConnectionFactory;
import org.springframework.social.live.security.LiveAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

public class LiveConfigBeanDefinitionParser extends
		AbstractProviderConfigBeanDefinitionParser {

	protected LiveConfigBeanDefinitionParser() {
		
		super(LiveConnectionFactory.class, LiveApiHelper.class);
	}
	
	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {

		return LiveAuthenticationService.class;
	}
	
}
