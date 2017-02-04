package org.springframework.social.live.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.live.api.Live;

public class LiveConnectionFactory extends OAuth2ConnectionFactory<Live> {

	public LiveConnectionFactory(String clientId, String clientSecret) {
		super("live", new LiveServiceProvider(clientId, clientSecret), new LiveAdapter());
	}

}
