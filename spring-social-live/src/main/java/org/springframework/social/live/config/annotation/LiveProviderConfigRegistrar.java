package org.springframework.social.live.config.annotation;

import org.springframework.social.config.annotation.AbstractProviderConfigRegistrarSupport;
import org.springframework.social.live.config.LiveApiHelper;
import org.springframework.social.live.connect.LiveConnectionFactory;
import org.springframework.social.live.security.LiveAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

public class LiveProviderConfigRegistrar extends
		AbstractProviderConfigRegistrarSupport {

	public LiveProviderConfigRegistrar() {
		
		super(EnableLive.class,LiveConnectionFactory.class,LiveApiHelper.class);
	}
	
	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {

		return LiveAuthenticationService.class;
	}
}
