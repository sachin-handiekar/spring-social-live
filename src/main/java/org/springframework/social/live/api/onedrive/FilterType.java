package org.springframework.social.live.api.onedrive;

public enum FilterType {
	
	ALL("all"),
	PHOTOS("photos"),
	VIDEOS("videos"),
	AUDIO("audio"),
	FOLDERS("folders"),
	ALBUMS("albums");
	
	private String value;
	
	private FilterType(String value) {
		this.value = value;
	}
	
	public String getValue() { return value;}

}
