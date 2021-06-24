package daoImpl;

import dao.VipDao;
import entity.Vip;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class VipDaoImpl implements VipDao {
    @Override
    //通过用户名去查询数据库，有无此会员
    public boolean isExit(String username) {
        return queryVipByUsername(username) == null?false:true;
    }

    @Override
    public boolean addVip(Vip vip) {
        String sql="insert into vipuser (name,username, password,sex, address,phone,personid)values(?,?,?,?,?,?,?)";
        Object[] params = {vip.getName(),vip.getUsername(),vip.getPassword(),vip.getSex(),vip.getAddress(),vip.getPhone(),vip.getPersonid()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean deleteVipByUsername(String username) {
        String sql = "delete from vipuser where username=?";
        Object[] params = {username};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public Vip queryVipByUsername(String username) {
        Vip vip = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try{
            String sql = "select * from vipuser where username=?";
            Object[] param={username};
            rs=DBUtil.executeQuery(sql,param);
            if(rs.next()){
                 String name = rs.getString("name");
                 String user_name = rs.getString("username");
                 String password = rs.getString("password");
                 String sex = rs.getString("sex");
                 String personid = rs.getString("personid");
                 String phone = rs.getString("phone");
                 String address = rs.getString("address");
                 vip = new Vip(rs.getInt("vip_id"),name,password,user_name,sex,personid,phone,address);
            }
            return vip;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs, pst,DBUtil.connection);
        }
        return null;
    }

    @Override
    public boolean updateVipByUsername(String username,Vip vip) {
        String sql = "update vipuser set name=?,password=?,sex=?,personid=?,phone=?,address=? where username=?";
        Object[] params = {vip.getName(),vip.getPassword(),vip.getSex(),vip.getPersonid(),vip.getPhone(),vip.getAddress(),username};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public List<Vip> queryAll() {
        Vip vip = null;
        ResultSet rs = null;
        List<Vip> vips = new ArrayList<>();
        PreparedStatement pst = null;
        try{
            String sql = "select * from vipuser";
            rs = DBUtil.executeQuery(sql,null);
            while(rs.next()){
                String name = rs.getString("name");
                String password = rs.getString("password");
                String user_name = rs.getString("username");
                String sex = rs.getString("sex");
                String personid = rs.getString("personid");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                vip = new Vip(name,password,user_name,sex,personid,phone,address);
                vips.add(vip);
            }
            return vips;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }finally {
            DBUtil.closeAll(rs, pst,DBUtil.connection);
        }
    }

    @Override
    public Vip loginByUsername_password(String username, String password) {
        Vip vip = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            String sql = "select * from vipuser where username=? and password = ?";
            Object[] params = {username, password};
            rs = DBUtil.executeQuery(sql, params);
            if(rs.next()){
                String name = rs.getString("name");
                String user_name = rs.getString("username");
                String sex = rs.getString("sex");
                String personid = rs.getString("personid");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                vip = new Vip(name,password,user_name,sex,personid,phone,address);
            }
            return vip;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs, pst,DBUtil.connection);
        }

        return null;
    }
}
