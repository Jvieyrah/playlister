package com.betrybe.playlist.repository;

import com.betrybe.playlist.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface PersonRepository extends JpaRepository<Person, Long> {
  Person findByUsername(String username);
}
