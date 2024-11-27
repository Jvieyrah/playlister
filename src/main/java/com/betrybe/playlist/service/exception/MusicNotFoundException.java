package com.betrybe.playlist.service.exception;

public class MusicNotFoundException extends NotFoundException {

  public MusicNotFoundException() {
    super("Música não encontrada!");
  }
}
