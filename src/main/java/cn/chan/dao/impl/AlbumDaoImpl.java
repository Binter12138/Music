package cn.chan.dao.impl;


import cn.chan.dao.AlbumDao;
import cn.chan.entity.Album;
import org.springframework.orm.hibernate4.HibernateTemplate;

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
}
