package io.samanthatobias.topicsofinterest.repository;

import java.util.Optional;

import io.samanthatobias.topicsofinterest.exception.ResourceNotFoundException;
import io.samanthatobias.topicsofinterest.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	default Topic findByIdOrThrow(long id) {
		Optional<Topic> topic = findById(id);
		if (topic.isEmpty()) {
			throw new ResourceNotFoundException(Topic.class, id);
		}

		return topic.get();
	}

}
