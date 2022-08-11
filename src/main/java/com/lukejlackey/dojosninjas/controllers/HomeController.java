package com.lukejlackey.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lukejlackey.dojosninjas.models.Dojo;
import com.lukejlackey.dojosninjas.models.Ninja;
import com.lukejlackey.dojosninjas.services.DojoService;
import com.lukejlackey.dojosninjas.services.NinjaService;

@Controller
public class HomeController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/dojos/new")
	public String newDojo(Model model){
		model.addAttribute("dojo", new Dojo());
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addNewDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result, Model model){
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		else {
			System.out.println(dojoService.createDojo(dojo));
		}
		return "redirect:/dojos/" + dojo.getId();
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model model){
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojos", dojoService.findAll());
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String addNewNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model model){
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.findAll());
			return "newNinja.jsp";
		}
		else {
			System.out.println(ninjaService.createNinja(ninja));
		}
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model){
		model.addAttribute("dojo", dojoService.findById(id));
		model.addAttribute("ninjas", ninjaService.findAllByDojoId(id));
		return "dojo.jsp";
	}
	
}
