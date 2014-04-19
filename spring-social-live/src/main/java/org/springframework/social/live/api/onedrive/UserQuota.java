package org.springframework.social.live.api.onedrive;

import java.math.BigInteger;

/**
 * 
 * OneDrive Space Details.
 * @author Suresh Kumar (yarli4u).
 *
 */

public class UserQuota {

	private BigInteger quota;
	private BigInteger available;
	
	public UserQuota(BigInteger quota, BigInteger available) {
		this.quota = quota;
		this.available = available;
	}

	public BigInteger getQuota() {
		return quota;
	}

	public BigInteger getAvailable() {
		return available;
	}
	
}
