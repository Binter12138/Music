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


    /**
     * 添加收藏
     * @param userCollection
     */
    @Override
    public void addUserCollection(UserCollection userCollection) {

        hibernateTemplate.save(userCollection);

    }

    /**
     *
     * 查找用户收藏根据用户的id查询该用户收藏的歌曲
     *
     *
     * @param userid
     * @return
     */
    @Override
    public List<UserCollection> findAll(Integer userid) {



        return (List<UserCollection>) hibernateTemplate.find("from UserCollection where userid=?",userid);
    }


    /**
     * 用户取消收藏
     * @param cid
     */
    @Override
    public void deleteCollection(Integer cid) {

        UserCollection userCollection = hibernateTemplate.get(UserCollection.class, cid);
        hibernateTemplate.delete(userCollection);

    }
}
