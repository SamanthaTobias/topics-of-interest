package io.samanthatobias.topicsofinterest.repository;

import io.samanthatobias.topicsofinterest.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
