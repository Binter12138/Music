package cn.chan.dao.impl;

import cn.chan.dao.UserDao;
import cn.chan.entity.User;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;


public class UserDaoImpl implements UserDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 注册用户
     * @param user
     */
    public void regist(User user) {


       /* Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            HibernateUtil.closeSession();
        }*/


       hibernateTemplate.save(user);
    }


    /**
     * 用户登录
     * @param username
     * @return
     */

    public List<User> login(String username) {


        /*Session session = HibernateUtil.getSession();
        String hql = "from User u where u.username=:username";
        Query query = session.createQuery(hql);
        query.setString("username",username);
        User user = (User) query.uniqueResult();*/
        List<User> user = (List<User>) hibernateTemplate.find("from User where username=?", username);


        return user;
    }


    /**
     * 查找所有的用户
     * @return
     */
    public List<User> findAll() {

       /* Session session = HibernateUtil.getSession();
        String hql = "from User ";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();*/



        return (List<User>) hibernateTemplate.find("from User");
    }

    /**
     * 用户激活
     * @param userId
     * @param state
     */
    @Override
    public void updateState(Integer userId, Boolean state) {

       /* Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            user.setState(true);
            session.update(user);


            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            HibernateUtil.closeSession();
        }*/
        User user = hibernateTemplate.get(User.class, userId);
        user.setState(true);


    }

    /**
     *检查用户名是否存在
     * @param username
     * @return
     */
    @Override
    public List<User> checkUsername(String username) {


        /*Session session = HibernateUtil.getSession();
        String hql = "from User u where u.username=:username";
        Query query = session.createQuery(hql);
        query.setString("username",username);
        User user = (User) query.uniqueResult();*/
        List<User> userList = (List<User>) hibernateTemplate.find("from User u where u.username=?",username);

        return userList;

    }


    /**
     * 检查邮箱是否存在
     * @param email
     * @return
     */
    @Override
    public List<User> checkEmail(String email) {

/*
        Session session = HibernateUtil.getSession();
        String hql = "from User u where u.email=:email";
        Query query = session.createQuery(hql);
        query.setString("email",email);
        User user = (User) query.uniqueResult();*/
        List<User> userList = (List<User>) hibernateTemplate.find("from User u where u.email=?", email);

        return userList;

    }

    /**
     * 删除用户
     * @param uid
     * @return
     */
    @Override
    public Boolean delUser(Integer uid) {
/*
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            User user = (User) session.get(User.class,uid);
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            HibernateUtil.closeSession();
        }*/

        User user = hibernateTemplate.get(User.class, uid);
        hibernateTemplate.delete(user);
        return true;
    }


}
