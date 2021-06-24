package dao;

import entity.Tiaomu;

import java.util.List;

public interface TiaoMuDao {
    public List<Tiaomu> queryAll(String username);
    public boolean delete(int id);
    public boolean insert(Tiaomu tm);
    public boolean update(int id);
}
