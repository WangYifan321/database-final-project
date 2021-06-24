package dao;

import entity.Dingdan;

import java.util.List;

public interface DingDanDao {
    public List<Dingdan> queryById(int id);
    public List<Dingdan> queryAll();
}
