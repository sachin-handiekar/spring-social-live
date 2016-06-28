package org.springframework.social.live.api.impl;

import org.springframework.social.live.api.LiveProfile;
import org.springframework.social.live.api.UserOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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
		String email = null;
		//if requested scope was wl.emails, this field will be present
		Map<String, String> emails = (Map<String, String>)user.get("emails");
		if (emails != null) {
			//grab preferred email
			if (emails.containsKey("preferred")) {
				email = emails.get("preferred");
			//ok grab account related email
			} else if (emails.containsKey("account")) {
				email = emails.get("account");
			//ok grab what you have then :)
			} else if (!emails.isEmpty()) {
				email = emails.values().iterator().next();
			}
		}

		return new LiveProfile(id, name, firstName, lastName, gender, email, locale);

	}

	@Override
	public LiveProfile getUserProfileWithUsername(String userName) {
		return restTemplate.getForObject("https://apis.live.net/v5.0/" + userName, LiveProfile.class);

	}

}
