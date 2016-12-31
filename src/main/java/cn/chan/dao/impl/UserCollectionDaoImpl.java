package cn.chan.dao.impl;

import cn.chan.dao.UserCollectionDao;
import cn.chan.entity.UserCollection;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;


public class UserCollectionDaoImpl implements UserCollectionDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 查找用户收藏
     * @param userid
     * @return
     */
    @Override
    public List<UserCollection> findByUser(Integer userid) {
        return null;
    }
}
