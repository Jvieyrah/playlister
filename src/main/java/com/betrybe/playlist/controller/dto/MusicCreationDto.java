package com.betrybe.playlist.controller.dto;

import com.betrybe.playlist.entity.Music;

public record MusicCreationDto(String musicName, String singer) {
  public Music toEntity() {
    Music music = new Music();
    music.setMusicName(musicName);
    music.setSinger(singer);
    return music;
  }

}
