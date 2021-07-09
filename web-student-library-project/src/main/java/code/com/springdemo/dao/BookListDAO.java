package code.com.springdemo.dao;

import java.util.List;

import code.com.springdemo.entity.BookList;
import code.com.springdemo.entity.StudentList;

public interface BookListDAO {

	public List<BookList> getBooks();

	public void saveBook(BookList theBookList);

	public BookList getBooks(int theId);

	public void deleteBook(int theId);

	public List<BookList> getBookStudent(int theId);
	
	
}
