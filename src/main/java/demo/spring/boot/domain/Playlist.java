package demo.spring.boot.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
 
@Entity
@Table(name = "playlists")
public class Playlist {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @NotBlank
    @Size(min = 2, max = 60)
    @Column(nullable = false, length = 60)
    private String name;
 
    @NotBlank
    @Column(nullable = false)
    private String description;
 
    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<Music> musics;
 
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
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public List<Music> getMusics() {
        return musics;
    }
 
    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Playlist(long id, String name, String description, List<Music> musics) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.musics = musics;
	}
}