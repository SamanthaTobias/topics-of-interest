package io.samanthatobias.topicsofinterest.controller;

import io.samanthatobias.topicsofinterest.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TopicController {

	private static final String REDIRECT = "redirect:/topics";

	@Autowired
	private TopicService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/topics")
	public String showTopics(Model model) {
		model.addAttribute("topics", service.getAllTopics());

		return "topics";
	}

	@PostMapping("/topics/add")
	public String addTopic(@RequestParam String name) {
		service.createTopic(name);

		return REDIRECT;
	}

	@PostMapping("/topics/delete")
	public String deleteTopic(@RequestParam Long id) {
		service.deleteTopic(id);

		return REDIRECT;
	}

	@PostMapping("/topics/edit")
	public String editTopic(@RequestParam Long id, @RequestParam String newName) {
		service.editTopic(id, newName);

		return REDIRECT;
	}

}
