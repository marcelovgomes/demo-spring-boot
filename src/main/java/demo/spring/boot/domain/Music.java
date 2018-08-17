package demo.spring.boot.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
 
import javax.persistence.*;
import javax.validation.constraints.Size;
 
@Entity
@Table(name = "musics")
public class Music {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String name;
 
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String singer;
 
    @Range(min = 0, max = 10)
    @Column(nullable = false)
    private int grade;
 
    @ManyToOne
    @JoinColumn(name = "id_playlist_fk")
    private Playlist playlist;
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getSinger() {
        return singer;
    }
 
    public void setSinger(String singer) {
        this.singer = singer;
    }
 
    public int getGrade() {
        return grade;
    }
 
    public void setGrade(int grade) {
        this.grade = grade;
    }
 
    public Playlist getPlaylist() {
        return playlist;
    }
 
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}