package code.com.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentList {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="last_name")	
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="street")
	private String street;
	
	@Column(name="post_code")
	private String postCode;
	
	@Column(name="city")
	private String city;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="borrowing", joinColumns=@JoinColumn(name="student_id"), inverseJoinColumns=@JoinColumn(name="book_id"))
	private List<BookList> books;
	
	
	
	
	public StudentList() {
	
	}
	

	public StudentList(String lastName, String firstName, String street, String postCode, String city) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.street = street;
		this.postCode = postCode;
		this.city = city;
	}


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	public List<BookList> getBooks() {
		return books;
	}

	public void setBooks(List<BookList> books) {
		this.books = books;
	}
	
	//add a convenience method
	public List<BookList> getBookStudent() {
		return books;
	}
	
	//add a convenience method
		public void addBook(BookList theBook) {
			
			if(books==null) {
				books=new ArrayList<>();
			}
			
			books.add(theBook);
			theBook.setStudentlist((List<StudentList>) this);
		}
		
	@Override
	public String toString() {
		return "StudentList [studentId=" + studentId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", street=" + street + ", postCode=" + postCode + ", city=" + city + "]";
	}
	
	
	
}
