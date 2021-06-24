package dao;

import entity.Booktype;

import java.util.List;

public interface BooktypeDao {
    public boolean addBooktype(Booktype booktype);
    public boolean deleteByName(String name);
    public boolean updateByName(String name,Booktype booktype);
    public List<Booktype> queryAll();
    public Booktype queryByName(String name);
}
