package com.example.appdemo.Springboot.tutorial.Repository;
import com.example.appdemo.Springboot.tutorial.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Person,Long> {
    Person findAllById(Long id);

}
