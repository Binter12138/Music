package cn.chan.action;

import cn.chan.entity.UserCollection;
import cn.chan.service.UserCollectionService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.UnsupportedEncodingException;


public class UserCollectionAction extends ActionSupport {

    private UserCollection userCollection;
    private String songname;
    private String singername;
    private String songpath;
    private String singerimage;
    private String username;
    private Integer userid;

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


                return "toLogin";
            }
            else{
                userCollection.setSingername(singername);
                userCollection.setSongname(songname);
                userCollection.setSongpath(songpath);
                userCollection.setUserid(userid);
                userCollection.setUsername(username);
                userCollectionService.addUserCollection(userCollection);
                return NONE;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
