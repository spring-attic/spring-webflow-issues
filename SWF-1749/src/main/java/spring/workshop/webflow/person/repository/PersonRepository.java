package spring.workshop.webflow.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.workshop.webflow.person.entity.Person;

/**
 * JPA repository for {@link Person persons}.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
