package cn.chan.action;


import cn.chan.entity.Singer;
import cn.chan.service.SingerService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.List;

public class SingerAction extends ActionSupport{


    private Singer singer;
    private Singer singer1;
    private File photo;
    private String photoFileName;
    private String result;
    private SingerService singerService;
    private Integer singerid;

    public Singer getSinger1() {
        return singer1;
    }

    public void setSinger1(Singer singer1) {
        this.singer1 = singer1;
    }

    public Integer getSingerid() {
        return singerid;
    }

    public void setSingerid(Integer singerid) {
        this.singerid = singerid;
    }

    private List<Singer> singerList;

    public SingerService getSingerService() {
        return singerService;
    }

    public void setSingerService(SingerService singerService) {
        this.singerService = singerService;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Singer> getSingerList() {
        return singerList;
    }

    public void setSingerList(List<Singer> singerList) {
        this.singerList = singerList;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }


    public String add()
    {

        if(photo != null)
        {
            String suffix = photoFileName.substring(photoFileName.lastIndexOf("."));
            String destFileName = System.currentTimeMillis()+suffix;
            singer.setSingerimage(destFileName);
            File destFile = new File(ServletActionContext.getServletContext().getRealPath("/")+"/music/files",destFileName);
            photo.renameTo(destFile);

        }else {
            singer.setSingerimage(null);
        }
        singerService.addSinger(singer);

        return "addSinger";
    }


    /**
     * 查询所有歌手
     * @return
     */
    public String allSinger()
    {

        singerList = singerService.findAllSinger();

        if(result.equals("before")){
            return "beforeAllSinger";
        }else if(result.equals("after"))
        {
            return "afterAllSinger";
        }else {
            return NONE;
        }



    }


    /**
     * 查询歌手（添加歌曲）
     * @return
     */
    public String allSingerName()
    {
        singerList = singerService.findAllSinger();

        return "allSingerName";
    }

    public String modifySong()
    {

        singerList = singerService.findAllSinger();
        return "modifysong";
    }

    /**
     * 删除歌手
     * @return
     */
    public String delSinger()
    {

        singerService.delete(singerid);
        return "delSinger";
    }


    public String update()
    {


        if(photo != null)
        {
            String suffix = photoFileName.substring(photoFileName.lastIndexOf("."));
            String destFileName = System.currentTimeMillis()+suffix;
            singer.setSingerimage(destFileName);
            File destFile = new File(ServletActionContext.getServletContext().getRealPath("/")+"/music/files",destFileName);
            photo.renameTo(destFile);

        }else {
            singer.setSingerimage(null);
        }
        singer.setSingerid(singerid);
        singerService.update(singer);

        return "update";
    }



    public String findId()
    {


        singer1 = singerService.findById(singerid);
        photoFileName = singer1.getSingerimage();
        return "findById";
    }




}
