package org.springframework.social.live.api.onedrive.impl;

import java.net.URI;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.social.live.api.impl.AbstractLiveOperations;
import org.springframework.social.live.api.onedrive.FilterType;
import org.springframework.social.live.api.onedrive.FriendlyNameOperations;
import org.springframework.social.live.api.onedrive.Metadata;
import org.springframework.social.live.api.onedrive.OneDriveOperations;
import org.springframework.social.live.api.onedrive.UserQuota;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class OneDriveTemplate extends AbstractLiveOperations implements OneDriveOperations {

	private final RestTemplate restTemplate;
	private FriendlyNameOperations friendlynameOperations;
	
	public OneDriveTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
		friendlynameOperations = new FriendlyNameTemplate(restTemplate, isAuthorized);
	}

	@Override
	public UserQuota getUserQuota() {
		return restTemplate.getForObject(buildUri(USER_QUOTA_URL),UserQuota.class);
	}
		
	@Override
	public FriendlyNameOperations friendlyNameOperations() {
		return friendlynameOperations;
	}
	
	@Override
	public Metadata getMetadata(String id) {
		
		return restTemplate.getForObject(buildUri(id), Metadata.class);
	}

	@Override
	public List<Metadata> getMetadata(String folderID, FilterType filterType) {
		
		return listOfMetadata(buildUri(folderID, "filter", filterType.getValue()) );
	}

	@Override
	public List<Metadata> getMetadata(String folderID, int limit) {
		
		return listOfMetadata(buildUri(folderID, "limit", Integer.toString(limit)) );
	}

	@Override
	public List<Metadata> getMetadata(String folderID, int limit, int offset) {
				
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("limit", Integer.toString(limit));
		params.add("offset", Integer.toString(offset));
		
		return listOfMetadata(buildUri(folderID,params));
	}
	
	//private helpers.
		
	private List<Metadata> listOfMetadata(URI uri) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = restTemplate.getForObject(uri, JsonNode.class);
		
		try {
			return objectMapper.readValue(jsonNode, new TypeReference<List<Metadata>>() {});
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * URL Constants.
	 */
	public static final String USER_QUOTA_URL = "me/skydrive/quota";	
}
