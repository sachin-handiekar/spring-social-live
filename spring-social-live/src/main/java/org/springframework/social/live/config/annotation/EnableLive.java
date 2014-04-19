package org.springframework.social.live.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(LiveProviderConfigRegistrar.class)
public @interface EnableLive {

	/**
	 * The application's consumer key as issued by Microsoft Live.
	 */
	String appId();
	
	/**
	 * The application's consumer secret as issued by Microsoft Live.
	 */
	String appSecret();
}
