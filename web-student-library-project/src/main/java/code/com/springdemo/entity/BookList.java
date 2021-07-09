package code.com.springdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book_list")
public class BookList {

	// define our fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;

	@Column(name = "subject")
	private String subject;

	@Column(name = "author")
	private String author;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private String year;

	@Column(name = "company")
	private String company;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinTable(name = "borrowing", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<StudentList> studentlist;

	
	
	
	
	// define constructors and getters/setters
	public BookList() {

	}

	public BookList(String subject, String author, String title, String year, String company) {
		this.subject = subject;
		this.author = author;
		this.title = title;
		this.year = year;
		this.company = company;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<StudentList> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<StudentList> studentlist) {
		this.studentlist = studentlist;
	}

	// add a convenience method
	public List<StudentList> getStudentFromBook() {
		
		return studentlist;
	}

	@Override
	public String toString() {
		return "BookList [bookId=" + bookId + ", subject=" + subject + ", author=" + author + ", title=" + title
				+ ", year=" + year + ", company=" + company + "]";
	}

}
