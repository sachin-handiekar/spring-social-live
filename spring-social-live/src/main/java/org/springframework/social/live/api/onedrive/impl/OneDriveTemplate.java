package org.springframework.social.live.api.onedrive.impl;

import org.springframework.social.live.api.impl.AbstractLiveOperations;
import org.springframework.social.live.api.onedrive.FriendlyNameOperations;
import org.springframework.social.live.api.onedrive.OneDriveOperations;
import org.springframework.social.live.api.onedrive.UserQuota;
import org.springframework.web.client.RestTemplate;

public class OneDriveTemplate extends AbstractLiveOperations implements OneDriveOperations {

	private final RestTemplate restTemplate;
	private FriendlyNameOperations friendlynameOperations;
	
	public OneDriveTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
		friendlynameOperations = new FriendlyNameTemplate(restTemplate, isAuthorized);
	}

	@Override
	public UserQuota getUserQuota() {
		return restTemplate.getForObject(buildUri(USER_QUOTA_URL),UserQuota.class);
	}
		
	@Override
	public FriendlyNameOperations friendlyNameOperations() {
		return friendlynameOperations;
	}

	/**
	 * URL Constants.
	 */
	public static final String USER_QUOTA_URL = "me/skydrive/quota";

}
