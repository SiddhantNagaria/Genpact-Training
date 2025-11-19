package com.springboot.first_webmvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.first_webmvc.model.User;

@Controller
public class FormTagController {

	// show the jsp from
	@GetMapping("/formTag")
	public String showForm(Model model) { // Model -> spring provided object - pass data from controller to view JSP
											// page
		model.addAttribute("user", new User());
		// provide options for the multiple checkboxes
		List<String> interestOptions = Arrays.asList("Sports", "Music", "Coding", "Gaming");
		model.addAttribute("interestOptions", interestOptions);
		model.addAttribute("countryList", List.of("India", "USA", "UK", "Canada"));
        model.addAttribute("languageList", List.of("Java", "Python", "C++", "JavaScript"));
       

		return "formTag";
	}

	// Process from form
	@PostMapping("/formTag")
	public String submitForm(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user", user);
		return "result";
	}
}
