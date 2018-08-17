package demo.spring.boot.dao;

import org.springframework.stereotype.Repository;

import demo.spring.boot.domain.Playlist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
 
@Repository
public class PlaylistDaoImpl implements PlaylistDao {
 
    @PersistenceContext
    private EntityManager em;
 
    @Override
    public void save(Playlist playlist) {
        em.persist(playlist);
    }
 
    @Override
    public List<Playlist> findAll() {
        return em.createQuery("select p from Playlist p", Playlist.class).getResultList();
    }
 
    @Override
    public Playlist findById(long id) {
        return em.find(Playlist.class, id);
    }
 
    @Override
    public void update(Playlist playlist) {
        em.merge(playlist);
    }
 
    @Override
    public void delete(long id) {
        em.remove(em.getReference(Playlist.class, id));
    }
 
}