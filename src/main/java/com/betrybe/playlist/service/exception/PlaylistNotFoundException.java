package com.betrybe.playlist.service.exception;

public class PlaylistNotFoundException extends NotFoundException{

  public PlaylistNotFoundException() {
    super("Playlist não encontrada!");
  }
}
