package com.cognizatminds.aws.auth.wif;

import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazonaws.services.securitytoken.model.Credentials;


/**
 * @author Shan
 * 
 * Refer below link to get access token using JavaScript/Andriod/iOS
 * https://developers.facebook.com/docs/facebook-login/access-tokens/#apptokens 
 *
 */
public class AuthenticateWithFacebook implements WebIdentityFederation {
	
	private static final String PROVIDER_ID="graph.facebook.com";
	
	private static final String SESSION_NAME="web-identity-federation";
	
	@Override
	public BasicSessionCredentials getSessionCredentials(String userAccessToken, String roleArn) {
		
		AWSSecurityTokenServiceClient sts_client = new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials());
		
		AssumeRoleWithWebIdentityRequest request= new AssumeRoleWithWebIdentityRequest();
		request.setWebIdentityToken(userAccessToken);
		request.setProviderId(PROVIDER_ID);
		request.setRoleArn(roleArn);
		request.setRoleSessionName(SESSION_NAME);
		AssumeRoleWithWebIdentityResult result= sts_client.assumeRoleWithWebIdentity(request);
		Credentials credentials= result.getCredentials();
	
		BasicSessionCredentials sessionCredentials = new BasicSessionCredentials(
				credentials.getAccessKeyId(),
				credentials.getSecretAccessKey(),
				credentials.getSessionToken());

        return sessionCredentials;
		
		
	}
	

	
	

}
