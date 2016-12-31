package cn.chan.action;

import cn.chan.service.UserCollectionService;
import com.opensymphony.xwork2.ActionSupport;


public class UserCollectionAction extends ActionSupport {

    private UserCollectionService userCollectionService;

    public void setUserCollectionService(UserCollectionService userCollectionService) {
        this.userCollectionService = userCollectionService;
    }
}
