package com.springboot.first_webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.HtmlUtils;

@Controller
public class FormController {

	//	@Controller
	//		it tells spring boot this class will handle web requests
	//		display a form when you open /form
	//		making a GET Request
	
	@GetMapping("/form")	//method handle GET request to URL/ form
	public String showForm() {
		return "redirect:/form.html";		//tell spring to redirect user's browser to static html file form.html
	}
	
//	@PostMapping("/submit")			//handle the HTTP request to /submit
	
//	@ResponseBody					//return value of the method should be written directly to HTTP response body
//	public String handleForm(	
//		@RequestParam String name,
//		@RequestParam String email,
//		@RequestParam int age) {		//spring will bot look for a view
				//name, email , age
				// @requestparam - maps form fields to java method method parameters
//		return "<h2>Form submitted successfully</h2>"
//				+ "<p> Name : "+ name +"</p>"+
//				 "<p> Email : "+ email +"</p>"+
//				 "<p> Age : "+ age +"</p>"+
//		 "<a href='/form.html'>Go Back </a>";
//	}
	
	//submitted data -> create a method separately

	@PostMapping("/submit")			//handle the HTTP request to /submit
//	@ResponseBody					//return value of the method should be written directly to HTTP response body
	public String handleFormRedirect(	//redirect to /result - use of RedirectAttribute	
		@RequestParam String name,
		@RequestParam String email,
		@RequestParam int age,
	RedirectAttributes redirectAttributes
			) {		
		String safeName = HtmlUtils.htmlEscape(name==null?"":name);
		String safeEmail = HtmlUtils.htmlEscape(email==null?"":email);
		String safeAge = Integer.toString(age);
		redirectAttributes.addAttribute("name", safeName);
		redirectAttributes.addAttribute("email", safeEmail);
		redirectAttributes.addAttribute("age", safeAge);
		
		return "redirect:/result";
	}
	
	//show submitted data in result
	@GetMapping("/result")
	@ResponseBody
	public String showResult (
		@RequestParam(required=false, defaultValue="")String name,
		@RequestParam(required=false, defaultValue="")String email,
		@RequestParam(required=false, defaultValue="")int age
	){
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><title>Result</title></head><body>");
		sb.append("<h2>Submission reuslt</h2>");
		sb.append("<p>Name : ").append(name).append("</p>");
		sb.append("<p>Email :").append(email).append("</p>");
		sb.append("<p>Age :").append(age).append("</p>");
		sb.append("<p><a href = '/form.html'>Submit another form</a></p>");
		sb.append("<p><a href='/'> Back to Index </a></p>");
		
		return sb.toString();	
	}
	
	
	// user opens form -> controller redirects -> /form.html -> user fill form and click submit
	//		post submit -> handleFormRedirect execute
	//		add params -> redirect /result
	//		GET result -> show result()
	//		display result
	
	// two more html pages - about.html, contact.html
		// controllers for these two pages
	 
	
	@GetMapping("/about")
	public String showAboutPage() {
	    return "redirect:/about.html";
	}
	@GetMapping("/contact")
	public String showContactPage() {
	    return "redirect:/contact.html";
	}

}
