package demo.spring.boot.dao;

import java.util.List;

import demo.spring.boot.domain.Music;
 
public interface MusicDao {
 
    void save(Music music);
    List<Music> findById(long playlistId);
    Music findByMusic(long playlistId, long musicId);
    void update(Music music);
    void delete(long musicId);
 
}