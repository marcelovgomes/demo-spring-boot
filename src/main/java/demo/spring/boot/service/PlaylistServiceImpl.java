package demo.spring.boot.service;

import demo.spring.boot.dao.PlaylistDao;
import demo.spring.boot.domain.Playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import java.util.List;
 
@Service
@Transactional
public class PlaylistServiceImpl implements PlaylistService {
 
    @Autowired
    private PlaylistDao playlistDao;
 
    @Override
    public void save(Playlist playlist) {
        playlistDao.save(playlist);
    }
 
    @Override
    @Transactional(readOnly = true)
    public List<Playlist> findAll() {
        return playlistDao.findAll();
    }
 
    @Override
    @Transactional(readOnly = true)
    public Playlist findById(long id) {
        return playlistDao.findById(id);
    }
 
    @Override
    public void update(Playlist playlist) {
        playlistDao.update(playlist);
    }
 
    @Override
    public void delete(long id) {
        playlistDao.delete(id);
    }
}