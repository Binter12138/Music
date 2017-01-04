package cn.chan.action;

import cn.chan.service.UserCollectionService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.UnsupportedEncodingException;


public class UserCollectionAction extends ActionSupport {
    private String songname;
    private String singername;
    private String songpath;



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

}
