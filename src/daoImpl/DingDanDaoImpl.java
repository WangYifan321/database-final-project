package daoImpl;

import dao.DingDanDao;
import entity.Booktype;
import entity.Dingdan;
import util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DingDanDaoImpl implements DingDanDao {

    @Override
    public List<Dingdan> queryById(int id) {
        ResultSet rs = null;
        Dingdan dd = null;
        List<Dingdan> list = new ArrayList<>();
        try{
            String sql = "select * from dingdan where vip_id = ?";
            Object[] params = {id};
            rs = DBUtil.executeQuery(sql,params);
            while(rs.next()){
                dd = new Dingdan(rs.getInt("shi_money"),rs.getInt("ying_money"),rs.getInt("vip_id"),rs.getInt("dingdan_id"),rs.getString("state"),rs.getDate("time"));
                list.add(dd);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(rs,DBUtil.pst,DBUtil.connection);
        }
    }

    @Override
    public List<Dingdan> queryAll() {
        ResultSet rs = null;
        Dingdan dd = null;
        List<Dingdan> list = new ArrayList<>();
        try{
            String sql = "select * from dingdan";
            rs = DBUtil.executeQuery(sql,null);
            while(rs.next()){
                dd = new Dingdan(rs.getInt("shi_money"),rs.getInt("ying_money"),rs.getInt("vip_id"),rs.getInt("dingdan_id"),rs.getString("state"),rs.getDate("time"));
                list.add(dd);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(rs,DBUtil.pst,DBUtil.connection);
        }    }
}
