package demo.spring.boot.service;

import demo.spring.boot.dao.MusicDao;
import demo.spring.boot.domain.Music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import java.util.List;
 
@Service
@Transactional
public class MusicServiceImpl implements MusicService {
 
    @Autowired
    private MusicDao musicDao;
 
    @Autowired
    private PlaylistService playlistService;
 
    @Override
    public void save(Music music, long playlistId) {
        music.setPlaylist(playlistService.findById(playlistId));
        musicDao.save(music);
    }
 
    @Override
    @Transactional(readOnly = true)
    public List<Music> findById(long playlistId) {
        return musicDao.findById(playlistId);
    }
 
    @Override
    @Transactional(readOnly = true)
    public Music findByMusic(long playlistId, long musicId) {
        return musicDao.findByMusic(playlistId, musicId);
    }
 
    @Override
    public void update(Music music, long playlistId) {
        music.setPlaylist(playlistService.findById(playlistId));
        musicDao.update(music);
    }
 
    @Override
    public void delete(long playlistId, long musicId) {
        musicDao.delete(findByMusic(playlistId, musicId).getId());
    }
}