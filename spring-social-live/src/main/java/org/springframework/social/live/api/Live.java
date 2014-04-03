package org.springframework.social.live.api;

import org.springframework.social.live.api.onedrive.OneDriveOperations;
import org.springframework.social.live.api.userinfo.UserOperations;

public interface Live {
	
	UserOperations userOperations();
	OneDriveOperations onedriveOperations();
}
