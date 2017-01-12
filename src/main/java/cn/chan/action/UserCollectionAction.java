package cn.chan.action;

import cn.chan.entity.UserCollection;
import cn.chan.service.UserCollectionService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.UnsupportedEncodingException;
import java.util.List;


public class UserCollectionAction extends ActionSupport {

    private UserCollection userCollection;
    private String songname;
    private String singername;
    private String songpath;
    private String singerimage;
    private String username;
    private Integer userid;
    private Integer cid;//用户收藏的id
    private List<UserCollection> userCollectionList;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public List<UserCollection> getUserCollectionList() {
        return userCollectionList;
    }

    public void setUserCollectionList(List<UserCollection> userCollectionList) {
        this.userCollectionList = userCollectionList;
    }

    public UserCollection getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(UserCollection userCollection) {
        this.userCollection = userCollection;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSingerimage() {
        return singerimage;
    }

    public void setSingerimage(String singerimage) {
        this.singerimage = singerimage;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public String getSongpath() {
        return songpath;
    }

    public void setSongpath(String songpath) {
        this.songpath = songpath;
    }

    private UserCollectionService userCollectionService;

    public void setUserCollectionService(UserCollectionService userCollectionService) {
        this.userCollectionService = userCollectionService;
    }

    public String play()
    {

        try {
            this.songname = new String(songname.getBytes("ISO8859-1"),"utf-8");
            this.singername = new String(singername.getBytes("ISO8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return "play";
    }

    public String addUserCollection()
    {
        try {
            this.songname = new String(songname.getBytes("ISO8859-1"),"utf-8");
            this.singername = new String(singername.getBytes("ISO8859-1"),"utf-8");
            this.username = new String(username.getBytes("ISO8859-1"),"utf-8");

            if(null == username || username == "" || userid == null)
            {


                return "addtoLogin";
            }
            else{
                userCollection.setSingername(singername);
                userCollection.setSongname(songname);
                userCollection.setSongpath(songpath);
                userCollection.setUserid(userid);
                userCollection.setUsername(username);
                userCollectionService.addUserCollection(userCollection);
                return "collectionadd";
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public String userCollection()
    {

        if(userid == null)
        {
            return "Collectiontologin";

        }
        else {

            userCollectionList = userCollectionService.findAll(userid);
            return "userCollection";
        }

    }


    public String delete()
    {

        userCollectionService.deleteCollection(cid);


        return "delete";


    }



}
