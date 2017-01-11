package cn.chan.dao.impl;


import cn.chan.dao.AlbumDao;
import cn.chan.entity.Album;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

public class AlbumDaoImpl implements AlbumDao {


    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 添加专辑
     * @param album
     */
    @Override
    public void addAlbum(Album album) {

        hibernateTemplate.save(album);
    }


    /**
     * 查找所有专辑
     * @return
     */
    @Override
    public List<Album> findAll() {


        return (List<Album>) hibernateTemplate.find("from Album ");
    }


    /**
     * 删除专辑
     * @param aid
     */
    @Override
    public void deleteAlbum(Integer aid) {

        Album album = hibernateTemplate.get(Album.class, aid);
        hibernateTemplate.delete(album);

    }
}
