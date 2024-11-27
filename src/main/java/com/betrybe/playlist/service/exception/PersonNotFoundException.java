package com.betrybe.playlist.service.exception;

public class PersonNotFoundException extends NotFoundException{

  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }
}
