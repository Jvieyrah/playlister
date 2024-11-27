package com.betrybe.playlist.controller;

import com.betrybe.playlist.controller.dto.MusicCreationDto;
import com.betrybe.playlist.entity.Music;
import com.betrybe.playlist.service.MusicService;
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
@RequestMapping("/musics")
public class MusicController {
  private final MusicService musicService;

  @Autowired
  public MusicController(MusicService musicService) {
    this.musicService = musicService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Music create(@RequestBody MusicCreationDto musicCreationDto) {
    Music music = musicCreationDto.toEntity();
    return musicService.create(music);
  }

  @GetMapping
  public List<Music> findAll() {
    return musicService.findAll();
  }

  @GetMapping("/{musicId}")
  public Music findById(@PathVariable long musicId) {
    return musicService.findById(musicId);
  }

  @PatchMapping("/{musicId}")
  public Music update(@PathVariable long musicId, @RequestBody MusicCreationDto dto) {
    return musicService.update(musicId, dto.toEntity());
  }

  @DeleteMapping("/{musicId}")
  public void delete(@PathVariable long musicId) {
    musicService.delete(musicId);
  }
}
