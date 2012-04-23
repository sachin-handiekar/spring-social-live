package org.springframework.social.live.connect;

import org.springframework.social.oauth2.OAuth2Template;

public class LiveOAuth2Template extends OAuth2Template  {

	public LiveOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, "https://oauth.live.com/authorize", "https://oauth.live.com/token");
	}


}
