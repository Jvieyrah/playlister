package com.betrybe.playlist.service;

import com.betrybe.playlist.entity.Music;
import com.betrybe.playlist.entity.Playlist;
import com.betrybe.playlist.repository.PlaylistRepository;
import com.betrybe.playlist.service.exception.PlaylistNotFoundException;
import com.betrybe.playlist.util.PropertyMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PlaylistService {
  private final PlaylistRepository playlistRepository;
  private final MusicService musicService;

  @Autowired
  public PlaylistService(PlaylistRepository playlistRepository, MusicService musicService) {
    this.playlistRepository = playlistRepository;
    this.musicService = musicService;
  }

  public List<Playlist> findAll() {
    return playlistRepository.findAll();
  }

  public Playlist create(Playlist playlist) {
    return playlistRepository.save(playlist);
  }

  public Playlist findById(long id) {
    return playlistRepository.findById(id).orElseThrow(PlaylistNotFoundException::new);
  }

  public void delete(long id) {
    playlistRepository.deleteById(id);
  }

  public Playlist update(long id, Playlist playlist) {
    Playlist playlistDb = findById(id);
    PropertyMapper.copyNonNullProperties(playlist, playlistDb);
    return playlistRepository.save(playlistDb);
  }

  public Playlist addMusicToPlaylist(long musicId, long playlistId) {

    Music music = musicService.findById(musicId);
    Playlist playlist = findById(playlistId);
    playlist.getMusics().add(music);
    music.setPlaylist(playlist);

    return playlistRepository.save(playlist);

  }

}
