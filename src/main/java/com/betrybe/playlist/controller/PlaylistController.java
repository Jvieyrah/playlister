package com.betrybe.playlist.controller;

import com.betrybe.playlist.controller.dto.PlaylistCreationDto;
import com.betrybe.playlist.entity.Music;
import com.betrybe.playlist.entity.Playlist;
import com.betrybe.playlist.service.MusicService;
import com.betrybe.playlist.service.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

  private final PlaylistService playlistService;
  private final MusicService musicService;

  @Autowired
  public PlaylistController(PlaylistService playlistService, MusicService musicService) {
    this.playlistService = playlistService;
    this.musicService = musicService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Playlist create(@RequestBody PlaylistCreationDto dto) {
    return playlistService.create(dto.toEntity());
  }

  @GetMapping
  public List<Playlist> findAll() {
    return playlistService.findAll();
  }

  @GetMapping("/{playlistId}")
  public Playlist findById(@PathVariable long playlistId) {
    return playlistService.findById(playlistId);
  }

  @PatchMapping("/{playlistId}")
  public Playlist update(@PathVariable long playlistId, @RequestBody PlaylistCreationDto dto) {
    return playlistService.update(playlistId, dto.toEntity());
  }

  @DeleteMapping("/{playlistId}")
  public void delete(@PathVariable long playlistId) {
    playlistService.delete(playlistId);
  }

  @PostMapping("/{playlistId}/{musicId}")
  @ResponseStatus(HttpStatus.CREATED)
  public Playlist addMusic(@PathVariable long playlistId,
      @PathVariable long musicId) {
    return playlistService.addMusicToPlaylist(musicId, playlistId);
  }

  @GetMapping("/{playlistId}/musics")
  public List<Music> getMusics(@PathVariable Long playlistId) {
    return playlistService.findById(playlistId).getMusics();
  }
}
