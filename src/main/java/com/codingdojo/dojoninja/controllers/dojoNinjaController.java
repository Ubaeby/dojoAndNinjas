package com.codingdojo.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoninja.models.Dojo;
import com.codingdojo.dojoninja.models.Ninja;
import com.codingdojo.dojoninja.services.DojoService;
import com.codingdojo.dojoninja.services.NinjaService;

@Controller
public class dojoNinjaController {

	
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("")
	public String index() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String homePage(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> d = dojoService.allDojos();
		model.addAttribute("dojos", d);
		return "index.jsp";
	}
	
	//This is for the Dojo creation
	@GetMapping("/dojos/new") 
	public String dojoCreatePage(
			@ModelAttribute("dojo") Dojo theDojo, Model model) {
		List<Dojo> d = dojoService.allDojos();
		model.addAttribute("dojos", d);
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String dojoCreate(
			@Valid @ModelAttribute("dojo") Dojo theDojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojo.jsp";
		} else {
			dojoService.createDojo(theDojo);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showAllDojos(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojos", dojo);
		return "display.jsp";
	}
	
	
	// Ninja creation
	@GetMapping("/ninjas/new")
	public String ninjaCreatePage(
			@ModelAttribute("ninja") Ninja theNinja, Model model) {
		List<Ninja> n = ninjaService.allNinjas();
		model.addAttribute("ninjas", n);
		
		//The line below is used to display the form select on ninja.jsp :3
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("/new")
	public String ninjaCreate(
			@Valid @ModelAttribute("ninja") Ninja theNinja, BindingResult result) {
		if (result.hasErrors()) {
			return "ninja.jsp";
		} else {
			ninjaService.createNinja(theNinja);
			return "redirect:/home";
		}
	}
	
}
