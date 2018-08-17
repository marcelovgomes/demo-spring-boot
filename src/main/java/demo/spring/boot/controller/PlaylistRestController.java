package demo.spring.boot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import demo.spring.boot.domain.Playlist;
import demo.spring.boot.service.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistRestController {
	
	@Autowired
	private PlaylistRepository playlistRepository;

	@GetMapping("/playlist")
	public List<Playlist> retrieveAllPlaylists() {
		return playlistRepository.findAll();
	}
}