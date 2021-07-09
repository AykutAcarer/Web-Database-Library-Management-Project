package code.com.springdemo.service;

import java.util.List;

import code.com.springdemo.entity.BookList;
import code.com.springdemo.entity.StudentList;

public interface StudentBookService {

	public List<BookList> getBooks();
	
	public List<StudentList> getStudents();
	
	public void saveBook (BookList theBookList);
	
	public void saveStudent (StudentList theStudentList);

	public BookList getBooks(int theId);
	
	public StudentList getStudents(int theId);

	public void deleteBook(int theId);
	
	public void deleteStudent(int theId);
	
	public List<BookList> getBookStudent(int theId);
	
	public List<StudentList> getStudentFromBook(int theId);
	
}
