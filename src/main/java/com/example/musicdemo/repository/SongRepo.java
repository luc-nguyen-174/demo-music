package com.example.musicdemo.repository;

import com.example.musicdemo.model.Song1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SongRepo extends CrudRepository<Song1,Long>, PagingAndSortingRepository<Song1, Long> {

}
