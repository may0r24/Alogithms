package springpackage.main.sample1project;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentsServices {
	
	private List<Students> studentsList = new LinkedList<>(Arrays.asList(
			
				new Students("s01", "Michael", "400", "m"),
				new Students("s02", "Janet", "300", "f"),
				new Students("s03", "Latoya", "100", "f"),
				new Students("s04", "Jean", "400", "m"),
				new Students("s05", "Thomas", "haha", "m")
				
			));

	public List<Students> getStudents() {
		return studentsList;
	}

	public Students getStudentById(String id) {
		Students stu = null;
		for(int i = 0; i < studentsList.size(); i++) {
			Students s = studentsList.get(i);
			if(s.getId().equalsIgnoreCase(id)) {
				stu = studentsList.get(i);
			}
		}
		return stu;
	}

	public Students getStudentByName(String name) {
		Students stu = null;
		for(int i = 0; i < studentsList.size(); i++) {
			Students s = studentsList.get(i);
			if(s.getName().equalsIgnoreCase(name)) {
				stu = studentsList.get(i);
			}
		}
		return stu;
	}

	public void addStudentByName(Students student) {
		studentsList.add(student);
	}

	public void updateStudentById(String id, Students student) {
		for(int i = 0; i < studentsList.size(); i++) {
			Students s = studentsList.get(i);
			if(s.getId().equals(id)) {
				studentsList.set(i, student);
			}
		}
	}

	public void deleteStudentById(String id) {
		for(int i=0; i < studentsList.size(); i++) {
			Students s = studentsList.get(i);
			if(s.getId().equals(id)) {
				studentsList.remove(i);
			}
		}
		
	}
}
