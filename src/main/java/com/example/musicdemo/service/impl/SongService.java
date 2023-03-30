package com.example.musicdemo.service.impl;

import com.example.musicdemo.model.Song1;
import com.example.musicdemo.repository.SongRepo;
import com.example.musicdemo.service.ISongService;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public class SongService implements ISongService<Song1> {
    @Autowired
    private SongRepo songRepoService;


    @Override
    public Iterable<Song1> findAll() {
        return songRepoService.findAll();
    }

    @Override
    public Optional<Song1> findById(Long id) {
        return songRepoService.findById(id);
    }

    @Override
    public void save(Song1 song1) {
        song1.setSong_name(StringEscapeUtils.unescapeHtml4(song1.getSong_name()));
        song1.setSinger(StringEscapeUtils.unescapeHtml4(song1.getSinger()));
        songRepoService.save(song1);
    }

    @Override
    public void remove(Long id) {
        songRepoService.deleteById(id);
    }
}
