package io.vertx.ext.auth.oauth2.providers;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.oauth2.OAuth2ClientOptions;
import io.vertx.ext.auth.oauth2.OAuth2FlowType;

/**
 * Simplified factory to create an {@link OAuth2Auth} for SoundCloud.
 *
 * @author <a href="mailto:plopes@redhat.com">Paulo Lopes</a>
 */
@VertxGen
public interface SoundcloudAuth {

  /**
   * Create a OAuth2Auth provider for SoundCloud
   *
   * @param clientId     the client id given to you by SoundCloud
   * @param clientSecret the client secret given to you by SoundCloud
   */
  static OAuth2Auth create(Vertx vertx, String clientId, String clientSecret) {
    return create(vertx, clientId, clientSecret, new HttpClientOptions());
  }

  /**
   * Create a OAuth2Auth provider for SoundCloud
   *
   * @param clientId          the client id given to you by SoundCloud
   * @param clientSecret      the client secret given to you by SoundCloud
   * @param httpClientOptions custom http client options
   */
  static OAuth2Auth create(Vertx vertx, String clientId, String clientSecret, HttpClientOptions httpClientOptions) {
    return
      OAuth2Auth.create(vertx, new OAuth2ClientOptions(httpClientOptions)
        .setFlow(OAuth2FlowType.AUTH_CODE)
        .setClientID(clientId)
        .setClientSecret(clientSecret)
        .setSite("https://api.soundcloud.com")
        .setTokenPath("/oauth2/token")
        .setAuthorizationPath("/connect")
        .setUserInfoPath("/me.json"));
  }
}
