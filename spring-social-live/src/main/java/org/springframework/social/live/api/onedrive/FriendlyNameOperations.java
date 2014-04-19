package org.springframework.social.live.api.onedrive;

import java.util.List;

/**
 * Accessing OneDrive folders using Friendly Names.
 * 
 * @author Suresh Kumar (yarli4u).
 *
 */
public interface FriendlyNameOperations {

	List<Metadata> getRootContents();
	Metadata getOnedriveDirectory();
	List<Metadata> getCameraRoll();
	List<Metadata> getMyDocuments();
	List<Metadata> getMyPhotos();
	List<Metadata> getPublicDocuments();
	List<Metadata> getRecentDocuments();
	List<Metadata> getSharedDocuments();
	
}
