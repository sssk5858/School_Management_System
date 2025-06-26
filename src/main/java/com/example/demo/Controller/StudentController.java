package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;





@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;

	@RequestMapping("/")
	public String showForm() {
		return "Form";
	}
	
//	@PostMapping("/insert")
//	public String insert(@RequestParam int pin,
//								@RequestParam String name,
//								@RequestParam int marks){
//		Student s1=new Student(pin,name,marks);
//		service.add(s1);
//		return "redirect:/";
//	}
	//we use ModelAttribute in the place RequestParam to avoid the lengthy code and it matches the
	//fields to the variables in the table and sets the fields and give the object
	@PostMapping("/insert")
	public String insert(@ModelAttribute Student s,RedirectAttributes redirectAttributes) {
		service.add(s);
		redirectAttributes.addFlashAttribute("message", "Student registered successfully!");
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam int pin,RedirectAttributes redirectAttributes) {
		service.drop(pin, redirectAttributes);
		return "redirect:/";
	}
	
	@GetMapping("/display")
	public String display(Model model){
		model.addAttribute("studentList",service.retrieve());
	    return "StudentRecords";
	}
}
