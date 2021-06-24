package serviceImpl;

import dao.BooktypeDao;
import daoImpl.BooktypeDaoImpl;
import entity.Booktype;
import service.BooktypeService;

import java.util.List;

public class BooktypeServiceImpl implements BooktypeService {
    BooktypeDao btd = new BooktypeDaoImpl();
    @Override
    public boolean addBooktype(Booktype booktype) {
        return btd.addBooktype(booktype);
    }

    @Override
    public boolean deleteByName(String name) {
        return btd.deleteByName(name);
    }

    @Override
    public boolean updateByName(String name, Booktype booktype) {
        return btd.updateByName(name,booktype);
    }

    @Override
    public List<Booktype> queryAll() {
        return btd.queryAll();
    }

    @Override
    public Booktype queryByName(String name) {
        return btd.queryByName(name);
    }
}
