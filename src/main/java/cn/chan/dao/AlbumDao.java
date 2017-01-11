package cn.chan.dao;


import cn.chan.entity.Album;

import java.util.List;

public interface AlbumDao {


    public void addAlbum(Album album);

    public List<Album> findAll();

    public void deleteAlbum(Integer aid);



}
