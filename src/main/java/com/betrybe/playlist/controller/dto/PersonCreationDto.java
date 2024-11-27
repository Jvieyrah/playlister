package com.betrybe.playlist.controller.dto;

import com.betrybe.playlist.entity.Person;
import com.betrybe.playlist.entity.Role;

/**
 * Creation.
 */
public record PersonCreationDto(String username, String password, Role role) {

  /**
   * Person from dto.
   */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }
}
