package demo.spring.boot.controller;

import demo.spring.boot.domain.Playlist;
import demo.spring.boot.service.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
import javax.validation.Valid;
 
@Controller
@RequestMapping("playlists")
public class PlaylistController {
 
    @Autowired
    private PlaylistService playlistService;
 
    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("playlists", playlistService.findAll());
        return new ModelAndView("/playlist/list", model);
    }
 
    @GetMapping("/data")
    public String preSave(@ModelAttribute("playlist") Playlist playlist) {
        return "/playlist/add";
    }
 
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/playlist/add";
        }
 
        playlistService.save(playlist);
        attr.addFlashAttribute("message", "Playlist created with success.");
        return "redirect:/playlists/list";
    }
 
    @GetMapping("/{id}/update")
    public ModelAndView preUpdate(@PathVariable("id") long id, ModelMap model) {
        Playlist playlist = playlistService.findById(id);
        model.addAttribute("playlist", playlist);
        return new ModelAndView("/playlist/add", model);
    }
 
    @PutMapping("/save")
    public ModelAndView update(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/playlist/add");
        }
 
        playlistService.update(playlist);
        attr.addFlashAttribute("message", "Playlist updated with success.");
        return new ModelAndView("redirect:/playlists/list");
    }
 
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id, RedirectAttributes attr) {
        playlistService.delete(id);
        attr.addFlashAttribute("message", "Playlist removed with success.");
        return "redirect:/playlists/list";
    }
}