package org.springframework.social.live.api.impl;

import org.springframework.social.MissingAuthorizationException;

class AbstractLiveOperations {
	private final boolean isAuthorized;

	public AbstractLiveOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException();
		}
	}

	protected String buildUri(String path) {
		return API_URL_BASE + path;
	}

	private static final String API_URL_BASE = "https://apis.live.net/v5.0/";

}
