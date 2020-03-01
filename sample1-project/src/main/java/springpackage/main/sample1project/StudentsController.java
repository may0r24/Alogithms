package springpackage.main.sample1project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {
	
	@Autowired
	private StudentsServices studentsServices;
	
	@RequestMapping("/students")
	public List<Students> showStudents() {
		return studentsServices.getStudents();
	}
	@RequestMapping("/studentsid/{id}")
	public Students searchStudentById(@PathVariable String id) {
		return studentsServices.getStudentById(id);
	}
	@RequestMapping("/studentsname/{name}")
	public Students searchStudentByName(@PathVariable String name) {
		return studentsServices.getStudentByName(name);
	}
	@RequestMapping(method=RequestMethod.POST, value="/studentsreg")
	public void addStudentByName(@RequestBody Students student) {
		studentsServices.addStudentByName(student);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/studentsupdateid/{id}")
	public void updateStudentById(@PathVariable String id, @RequestBody Students student) {
		studentsServices.updateStudentById(id, student);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/studentsdeleteid/{id}")
	public void deleteStudentById(@PathVariable String id) {
		studentsServices.deleteStudentById(id);
	}

}
