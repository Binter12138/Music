package cn.chan.service.impl;


import cn.chan.dao.UserCollectionDao;
import cn.chan.entity.UserCollection;
import cn.chan.service.UserCollectionService;

import java.util.List;

public class UserCollectionServiceImpl implements UserCollectionService{

    private UserCollectionDao userCollectionDao;

    public void setUserCollectionDao(UserCollectionDao userCollectionDao) {
        this.userCollectionDao = userCollectionDao;
    }

    @Override
    public List<UserCollection> findByUser(Integer userid) {
        return null;
    }
}
