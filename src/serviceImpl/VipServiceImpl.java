package serviceImpl;

import dao.VipDao;
import daoImpl.VipDaoImpl;
import entity.Vip;
import service.VipService;

import java.util.List;

public class VipServiceImpl implements VipService {
    VipDao vd = new VipDaoImpl();
    @Override
    public boolean addVip(Vip vip) {
        if(!vd.isExit(vip.getUsername())){
            return vd.addVip(vip);
        }else
            return false;
    }

    @Override
    public boolean deleteVipByUsername(String username) {
        if(vd.isExit(username)){
            return vd.deleteVipByUsername(username);
        }else
        return false;
    }

    @Override
    public Vip queryVipByUsername(String username) {
        return vd.queryVipByUsername(username);
    }

    @Override
    public boolean updateVipByUsername(String username, Vip vip) {
        if(vd.isExit(username)){
            return vd.updateVipByUsername(username,vip);
        }else
        return false;
    }

    @Override
    public List<Vip> queryAll() {
        return vd.queryAll();
    }

    @Override
    public Vip loginByUsername_password(String username, String password) {

            return vd.loginByUsername_password(username,password);

    }
}
