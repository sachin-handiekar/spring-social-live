package org.springframework.social.live.api;



public interface UserOperations {

	LiveProfile getUserProfile();

	LiveProfile getUserProfileWithUsername(String userName);

}
