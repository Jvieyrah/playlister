package com.betrybe.playlist.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.betrybe.playlist.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Token Service.
 */
@Service
public class TokenService {

  private final Algorithm algorithm;

  /**
   * Constructor.
   */
  public TokenService(@Value("${playlist.security.token.secret}") String secret) {
    algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * Generate token.
   */
  public String generateToken(Person person) {
    return JWT.create()
        .withIssuer("playlist")
        .withSubject(person.getUsername())
        .sign(algorithm);
  }

  public String validateToken(String token) {
    return JWT.require(algorithm)
        .withIssuer("playlist")
        .build()
        .verify(token)
        .getSubject();
  }
}
