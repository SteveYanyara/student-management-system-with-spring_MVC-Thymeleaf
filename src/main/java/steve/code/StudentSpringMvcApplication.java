package steve.code;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

import steve.code.dao.StudentRepository;
import steve.code.entities.Student;

@SpringBootApplication
public class StudentSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
	  ApplicationContext ctx=SpringApplication.run(StudentSpringMvcApplication.class, args);
	  StudentRepository studentRepository=ctx.getBean(StudentRepository.class);
	  DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	  
	 
	  studentRepository.save(
			  new Student("Steve", df.parse("2001-05-08"),
					  "steve@gmail.com","steve.jpg"));
	  
	  studentRepository.save(
			  new Student("Herman",df.parse("2004-10-17"),
					  "herman@gmail.com","herman.jpg"));
	  
	  studentRepository.save(
			  new Student("Raissa",df.parse("2004-08-10"),
					  "raissa@gmail.com","raissa.jpg"));
	  Page<Student> stu=studentRepository.chercherEtudiants("%A%", PageRequest.of(0, 5));
	  stu.forEach(s->System.out.println(s.getNom()));
		// Page<Student> stu=studentRepository.findAll(PageRequest.of(1, 5));
		// stu.forEach(s->System.out.println(s.getNom()));
	// Page<Student> s=studentRepository.findAll(new PageRequest(1, 5, Sort.Direction.DESC));
	}

}
