package org.springframework.social.live.config;

import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.live.api.Live;

public class LiveApiHelper implements ApiHelper<Live> {

	private final UsersConnectionRepository usersConnectionRepository;

	private final UserIdSource userIdSource;
	
	public LiveApiHelper(UsersConnectionRepository usersConnectionRepository,UserIdSource userIdSource) {
		
		this.usersConnectionRepository = usersConnectionRepository;
		this.userIdSource = userIdSource;
	}
	
	@Override
	public Live getApi() {
		
		Connection<Live> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).
										findPrimaryConnection(Live.class);
		
		return connection != null ? connection.getApi() : null;
	}

}
