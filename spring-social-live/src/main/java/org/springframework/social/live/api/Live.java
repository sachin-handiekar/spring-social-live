package org.springframework.social.live.api;

import org.springframework.social.live.api.onedrive.OneDriveOperations;

public interface Live {
	
	UserOperations userOperations();
	OneDriveOperations onedriveOperations();
}
