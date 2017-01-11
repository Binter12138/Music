package cn.chan.action;

import cn.chan.entity.Album;
import cn.chan.service.AlbumService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;


public class AlbumAction extends ActionSupport {

    private AlbumService albumService;
    private File photo;
    private String photoFileName;
    private Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
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

    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public String addAlbum()
    {

        //图片上传

        if(photo != null)
        {
            String suffix = photoFileName.substring(photoFileName.lastIndexOf("."));
            String destFileName = System.currentTimeMillis()+suffix;
            album.setAlbumImage(destFileName);
            File destFile = new File(ServletActionContext.getServletContext().getRealPath("/")+"/music/files",destFileName);
            photo.renameTo(destFile);

        }else {
            album.setAlbumImage(null);

        }
        albumService.addAlbum(album);



        return "add";
    }

}
