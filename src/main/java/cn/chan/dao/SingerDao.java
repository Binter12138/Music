package cn.chan.dao;


import cn.chan.entity.Singer;

import java.util.List;

public interface SingerDao {


    /**
     * 添加歌手
     * @param singer
     */
    public void addSinger(Singer singer);


    /**
     * 删除歌手
     * @param singerid
     * @return
     */
    public Boolean delete(Integer singerid);

    /**
     * 按名字查找歌手
     * @param singername
     * @return
     */
    public List<Singer> findSinger(String singername);

    /**
     * 查找所有歌手
     * @return
     */
    public List<Singer> findAllSinger();


    /**
     * 修改歌手
     */
    public void update(Singer singer);


    /**
     * 按id查找歌手
     * @param singerid
     * @return
     */
    public Singer findById(Integer singerid);


}
