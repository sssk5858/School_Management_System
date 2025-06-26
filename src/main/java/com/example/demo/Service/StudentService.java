package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public List<Student> add(Student s){
		repo.save(s);
		List<Student> l1=new ArrayList<>();
		return l1;
	}
	public void drop(int pin,RedirectAttributes redirectAttributes) {
		 if (repo.existsById(pin)) {
	            repo.deleteById(pin);
	            redirectAttributes.addFlashAttribute("message", "Student deleted successfully!");
	        } else {
	            redirectAttributes.addFlashAttribute("message", "Student not found!");
	        }
	}
	
	public List<Student> retrieve(){
		List<Student> l4=repo.findAll();
		return l4;
	}
}
