package demo.spring.boot.controller;

import demo.spring.boot.domain.Music;
import demo.spring.boot.service.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
import javax.validation.Valid;
 
@Controller
@RequestMapping("playlists/{playlistId}/musics")
public class MusicController {
 
    @Autowired
    private MusicService musicService;
 
    @GetMapping("/list")
    public ModelAndView list(@PathVariable("playlistId") long playlistId, ModelMap model) {
        model.addAttribute("musics", musicService.findById(playlistId));
        model.addAttribute("playlistId", playlistId);
        return new ModelAndView("/music/list", model);
    }
 
    @GetMapping("/data")
    public String preSave(@ModelAttribute("music") Music music, @PathVariable("playlistId") long playlistId) {
        return "/music/add";
    }
 
    @PostMapping("/save")
    public String save(@PathVariable("playlistId") long playlistId, @Valid @ModelAttribute("music") 
          Music music, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/music/add";
        }
 
        musicService.save(music, playlistId);
        attr.addFlashAttribute("message", "Music created with success.");
        return "redirect:/playlists/" + playlistId + "/musics/list";
    }
 
    @GetMapping("/{musicId}/update")
    public ModelAndView preUpdate(@PathVariable("playlistId") long playlistId, @PathVariable("musicId") 
          long musicId, ModelMap model) {
        Music music = musicService.findByMusic(playlistId, musicId);
        model.addAttribute("music", music);
        model.addAttribute("playlistId", playlistId);
        return new ModelAndView("/music/add", model);
    }
 
    @PutMapping("/save")
    public ModelAndView update(@PathVariable("playlistId") long playlistId, @Valid @ModelAttribute("music") 
          Music music, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/music/add");
        }
 
        musicService.update(music, playlistId);
        attr.addFlashAttribute("message", "Music updated with success.");
        return new ModelAndView("redirect:/playlists/" + playlistId + "/musics/list");
    }
 
    @GetMapping("/{musicId}/delete")
    public String delete(@PathVariable("playlistId") long playlistId, @PathVariable("musicId") 
          long musicId, RedirectAttributes attr) {
        musicService.delete(playlistId, musicId);
        attr.addFlashAttribute("message", "Music removed with success.");
        return "redirect:/playlists/" + playlistId + "/musics/list";
    }
}