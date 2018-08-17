package demo.spring.boot.service;

import java.util.List;

import demo.spring.boot.domain.Playlist;
 
public interface PlaylistService {
 
    void save(Playlist playlist);
    List<Playlist> findAll();
    Playlist findById(long id);
    void update(Playlist playlist);
    void delete(long id);
}