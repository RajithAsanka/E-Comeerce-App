package com.nr.fc.dto;

import java.io.Serializable;

import com.nr.fc.model.User;

/**
 * DTO for hold the OAuth access attributes.
 *
 * @author Ruckman Colins S.
 *
 */
public class OAuthAccessModel implements Serializable {

    /* Serial version id. */
    private static final long serialVersionUID = -5050169948580760315L;

    /* Unique id for client. */
    private String clientId;

    /* Specify the password of the client. */
    private String clientSecret;

    /* Authorized token for access the resource. */
    private String authorizationToken;

    /* Access token for access the resource(WS). */
    private String accessToken;

    /* Authorized user object. */
    private User user;

    /**
     * @param clientId Unique id for client
     * @param clientSecret Specify the password of the client.
     * @param authorizationToken Authorized token for access the resource.
     * @param accessToken Access token for access the resource(WS).
     * @param user Authorized user object.
     */
    public OAuthAccessModel(final String clientId, final String clientSecret, final String authorizationToken,
            final String accessToken, final User user) {

        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizationToken = authorizationToken;
        this.accessToken = accessToken;
        this.user = user;

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
     * @return the clientSecret
     */
    public String getClientSecret() {

        return clientSecret;
    }

    /**
     * @param clientSecret the clientSecret to set
     */
    public void setClientSecret(final String clientSecret) {

        this.clientSecret = clientSecret;
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

    /**
     * @return the accessToken
     */
    public String getAccessToken() {

        return accessToken;
    }

    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(final String accessToken) {

        this.accessToken = accessToken;
    }

    /**
     * @return the user
     */
    public User getUser() {

        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {

        this.user = user;
    }

}
