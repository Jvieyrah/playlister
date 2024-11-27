package com.betrybe.playlist.controller.dto;

import com.betrybe.playlist.entity.Playlist;

public record PlaylistCreationDto(String name) {
  public Playlist toEntity() {
    return Playlist.builder().name(name).build();
  }
}
