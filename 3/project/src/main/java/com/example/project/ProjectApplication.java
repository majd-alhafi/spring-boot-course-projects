package com.example.project;

import com.example.project.dao.StudentDAO;
import com.example.project.dao.StudentDAOImpl;
import com.example.project.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		/*
		*
		* studentDAO is created automatically because the class is annotated with @Repository.
		* and this object will be used to perform the CRUD operations.
		* */
		return runner -> {
			System.out.println("Hello world");

			//createStudent(studentDAO);
			//findStudent(studentDAO);
			//getAllStudents(studentDAO);
			//deleteStudent(studentDAO);
			//updateStudent(studentDAO);

			System.out.println("Bye world");
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student s = studentDAO.findById(2);
		s.setEmail("GG");
		studentDAO.updateStudent(s);
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Alhafi");
		students.forEach(System.out::println);
	}

	private void findStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(1));
	}

	private void createStudent(StudentDAO studentDAO){
		Student student = new Student("Majd","Alhafi","m@alhafi.com");
		studentDAO.save(student);
	}
	private void deleteStudent(StudentDAO studentDAO){
		studentDAO.deleteStudent(1);
	}
}
