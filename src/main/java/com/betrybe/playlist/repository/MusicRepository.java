package com.betrybe.playlist.repository;

import com.betrybe.playlist.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {

}
