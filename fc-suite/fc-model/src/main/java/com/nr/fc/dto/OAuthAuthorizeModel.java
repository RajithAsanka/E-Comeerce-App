package com.nr.fc.dto;

import java.io.Serializable;

/**
 * DTO for hold the OAuth authorization attributes.
 * 
 * @author Ruckman Colins S.
 * 
 */
public class OAuthAuthorizeModel implements Serializable {
  
  /* Serial version id. */
  private static final long serialVersionUID = 5507194253010218314L;
  
  /* Unique client id of registered client. */
  private String clientId;
  
  /* Authorization token. */
  private String authorizationToken;
  
  /**
   * @param clientId unique client id;
   * @param authorizationToken authorized token of the client.
   */
  public OAuthAuthorizeModel(final String clientId, final String authorizationToken) {
  
    this.authorizationToken = authorizationToken;
    this.clientId = clientId;
  }
  
  /**
   * @return the clientId
   */
  public String getClientId() {
  
    return clientId;
  }
  
  /**
   * @param clientId the clientId to set
   */
  public void setClientId(final String clientId) {
  
    this.clientId = clientId;
  }
  
  /**
   * @return the authorizationToken
   */
  public String getAuthorizationToken() {
  
    return authorizationToken;
  }
  
  /**
   * @param authorizationToken the authorizationToken to set
   */
  public void setAuthorizationToken(final String authorizationToken) {
  
    this.authorizationToken = authorizationToken;
  }
  
}
