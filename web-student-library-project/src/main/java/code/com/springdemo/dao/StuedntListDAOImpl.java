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
public class StuedntListDAOImpl implements StudentListDAO {

	// need to inject the session factory
	@Autowired
	public SessionFactory sessionFactory;
		
	@Override
	public List<StudentList> getStudents() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query
		Query<StudentList> theQuery = currentSession.createQuery("from StudentList");
				
		//execute query and get result list
		List<StudentList> studentList = theQuery.getResultList();
				
		//return the result
		return studentList;
	}
	
	@Override
	public void saveStudent(StudentList theStudentList) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the books
		currentSession.saveOrUpdate(theStudentList);
		
	}

	@Override
	public StudentList getStudents(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from db using the primary key
		StudentList theStudent = currentSession.get(StudentList.class, theId);
		
		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		Query<StudentList> theQuery = currentSession.createQuery("delete from StudentList where id=:theStudentId");
				
		theQuery.setParameter("theStudentId", theId);
				
		theQuery.executeUpdate();
		
		
	}
	
	@Override
	public List<StudentList> getStudentFromBook(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		BookList tempBook = currentSession.get(BookList.class, theId);

		System.out.println("\n\ntempBook: "+tempBook);
		
		List<StudentList> studentList = tempBook.getStudentlist();
		
		System.out.println("\n\nstudentList: "+studentList);

		return studentList;
	}


}
