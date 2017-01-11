package cn.chan.service.impl;


import cn.chan.dao.AlbumDao;
import cn.chan.entity.Album;
import cn.chan.service.AlbumService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AlbumServiceImpl implements AlbumService{

    private AlbumDao albumDao;

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }


    /**
     * 添加专辑
     * @param album
     */
    @Override
    public void addAlbum(Album album) {

        albumDao.addAlbum(album);

    }
}
