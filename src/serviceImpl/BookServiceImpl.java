package serviceImpl;

import dao.BookDao;
import daoImpl.BookDaoImpl;
import entity.Book;
import entity.Booktype;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bd = new BookDaoImpl();
    @Override
    public boolean addBook(Book book) {
        return bd.addBook(book);
    }

    @Override
    public List<Book> queryAll() {
        return bd.queryAll();
    }

    @Override
    public List<Book> queryAllByBooktype(Booktype booktype) {
        return bd.queryAllByBooktype(booktype);
    }

    @Override
    public Book queryByName(String name) {
        return bd.queryByName(name);
    }

    @Override
    public boolean updateByName(String name, Book book) {
        return bd.updateByName(name,book);
    }

    @Override
    public boolean deleteByName(String name) {
        return bd.deleteByName(name);
    }
}
