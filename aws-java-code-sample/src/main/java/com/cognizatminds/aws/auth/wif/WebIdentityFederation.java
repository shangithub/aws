package com.cognizatminds.aws.auth.wif;

import com.amazonaws.auth.BasicSessionCredentials;

public interface WebIdentityFederation {
	
	public BasicSessionCredentials getSessionCredentials(String userAccessToken, String roleArn);

}
