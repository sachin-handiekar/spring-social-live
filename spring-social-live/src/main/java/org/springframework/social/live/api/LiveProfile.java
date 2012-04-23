package org.springframework.social.live.api;

import org.codehaus.jackson.annotate.JsonProperty;

public class LiveProfile {

	private final String id;

	private final String name;

	@JsonProperty("first_name")
	private final String firstName;

	@JsonProperty("last_name")
	private final String lastName;

	private final String gender;
	
	private String link;

	private String locale;
	
	@JsonProperty("updated_time")
	private String updatedTime;

	public LiveProfile(String id, String name, String firstName, String lastName, String gender, String locale) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

}
