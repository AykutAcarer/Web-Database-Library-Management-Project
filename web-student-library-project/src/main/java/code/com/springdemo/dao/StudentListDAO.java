package code.com.springdemo.dao;

import java.util.List;

import code.com.springdemo.entity.BookList;
import code.com.springdemo.entity.StudentList;

public interface StudentListDAO {

	public List<StudentList> getStudents();
	
	public void saveStudent (StudentList theStudentList);

	public StudentList getStudents(int theId);

	public void deleteStudent(int theId);
	
	public List<StudentList> getStudentFromBook(int theId);

}
