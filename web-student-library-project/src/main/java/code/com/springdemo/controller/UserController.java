package code.com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import code.com.springdemo.entity.BookList;
import code.com.springdemo.entity.StudentList;
import code.com.springdemo.service.StudentBookService;

@Controller
@RequestMapping("/list")
public class UserController {

	@Autowired
	private StudentBookService studentBookService;

	
	// StudentListController
	@GetMapping("/listStudent")
	public String listStudents(Model theModel) {

		// get books from Service
		List<StudentList> theStudents = studentBookService.getStudents();

		// add the books to the model
		theModel.addAttribute("students", theStudents);

		return "list-students";
	}

	// BookListController
	@GetMapping("/listBook")
	public String listBooks(Model theModel) {

		// get books from Service
		List<BookList> theBooks = studentBookService.getBooks();

		// add the books to the model
		theModel.addAttribute("books", theBooks);

		return "list-books";
	}

	// Ogrenciye kitap eklemek icin once kitap listesini getiren metod----her kitap karsisinda "add" butonu var
		@GetMapping("/listBooksForStudent")
		public String listBooksForStudent(Model theModel) {

			// get books from Service
			List<BookList> theBooks = studentBookService.getBooks();

			// add the books to the model
			theModel.addAttribute("books", theBooks);

			return "list-books3";
		}
		
		
	// StudentListController
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data

		StudentList theStudent = new StudentList();

		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	// BookListController ----------not: update "showFormForAddBook" list-book.jsp
	@GetMapping("/showFormForAddBook")
	public String showFormForAddBook(Model theModel) {

		// create model attribute to bind form data

		BookList theBook = new BookList();

		theModel.addAttribute("book", theBook);

		return "book-form";
	}

	// StudentListController
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") StudentList theStudent) {

		// save the customer using our service
		studentBookService.saveStudent(theStudent);

		return "redirect:/list/listStudent";
	}

	// BookListController
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") BookList theBook) {

		// save the customer using our service
		studentBookService.saveBook(theBook);

		return "redirect:/list/listBook";
	}

	// StudentListController
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// get the customer from the service
		StudentList theStudent = studentBookService.getStudents(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);

		// send over to our form
		return "student-form";
	}

	

	// StudentListController
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {

		// delete the customer
		studentBookService.deleteStudent(theId);

		return "redirect:/list/listStudent";
	}

	// BookListController
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") int theId) {

		// delete the customer
		studentBookService.deleteBook(theId);

		return "redirect:/list/listBook";
	}
	
		
		@GetMapping("/linkForBookEachStudent")
		public String linkForBookEachStudent(@RequestParam("studentId") int theId, Model theModel) {
			
			StudentList tempStudent = studentBookService.getStudents(theId);
			// get the customer from the service
			List<BookList> theBooks = studentBookService.getBookStudent(theId);
			
			// set customer as a model attribute to pre-populate the form
			theModel.addAttribute("books", theBooks);

			return "list-books2";
		}
		
		@GetMapping("/linkForStudentFromStudent")
		public String linkForStudentFromStudent(@RequestParam("bookId") int theId, Model theModel) {

			// get the customer from the service
			List<StudentList> theStudents = studentBookService.getStudentFromBook(theId);
			
			// set customer as a model attribute to pre-populate the form
			theModel.addAttribute("students", theStudents);

			return "list-students2";
		}

}
