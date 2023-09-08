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

		return "redirect:/topics";
	}

}
