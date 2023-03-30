package com.example.musicdemo.controller;

import com.example.musicdemo.model.Song1;
import com.example.musicdemo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller

public class SongController {

    @Autowired
    private ISongService<Song1> songService;

    @GetMapping("song")
    public ModelAndView songList() {
        Iterable<Song1> song1List = songService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("songList", song1List);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song", new Song1());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public ModelAndView saveSong(@ModelAttribute("song") Song1 song) {
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song", new Song1());
        modelAndView.addObject("message", "New song created successfully. \nBack to list after 3s.");
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Song1> song = songService.findById(id);
        if (song != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("song", song);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping(value = "/edit")
    public ModelAndView updateCustomer(@ModelAttribute("song") Song1 song) {
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("song", song);
        modelAndView.addObject("message", "Song updated successfully. \nBack to list after 3s.");
        return modelAndView;
    }


    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        songService.remove(id);
        return "redirect:/song";
    }
}
