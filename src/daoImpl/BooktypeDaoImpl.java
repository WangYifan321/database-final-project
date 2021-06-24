package daoImpl;

import dao.BooktypeDao;
import entity.Book;
import entity.Booktype;
import util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BooktypeDaoImpl implements BooktypeDao {

    @Override
    public boolean addBooktype(Booktype booktype) {
        String sql = "insert into booktype (name,description) values (?,?)";
        Object[] params = {booktype.getName(),booktype.getDescription()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean deleteByName(String name) {
        String sql = "delete from booktype where name =?";
        Object[] param = {name};

        return DBUtil.executeUpdate(sql,param);
    }

    @Override
    public boolean updateByName(String name, Booktype booktype) {
        String sql = "update booktype set description=? where name=?";
        Object[] params = {booktype.getDescription(),name};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public List<Booktype> queryAll() {
        ResultSet rs = null;
        Booktype booktype = null;
        List<Booktype> list = new ArrayList<>();
        try{
            String sql = "select * from booktype";
            rs = DBUtil.executeQuery(sql,null);
            while(rs.next()){
                booktype = new Booktype(rs.getString("name"),rs.getString("description"));
                list.add(booktype);

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
    public Booktype queryByName(String name) {
        ResultSet rs = null;
        Booktype booktype = null;
        try{
            String sql = "select * from booktype where name=?";
            Object[] param = {name};
            rs = DBUtil.executeQuery(sql,param);
            while(rs.next()){
                booktype = new Booktype(rs.getString("name"),rs.getString("description"));


            }
            return booktype;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(rs,DBUtil.pst,DBUtil.connection);
        }
    }
}
