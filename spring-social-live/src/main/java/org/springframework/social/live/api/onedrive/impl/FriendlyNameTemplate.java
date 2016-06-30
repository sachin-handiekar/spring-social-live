package org.springframework.social.live.api.onedrive.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.social.live.api.impl.AbstractLiveOperations;
import org.springframework.social.live.api.onedrive.FriendlyNameOperations;
import org.springframework.social.live.api.onedrive.Metadata;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FriendlyNameTemplate extends AbstractLiveOperations implements FriendlyNameOperations {

	private final RestTemplate restTemplate;
	
	public FriendlyNameTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(isAuthorized);
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<Metadata> getCameraRoll() {

		return listOfMetadata(ME_CAMERA_ROLL_URL);		
	}

	@Override
	public List<Metadata> getMyDocuments() {
		
		return listOfMetadata(ME_DOCUMENTS_URL);
	}

	@Override
	public List<Metadata> getMyPhotos() {
		
		return listOfMetadata(ME_PHOTOS_URL);
	}

	@Override
	public List<Metadata> getPublicDocuments() {
		
		return listOfMetadata(ME_PUBLIC_DOCUMENTS_URL);
	}

	@Override
	public List<Metadata> getRecentDocuments() {
		
		return listOfMetadata(ME_RECENT_DOCUMENTS_URL);
	}

	
	@Override
	public List<Metadata> getRootContents() {

		return listOfMetadata(ME_ROOT_CONTENTS_URL);
	}

	@Override
	public Metadata getOnedriveDirectory() {

		return restTemplate.getForObject(buildUri(ME_ONERIVE_DETAILS_URL), Metadata.class);
	}

	
	@Override
	public List<Metadata> getSharedDocuments() {
		return listOfMetadata(ME_SHARED_DOCUMENTS_URL);
	}

	//private helpers.
	private List<Metadata> listOfMetadata(String path) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = restTemplate.getForObject(buildUri(path), String.class);
		
		try {
			JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Metadata.class);
			return objectMapper.readValue(json, type);
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
		
	//URL Constants.
	public static final String ME_DOCUMENTS_URL="me/skydrive/my_documents";
	public static final String ME_CAMERA_ROLL_URL="me/skydrive/camera_roll";
	public static final String ME_PHOTOS_URL="me/skydrive/my_photos";
	public static final String ME_PUBLIC_DOCUMENTS_URL="me/skydrive/public_documents";
	public static final String ME_RECENT_DOCUMENTS_URL="me/skydrive/recent_docs";
	public static final String ME_ROOT_CONTENTS_URL="me/skydrive/files";
	public static final String ME_ONERIVE_DETAILS_URL="me/skydrive";
	public static final String ME_SHARED_DOCUMENTS_URL="me/skydrive/shared";
}