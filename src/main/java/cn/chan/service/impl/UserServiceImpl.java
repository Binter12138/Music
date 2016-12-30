package cn.chan.service.impl;

import cn.chan.dao.UserDao;
import cn.chan.entity.User;
import cn.chan.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 注册用户
     * @param user
     */
    public void regist(User user) {
        userDao.regist(user);
    }

    /**
     * 用户登录
     * @param form
     * @return
     */
    public User login(User form) {

        List<User> user = userDao.login(form.getUsername());
        if(user.size() == 0)return null;
        else if(!user.get(0).getPassword().equals(form.getPassword()))return null;

        System.out.println(user.get(0));
        return user.get(0);
    }

    /**
     * 查找所有的用户
     * @return
     */
    public List<User> findAll() {
        List<User> userList = userDao.findAll();

        return userList;
    }


    /**
     * 用户激活
     * @param userId
     */
    @Override
    public void updateState(Integer userId) {
        userDao.updateState(userId,true);
    }


    /**
     * 检查用户是否存在
     * @param username
     * @return
     */
    @Override
    public User checkUsername(String username) {

        List<User> userList = userDao.checkUsername(username);
        if(userList.size() == 0)
        {

            return null;
        }else{
            return userList.get(0);
        }
    }


    /**
     * 验证邮箱是否存在
     * @param email
     * @return
     */
    @Override
    public User checkEmail(String email) {

        List<User> userList = userDao.checkEmail(email);
        if(userList.size() == 0)
        {
            return null;
        }else {

            return userList.get(0);
        }
    }

    /**
     *
     * @param uid
     * @return
     */
    @Override
    public Boolean delUser(Integer uid) {

        try {
            userDao.delUser(uid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
