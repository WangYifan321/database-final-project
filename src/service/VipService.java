package service;

import entity.Vip;

import java.util.List;

public interface VipService {
    public boolean addVip(Vip vip);
    public boolean deleteVipByUsername(String username);
    public Vip queryVipByUsername(String username);
    public boolean updateVipByUsername(String username,Vip vip);
    public List<Vip> queryAll();
    public Vip loginByUsername_password(String username,String password);
}
