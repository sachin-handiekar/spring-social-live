package org.springframework.social.live.api.onedrive;


/**
 * 
 * OneDrive File/Folder Share Details.
 * If the file or folder is not shared the access will be as "Just Me".
 * @author Suresh Kumar (yarli4u).
 *
 */

public class ShareDetails {

	private String access;
	
	public ShareDetails(String access) {
		
		this.access = access;
	}

	public String getAccess() {
		return access;
	}
	
}
