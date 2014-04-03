package org.springframework.social.live.api.onedrive;

/**
 * 
 * OneDrive File/Folder Details.
 * @author Suresh Kumar (yarli4u).
 *
 */

import java.util.Date;

public class Metadata {

	private String id;
	private String name;
	private String description;
	private String parentId;
	private int size;
	private String uploadLocation;
	private int commentsCount;
	private boolean commentsEnabled;
	private boolean isEmbeddable;
	private int count;
	private String link;
	private String type;
	private Date createdTime;
	private Date updatedTime;
	private Date clientUpdatedTime;
	private OwnerDetails ownerdetail;
	private ShareDetails sharedetails;
	
	public Metadata(String id, String name, String description,
			String parentId, int size, String uploadLocation,
			int commentsCount, boolean commentsEnabled, boolean isEmbeddable,
			int count, String link, String type, Date createdTime,
			Date updatedTime, Date clientUpdatedTime, OwnerDetails ownerdetail,
			ShareDetails sharedetails) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
		this.size = size;
		this.uploadLocation = uploadLocation;
		this.commentsCount = commentsCount;
		this.commentsEnabled = commentsEnabled;
		this.isEmbeddable = isEmbeddable;
		this.count = count;
		this.link = link;
		this.type = type;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.clientUpdatedTime = clientUpdatedTime;
		this.ownerdetail = ownerdetail;
		this.sharedetails = sharedetails;
	}
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getParentId() {
		return parentId;
	}
	public int getSize() {
		return size;
	}
	public String getUploadLocation() {
		return uploadLocation;
	}
	public int getCommentsCount() {
		return commentsCount;
	}
	public boolean isCommentsEnabled() {
		return commentsEnabled;
	}
	public boolean isEmbeddable() {
		return isEmbeddable;
	}
	public int getCount() {
		return count;
	}
	public String getLink() {
		return link;
	}
	public String getType() {
		return type;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public Date getClientUpdatedTime() {
		return clientUpdatedTime;
	}
	public OwnerDetails getOwnerdetail() {
		return ownerdetail;
	}
	public ShareDetails getSharedetails() {
		return sharedetails;
	}
	
}
