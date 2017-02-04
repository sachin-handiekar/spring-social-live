package org.springframework.social.live.config.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.social.config.support.ProviderConfigurationSupport;
import org.springframework.social.live.config.LiveApiHelper;
import org.springframework.social.live.connect.LiveConnectionFactory;
import org.springframework.social.live.security.LiveAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

import java.lang.annotation.Annotation;
import java.util.Map;

public class LiveProviderConfigRegistrar extends ProviderConfigurationSupport {
	private final Class<? extends Annotation> providerConfigAnnotation;

	public LiveProviderConfigRegistrar() {
		super(LiveConnectionFactory.class, LiveApiHelper.class);
		this.providerConfigAnnotation = EnableLive.class;
	}
	
	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return LiveAuthenticationService.class;
	}

	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		Map<String, Object> allAttributes = metadata.getAnnotationAttributes(providerConfigAnnotation.getName());
		registerBeanDefinitions(registry, allAttributes);
	}

	@Override
	protected String getAppId(Map<String, Object> allAttributes) {
		return (String) allAttributes.get("appId");
	}

	@Override
	protected String getAppSecret(Map<String, Object> allAttributes) {
		return (String) allAttributes.get("appSecret");
	}

}
