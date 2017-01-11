package cn.chan.service;


import cn.chan.entity.UserCollection;

import java.util.List;

public interface UserCollectionService {


    public List<UserCollection> findByUser(Integer userid);


    public void addUserCollection(UserCollection userCollection);

}
