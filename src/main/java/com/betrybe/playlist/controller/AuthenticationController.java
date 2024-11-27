package com.betrybe.playlist.controller;

import com.betrybe.playlist.controller.dto.AuthResponseDto;
import com.betrybe.playlist.controller.dto.AuthenticationDto;
import com.betrybe.playlist.controller.dto.PersonCreationDto;
import com.betrybe.playlist.controller.dto.PersonResponseDto;
import com.betrybe.playlist.entity.Person;
import com.betrybe.playlist.service.PersonService;
import com.betrybe.playlist.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;

  private final PersonService personService;
  private final TokenService tokenService;

  @Autowired
  public AuthenticationController(AuthenticationManager authenticationManager,
      PersonService personService, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.personService = personService;
    this.tokenService = tokenService;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public PersonResponseDto register(@RequestBody PersonCreationDto dto) {
    Person person = personService.insert(dto.toEntity());
    return PersonResponseDto.fromEntity(person);
  }

  @PostMapping("/login")
  public AuthResponseDto login(@RequestBody AuthenticationDto authRequestDto) {

    UsernamePasswordAuthenticationToken usernamePassword =
        new UsernamePasswordAuthenticationToken(
            authRequestDto.username(), authRequestDto.password());

    Authentication authenticate = authenticationManager.authenticate(usernamePassword);
    Person person = (Person) authenticate.getPrincipal();

    String token = tokenService.generateToken(person);

    return new AuthResponseDto(token);
  }
}
