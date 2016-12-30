package cn.chan.dao.impl;

import cn.chan.dao.SingerDao;
import cn.chan.entity.Singer;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;


public class SingerDaoImpl implements SingerDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 添加歌手
     * @param singer
     */
    @Override
    public void addSinger(Singer singer) {


      /*  Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(singer);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            HibernateUtil.closeSession();
        }*/
      hibernateTemplate.save(singer);
    }

    /**
     * 删除歌手
     * @param singerid
     * @return
     */
    @Override
    public Boolean delete(Integer singerid) {

        /*Transaction tx = null;
        try {
            Session session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Singer singer = (Singer) session.get(Singer.class,singerid);
            session.delete(singer);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            HibernateUtil.closeSession();
        }*/

        Singer singer = hibernateTemplate.get(Singer.class, singerid);
        hibernateTemplate.delete(singer);
        return true;
    }


    /**
     * 查找歌手
     * @param singername
     * @return
     */
    @Override
    public List<Singer> findSinger(String singername) {

        /*Session session = HibernateUtil.getSession();
        String hql = "from Singer s where s.singername=:singername";
        Query query = session.createQuery(hql);
        query.setString("singername",singername);
        Singer singer = (Singer) query.uniqueResult();
        */

        List<Singer> singerList = (List<Singer>) hibernateTemplate.find("from Singer s where s.singername=?", singername);


        return singerList;
    }


    /**
     * 查找所有歌手
     * @return
     */
    @Override
    public List<Singer> findAllSinger() {

     /*   Session session = HibernateUtil.getSession();
        String hql = "from Singer";
        Query query = session.createQuery(hql);

        List<Singer> singerList = query.list();*/


        List<Singer> singerList = (List<Singer>) hibernateTemplate.find("from Singer");

        return singerList;
    }


    /**
     * 修改歌手
     */

    public void update(Singer singer) {


        hibernateTemplate.update(singer);

    }

    /**
     * 按照id查找歌手
     * @param singerid
     * @return
     */
    @Override
    public Singer findById(Integer singerid) {



        return hibernateTemplate.get(Singer.class,singerid);
    }
}
