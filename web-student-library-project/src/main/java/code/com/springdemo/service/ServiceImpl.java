package code.com.springdemo.service;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import code.com.springdemo.dao.BookListDAO;
import code.com.springdemo.dao.StudentListDAO;
import code.com.springdemo.entity.BookList;
import code.com.springdemo.entity.StudentList;

@Service
public class ServiceImpl implements StudentBookService {

	// need to inject BookListDAO
	@Autowired
	private BookListDAO bookListDAO;

	// need to inject StudentListDAO
	@Autowired
	private StudentListDAO studentListDAO;

	@Override
	@Transactional
	public List<BookList> getBooks() {

		return bookListDAO.getBooks();
	}

	@Override
	@Transactional
	public void saveBook(BookList theBookList) {

		bookListDAO.saveBook(theBookList);

	}

	@Override
	@Transactional
	public BookList getBooks(int theId) {

		return bookListDAO.getBooks(theId);
	}

	@Override
	@Transactional
	public void deleteBook(int theId) {

		bookListDAO.deleteBook(theId);

	}

	@Override
	@Transactional
	public List<StudentList> getStudents() {

		return studentListDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(StudentList theStudentList) {

		studentListDAO.saveStudent(theStudentList);

	}

	@Override
	@Transactional
	public StudentList getStudents(int theId) {

		return studentListDAO.getStudents(theId);
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {

		studentListDAO.deleteStudent(theId);
	}

	@Override
	@Transactional
	public List<BookList> getBookStudent(int theId) {
		
		return bookListDAO.getBookStudent(theId);
	}

	@Override
	@Transactional
	public List<StudentList> getStudentFromBook(int theId) {
		
		return  studentListDAO.getStudentFromBook(theId);
	}

}
