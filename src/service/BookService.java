package service;

import entity.Book;
import entity.Booktype;

import java.util.List;

public interface BookService {
    public boolean addBook(Book book);
    public List<Book> queryAll();
    public List<Book> queryAllByBooktype(Booktype booktype);
    public Book queryByName(String name);
    public boolean updateByName(String name,Book book);
    public boolean deleteByName(String name);
}
