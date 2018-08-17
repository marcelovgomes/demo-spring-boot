package demo.spring.boot.service;

import java.util.List;

import demo.spring.boot.domain.Music;
 
public interface MusicService {
 
    void save(Music music, long playlistId);
    List<Music> findById(long playlistId);
    Music findByMusic(long playlistId, long musicId);
    void update(Music music, long playlistId);
    void delete(long playlistId, long musicaId);
}