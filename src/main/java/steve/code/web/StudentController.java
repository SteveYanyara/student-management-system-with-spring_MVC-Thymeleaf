package steve.code.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import steve.code.dao.StudentRepository;
import steve.code.entities.Student;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
// page need to be a parameter for the size we not mandatory we can just let a number.
// PageRequest is for the pagination so we can limit the number of student printed. 
	@RequestMapping(value="/Index")
	public String Index(Model model, @RequestParam(name="page",defaultValue="0")int p) {
		
		Page<Student> stds=studentRepository.findAll(PageRequest.of(p, 5));
		model.addAttribute("pageStudents",stds);
		return "students";
	}
}
