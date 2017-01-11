package cn.chan.service;


import cn.chan.entity.Album;

import java.util.List;

public interface AlbumService {


    public void addAlbum(Album album);


    public List<Album> findAll();

    public void deleteAlbum(Integer aid);



}
