package demo.spring.boot.dao;

import org.springframework.stereotype.Repository;

import demo.spring.boot.domain.Music;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
 
@Repository
public class MusicDaoImpl implements MusicDao {
 
    @PersistenceContext
    private EntityManager em;
 
    @Override
    public void save(Music music) {
        em.persist(music);
    }
 
    @Override
    public List<Music> findById(long playlistId) {
        return em.createQuery("select m from Music m where m.playlist.id = :playlistId", Music.class)
                .setParameter("playlistId", playlistId)
                .getResultList();
    }
 
    @Override
    public Music findByMusic(long playlistId, long musicId) {
        return em.createQuery("select m from Music m where m.playlist.id = :playlistId and m.id = :musicId", Music.class)
                .setParameter("playlistId", playlistId)
                .setParameter("musicId", musicId)
                .getSingleResult();
    }
 
    @Override
    public void update(Music music) {
        em.merge(music);
    }
 
    @Override
    public void delete(long musicId) {
        em.remove(em.getReference(Music.class, musicId));
    }
 
}