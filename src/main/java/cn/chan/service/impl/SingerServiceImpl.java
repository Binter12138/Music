package cn.chan.service.impl;


import cn.chan.dao.SingerDao;
import cn.chan.entity.Singer;
import cn.chan.service.SingerService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class SingerServiceImpl implements SingerService{

    private SingerDao singerDao;

    public void setSingerDao(SingerDao singerDao) {
        this.singerDao = singerDao;
    }

    /**
     * 添加歌手
     * @param singer
     */
    @Override
    public void addSinger(Singer singer) {
        singerDao.addSinger(singer);

    }

    /**
     * 删除歌手
     * @param singerid
     * @return
     */
    @Override
    public Boolean delete(Integer singerid) {

        singerDao.delete(singerid);

        return null;
    }

    /**
     * 查找歌手
     * @param singername
     * @return
     */
    @Override
    public Singer findSinger(String singername) {

        List<Singer> singerList = singerDao.findSinger(singername);
        if(singerList.size() == 0)
        {
            return null;
        }
        return singerList.get(0);
    }

    /**
     * 查找所有歌手
     * @return
     */
    @Override
    public List<Singer> findAllSinger() {

        List<Singer> singerList = singerDao.findAllSinger();

        return singerList;
    }


    /**
     * 修改歌手
     * @param singer
     */
    @Override
    public void update(Singer singer) {


        singerDao.update(singer);


    }

    /**
     * 按照歌手id查找歌手
     * @param singerid
     * @return
     */
    @Override
    public Singer findById(Integer singerid) {

        Singer singer = singerDao.findById(singerid);
        return singer;
    }


}
