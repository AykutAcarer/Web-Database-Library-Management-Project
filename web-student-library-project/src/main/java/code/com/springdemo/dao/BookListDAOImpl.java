package code.com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import code.com.springdemo.entity.BookList;
import code.com.springdemo.entity.StudentList;

@Repository
public class BookListDAOImpl implements BookListDAO {

	// need to inject the session factory
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<BookList> getBooks() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<BookList> theQuery = currentSession.createQuery("from BookList");

		// execute query and get result list
		List<BookList> booklist = theQuery.getResultList();

		// return the result
		return booklist;
	}

	@Override
	public void saveBook(BookList theBookList) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the books
		currentSession.saveOrUpdate(theBookList);

	}

	@Override
	public BookList getBooks(int theId) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from db using the primary key
		BookList theBooks = currentSession.get(BookList.class, theId);

		return theBooks;
	}

	@Override
	public void deleteBook(int theId) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<StudentList> theQuery = currentSession.createQuery("delete from BookList where id=:theBookId");

		theQuery.setParameter("theBookId", theId);

		theQuery.executeUpdate();

	}

	@Override
	public List<BookList> getBookStudent(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		StudentList tempStudent =currentSession.get(StudentList.class, theId);
		
		System.out.println("\n\ntempStudent: "+tempStudent);
		
		List<BookList> booklist = tempStudent.getBooks();
		
		System.out.println("\n\nBookList: "+booklist);
		
		// return the result
		return booklist;

	}

	

}
