package com.betrybe.playlist.controller.dto;

import com.betrybe.playlist.entity.Person;
import com.betrybe.playlist.entity.Role;

public record PersonResponseDto(Long id, String username, Role role) {
  public static PersonResponseDto fromEntity(Person person) {
    return new PersonResponseDto(person.getId(), person.getUsername(),
        person.getRole());
  }
}
