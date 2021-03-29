package com.example.demopgsql.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demopgsql.models.Phone;
import com.example.demopgsql.repositories.PhoneRepository;

@Controller
@RequestMapping("/phones")
public class PhoneController {

	@Autowired
	private PhoneRepository phoneRepository;

	@RequestMapping("/view")
	public String viewAllPhones(Model model) {
		List<Phone> phones = phoneRepository.findAll();
		model.addAttribute("phones", phones);
		return "phones_list";
	}

	@RequestMapping("/create")
	public String createNewPhone(Model model) {
		Phone phone = new Phone();
		model.addAttribute("phone", phone);
		return "create_new_phone";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String savePhone(@ModelAttribute("phone") Phone phone) {
		phoneRepository.save(phone);
		return "redirect:/phones/view";
	}

}

@RestController
@RequestMapping("/api/v1/phones")
class PhoneAPIController {

	@Autowired
	private PhoneRepository phoneRepository;

	@GetMapping("/all") // GET Method for reading operation
	public List<Phone> getAllPhones() {
		return phoneRepository.findAll();
	}

	// POST method to create a phone
	@PostMapping("/create")
	public Phone createPhone(@RequestBody Phone phone) {
		return phoneRepository.save(phone);
	}

}
