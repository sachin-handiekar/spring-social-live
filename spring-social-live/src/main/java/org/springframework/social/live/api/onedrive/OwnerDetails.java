package org.springframework.social.live.api.onedrive;

/**
 * 
 * OneDrive File/Folder Details of Owner to whom it belongs to.
 * Name is OneDrive's (Live) UserName and OneDrive's ID.
 * @author Suresh Kumar (yarli4u).
 *
 */

public class OwnerDetails {

	private String name;
	private String id;
	
	public OwnerDetails(String name, String id) {
		
		this.name = name;
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
}
