package io.samanthatobias.topicsofinterest.service;

import io.samanthatobias.topicsofinterest.model.Topic;
import io.samanthatobias.topicsofinterest.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public List<Topic> getAllTopics() {
		return repository.findAll();
	}

	public void createTopic(String name) {
		Topic topic = new Topic();
		topic.setName(name);
		repository.save(topic);
	}

	public void deleteTopic(Long id) {
		Topic topic = repository.findByIdOrThrow(id);
		repository.delete(topic);
	}

	public void editTopic(Long id, String newName) {
		Topic topic = repository.findByIdOrThrow(id);
		topic.setName(newName);
		repository.save(topic);
	}

}