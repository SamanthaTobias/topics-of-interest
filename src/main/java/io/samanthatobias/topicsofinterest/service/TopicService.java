package io.samanthatobias.topicsofinterest.service;

import lombok.extern.slf4j.Slf4j;
import io.samanthatobias.topicsofinterest.model.Topic;
import io.samanthatobias.topicsofinterest.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public List<Topic> getAllTopics() {
		return repository.findAll();
	}

	public void createTopic(String name) {
		log.info("Creating Topic name={}", name);
		Topic topic = new Topic();
		topic.setName(name);
		repository.save(topic);
	}

	public void deleteTopic(Long id) {
		log.info("Deleting Topic id={}", id);
		Topic topic = repository.findByIdOrThrow(id);
		repository.delete(topic);
	}

	public void editTopic(Long id, String newName) {
		log.info("Editing Topic id={}", id);
		Topic topic = repository.findByIdOrThrow(id);
		topic.setName(newName);
		repository.save(topic);
	}

}