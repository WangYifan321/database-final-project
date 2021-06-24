package daoImpl;

import dao.BookDao;
import entity.Book;
import entity.Booktype;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {


    @Override
    public boolean addBook(Book book) {
        String sql = "insert into book (name,author,type,price,img_url,press,cangkuname,num,description) values (?,?,?,?,?,?,?,?,?)";
        Object[] params = {book.getName(),book.getAuthor(),
                book.getType(),book.getPrice(),book.getImg_url(),book.getPress(),book.getCangkuname(),book.getNum(),book.getDescription()
        };
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public List<Book> queryAll() {
        ResultSet rs = null;
        Book book = null;
        List<Book> list = new ArrayList<>();
        PreparedStatement pst = null;
        try{
            String sql = "select * from book";
            rs = DBUtil.executeQuery(sql,null);
            while(rs.next()){
                book = new Book(rs.getInt("book_id"),rs.getString("name"),rs.getString("description"),rs.getString("author"),rs.getString("type"),rs.getInt("price"),rs.getString("img_url"),rs.getString("press"),rs.getString("cangkuname"),rs.getInt("num"));
                list.add(book);

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
    public List<Book> queryAllByBooktype(Booktype booktype) {
        ResultSet rs = null;
        Book book = null;
        List<Book> list = new ArrayList<>();
        PreparedStatement pst = null;
        try{
            String sql = "select * from book where type = ?";
            Object[] param = {booktype.getName()};
            rs = DBUtil.executeQuery(sql,param);
            while(rs.next()){
                book = new Book(rs.getInt("book_id"),rs.getString("name"),rs.getString("description"),rs.getString("author"),rs.getString("type"),rs.getInt("price"),rs.getString("img_url"),rs.getString("press"),rs.getString("cangkuname"),rs.getInt("num"));
                list.add(book);

            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(rs,DBUtil.pst,DBUtil.connection);
        }    }

    @Override
    public Book queryByName(String name) {
        ResultSet rs = null;
        Book book = null;
        try{
            String sql = "select * from book where name = ?";
            Object[] param = {name};
            rs = DBUtil.executeQuery(sql,param);
            while(rs.next()){
                book = new Book(rs.getInt("book_id"),rs.getString("name"),rs.getString("description"),rs.getString("author"),rs.getString("type"),rs.getInt("price"),rs.getString("img_url"),rs.getString("press"),rs.getString("cangkuname"),rs.getInt("num"));


            }
            return book;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(rs,DBUtil.pst,DBUtil.connection);
        }
    }

    @Override
    public boolean updateByName(String name, Book book) {
        String sql = "update book set name=?,author=?,type=?,price=?,img_url=?,press=?,cangkuname=?,num=? where name=?";
        Object[] params = {book.getName(),book.getAuthor(),book.getType(),book.getPrice(),book.getImg_url(),book.getPress(),book.getCangkuname(),book.getNum(),name};
        return DBUtil.executeUpdate(sql,params);
    }//还没改

    @Override
    public boolean deleteByName(String name) {
        String sql = "delete from book where name = ?";
        Object[] param = {name};
        return DBUtil.executeUpdate(sql,param);

    }
}
