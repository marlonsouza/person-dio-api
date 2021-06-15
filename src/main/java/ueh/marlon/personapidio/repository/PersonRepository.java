package ueh.marlon.personapidio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ueh.marlon.personapidio.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
