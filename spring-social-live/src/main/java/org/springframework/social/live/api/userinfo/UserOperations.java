package org.springframework.social.live.api.userinfo;


public interface UserOperations {

	LiveProfile getUserProfile();

	LiveProfile getUserProfileWithUsername(String userName);

}
