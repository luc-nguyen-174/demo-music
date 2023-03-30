package com.example.musicdemo.service;

import com.example.musicdemo.model.Song1;

import java.util.List;
import java.util.Optional;

public interface ISongService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
