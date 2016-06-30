package org.springframework.social.live.connect;

import org.springframework.social.live.api.Live;
import org.springframework.social.live.api.impl.LiveTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class LiveServiceProvider extends AbstractOAuth2ServiceProvider<Live> {

	public LiveServiceProvider(String clientId, String clientSecret) {
		super(new LiveOAuth2Template(clientId, clientSecret));
	}

	@Override
	public Live getApi(String accessToken) {
		return new LiveTemplate(accessToken);
	}

}
