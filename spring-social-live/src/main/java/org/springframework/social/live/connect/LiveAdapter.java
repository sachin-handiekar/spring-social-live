package org.springframework.social.live.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.live.api.Live;
import org.springframework.social.live.api.userinfo.LiveProfile;

public class LiveAdapter implements ApiAdapter<Live> {

	public boolean test(Live live) {
		try {
			live.userOperations().getUserProfile();
			return true;
		}
		catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(Live live, ConnectionValues values) {
		LiveProfile profile = live.userOperations().getUserProfile();
		values.setProviderUserId(profile.getId());
		values.setDisplayName(profile.getName());
		values.setImageUrl("https://apis.live.net/v5.0/" + profile.getId() + "/picture");
	}

	public UserProfile fetchUserProfile(Live live) {
		LiveProfile profile = live.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getName()).setFirstName(profile.getFirstName())
				.setLastName(profile.getLastName()).build();
	}

	public void updateStatus(Live live, String message) {
		// not yet implemented
	}

}
