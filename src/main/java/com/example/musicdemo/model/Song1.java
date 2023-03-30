package com.example.musicdemo.model;

import javax.persistence.*;

@Entity
@Table
public class Song1{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String song_name;
    private String singer;
    private String kind;
    private String url_link;

    public Song1() {
    }

    public Song1(String song_name, String singer, String kind, String url_link) {
        this.song_name = song_name;
        this.singer = singer;
        this.kind = kind;
        this.url_link = url_link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getUrl_link() {
        return url_link;
    }

    public void setUrl_link(String url_link) {
        this.url_link = url_link;
    }

    @Override
    public String toString() {
        return "Song1{" +
                "id=" + id +
                ", song_name='" + song_name + '\'' +
                ", singer='" + singer + '\'' +
                ", kind='" + kind + '\'' +
                ", url_link='" + url_link + '\'' +
                '}';
    }
}
