package io.vertx.ext.auth.webauthn.impl.attestation;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.webauthn.impl.AuthenticatorData;

public class PackedAttestation implements Attestation {

  @Override
  public String fmt() {
    return "packed";
  }

  @Override
  public boolean verify(JsonObject webAuthnResponse, byte[] clientDataJSON, JsonObject ctapMakeCredResp, AuthenticatorData authr) throws AttestationException {
    throw new AttestationException("Attestation Not Implemented");
  }
}
