package org.springframework.social.live.api.onedrive;

import java.util.List;

/**
 * 
 * OneDrive Interface.
 * @author Suresh Kumar (yarli4u).
 *
 */

public interface OneDriveOperations {

	/**
	 * This function returns User's Quota for Onedrive, i.e., available size and quota. 
	 * @return UserQuota Object.
	 */
	UserQuota getUserQuota();

	/**
	 * 
	 * @return FriendlyNameOperations
	 */
	FriendlyNameOperations friendlyNameOperations();
	
	/**
	 * Retrieve Folder or File Properties using FOLDER_ID or FILE_ID.
	 * 
	 * @return Metadata Object.
	 */
	
	Metadata getMetadata(String id);
	
	/**
	 * Retrieve only certain type of items using <i>filter</i> parameter.
	 */
	List<Metadata> getMetadata(String folderID,FilterType filterType);
	
	/**
	 * Retrieve limited no of items using <i>limit</i> parameter.
	 */
	List<Metadata> getMetadata(String folderID, int limit);
	
	/**
	 * Retrieve items from specified position using 
	 * the <i>offset</i> paramter along with <i>limit</i> parameter.
	 */
	List<Metadata> getMetadata(String folderID, int limit,int offset);	
}
