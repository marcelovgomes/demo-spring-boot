package demo.spring.boot.dao;

import java.util.List;

import demo.spring.boot.domain.Playlist;
 
public interface PlaylistDao {
 
    void save(Playlist playlist);
    List<Playlist> findAll();
    Playlist findById(long id);
    void update(Playlist playlist);
    void delete(long id);
 
}