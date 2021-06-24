package daoImpl;

import dao.TiaoMuDao;
import entity.Book;
import entity.Tiaomu;
import util.DBUtil;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TiaoMuDaoImpl implements TiaoMuDao {
    @Override
    public List<Tiaomu> queryAll(String username) {
        ResultSet rs = null;
        Tiaomu tm = null;
        List<Tiaomu> list = new ArrayList<>();
        PreparedStatement pst = null;
        try{
            String sql = "select * from tiaomu where username = ?";
            Object[] params = {username};
            rs = DBUtil.executeQuery(sql,params);
            while(rs.next()){
                tm = new Tiaomu(rs.getInt("tiaomu_id"),rs.getInt("num"),rs.getInt("money"),rs.getString("book_name"),rs.getString("img_url"),rs.getString("username"));
                list.add(tm);
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
    public boolean delete(int id) {
        String sql = "delete from tiaomu where tiaomu_id = ?";
        Object[] params =  {id};
        if(DBUtil.executeUpdate(sql,params)){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean insert(Tiaomu tm) {
        String sql = "insert into tiaomu (num,money,book_name,img_url,username) values (?,?,?,?,?)";
        Object[] params = {tm.getNum(),tm.getMoney(),tm.getBook_name(),tm.getImg_url(),tm.getUsername()};
        if(DBUtil.executeUpdate(sql,params)){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean update(int id) {
        String sql = "update tiaomu set state = ? where tiaomu_id = ?";
        Object[] params = {1,id};
        if(DBUtil.executeUpdate(sql,params)){
            return true;
        }else{
            return false;
        }
    }
}
