package org.springframework.social.live.api.userinfo.impl;

import java.util.Map;

import org.springframework.social.live.api.impl.AbstractLiveOperations;
import org.springframework.social.live.api.impl.LiveTemplate;
import org.springframework.social.live.api.userinfo.LiveProfile;
import org.springframework.social.live.api.userinfo.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractLiveOperations implements UserOperations {
	private final RestTemplate restTemplate;

	public UserTemplate(LiveTemplate liveTemplate, RestTemplate restTemplate, boolean authorized) {
		super(authorized);
		this.restTemplate = restTemplate;

	}

	@Override
	public LiveProfile getUserProfile() {
		@SuppressWarnings("unchecked")
		Map<String, ?> user = restTemplate.getForObject(buildUri("me"), Map.class);
		String id = String.valueOf(user.get("id"));
		String name = String.valueOf(user.get("name"));
		String firstName = String.valueOf(user.get("first_name"));
		String lastName = String.valueOf(user.get("last_name"));
		String gender = String.valueOf(user.get("gender"));
		String locale = String.valueOf(user.get("locale"));

		return new LiveProfile(id, name, firstName, lastName, gender, locale);

	}

	@Override
	public LiveProfile getUserProfileWithUsername(String userName) {
		return restTemplate.getForObject("https://apis.live.net/v5.0/" + userName, LiveProfile.class);

	}

}
