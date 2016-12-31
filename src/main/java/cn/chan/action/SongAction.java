package cn.chan.action;

import cn.chan.entity.Song;
import cn.chan.service.SongService;
import com.opensymphony.xwork2.ActionSupport;

import java.io.UnsupportedEncodingException;
import java.util.List;


public class SongAction extends ActionSupport {

    private Song song;
    private List<Song> songList;
    private String sname;
    private SongService songService;
    private Integer sid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public void setSongService(SongService songService) {
        this.songService = songService;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }




    public String add()
    {

        song.setSingerid(sid);

        songService.addSong(song);


        return "addSong";
    }



    /**
     * 遍历所有歌曲
     * @return
     */
    public String allSong()
    {
        songList = songService.findAll();


        return "allSong";


    }




    /**
     * 查找
     * @return
     */
    public String findSong()
    {

        try {
            String n = new String(sname.getBytes("ISO-8859-1"),"utf-8");
            songList = songService.fuzzyQuery(n);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "findSong";

    }



    public String delSong()
    {

        songService.delete(sid);
        return "delete";
    }


}
