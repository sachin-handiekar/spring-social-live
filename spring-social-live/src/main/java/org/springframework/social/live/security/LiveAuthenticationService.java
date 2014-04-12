package org.springframework.social.live.security;

import org.springframework.social.live.api.Live;
import org.springframework.social.live.connect.LiveConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class LiveAuthenticationService extends OAuth2AuthenticationService<Live> {
	
	public LiveAuthenticationService(String apiKey, String appSecret) {
		
		super(new LiveConnectionFactory(apiKey, appSecret));
	}

}
