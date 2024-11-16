package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.propertyeditor.PersonEditor;
import com.example.demo.propertyeditor.PersonPropertyEditor;

@RestController
@RequestMapping(value = "/mylearning/")
public class MainController {
	
	@Autowired
    private PersonEditor personEditor;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Person.class, personEditor);
    }


	@GetMapping("/requestparam")
	public void showRequestParamValue(@RequestParam(value = "firstName") String fisrtName) {
		System.out.println(fisrtName);
	}

	@GetMapping("/pathavariable/{id}")
	public void showPathVaribale(@PathVariable(value = "id") int id) {
		System.out.println(id);
	}

	@PostMapping("/requestbody")
	public void showPostMapping(@RequestBody User user) {
		System.out.println(user.getName() + " " + user.getEmail());
	}

	@PostMapping("/responsebody")
	public ResponseEntity<Boolean> returnResponseEnity(@RequestBody User user) {
		System.out.println(user.getName() + " " + user.getEmail());
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}

	@PostMapping("/propertyEditor")
    public String getPerson(@RequestBody String input) {
        // Use PropertyEditor to parse the input
        PersonEditor editor = new PersonEditor();
        editor.setAsText(input);
        Person person = (Person) editor.getValue();

        return "Received: " + person.toString();
    }
}
