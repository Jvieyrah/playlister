package com.betrybe.playlist.service;

import com.betrybe.playlist.entity.Music;
import com.betrybe.playlist.repository.MusicRepository;
import com.betrybe.playlist.service.exception.MusicNotFoundException;
import com.betrybe.playlist.util.PropertyMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {
  private final MusicRepository musicRepository;

  @Autowired
  public MusicService(MusicRepository musicRepository) {
    this.musicRepository = musicRepository;
  }

  public List<Music> findAll() {
    return musicRepository.findAll();
  }

  public Music create(Music music) {
    return musicRepository.save(music);
  }

  public Music findById(long musicId) {
    return musicRepository.findById(musicId)
        .orElseThrow(MusicNotFoundException::new);
  }

  public void delete(long musicId) {
    musicRepository.deleteById(musicId);
  }

  public Music update(long id, Music music) {
    Music musicDb = findById(id);
    PropertyMapper.copyNonNullProperties(music, musicDb);

    return musicRepository.save(musicDb);
  }

}
