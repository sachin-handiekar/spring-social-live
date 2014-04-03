package org.springframework.social.live.api.onedrive.impl;

import org.springframework.social.live.api.impl.AbstractLiveOperations;
import org.springframework.social.live.api.onedrive.OneDriveOperations;
import org.springframework.social.live.api.onedrive.UserQuota;
import org.springframework.web.client.RestTemplate;

public class OneDriveTemplate extends AbstractLiveOperations implements OneDriveOperations {

	private final RestTemplate restTemplate;
	
	public OneDriveTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
	}

	@Override
	public UserQuota getUserQuota() {
		return restTemplate.getForObject(buildUri(USER_QUOTA_URL),UserQuota.class);
	}

	/**
	 * URL Constants.
	 */
	public static final String USER_QUOTA_URL = "me/skydrive/quota";
	public static final String ME_DOCUMENTS_URL="/me/skydrive/my_documents";
	public static final String ME_CAMERA_ROLL_URL="/me/skydrive/camera_roll";
	public static final String ME_PHOTOS_URL="/me/skydrive/my_photos";
	public static final String ME_PUBLIC_DOCUMENTS_URL="/me/skydrive/public_documents";
	public static final String ME_RECENT_DOCUMENTS_URL="/me/skydrive/recent_docs";
	public static final String ME_ROOT_CONTENTS_URL="me/skydrive/files";
	public static final String ME_ONERIVE_DETAILS_URL="me/skydrive";
	public static final String ME_SHARED_DOCUMENTS_URL="me/skydrive/shared";
}
