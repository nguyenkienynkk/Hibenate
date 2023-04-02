package Service;
import com.example.appdemo.Springboot.tutorial.Entity.Person;
import com.example.appdemo.Springboot.tutorial.Repository.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;



@Service
public class PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    Repo repo;
    @Transactional(readOnly = false)

    public  Person updatePerson(Person person) {
        Person personUpdate;
        try {
            personUpdate = repo.findAllById(person.getId());
            if(!Objects.isNull(personUpdate)){
                personUpdate.setId(person.getId());
                personUpdate.setFullname(person.getFullname());
                personUpdate.setAge(person.getAge());
                personUpdate.setSex(person.getSex());

            }
        } catch (Exception e) {
            throw e;
        }
        return personUpdate;
    }

    @Transactional(readOnly = true)
    public List<Person> getAllPerson() throws Exception {
        try {
            return (List<Person>) repo.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Person getPersonById(Long id) throws Exception {
        try {
            return repo.findAllById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = false)
    public Person createPerson(Person person) throws Exception {
        try {
            return repo.save(person);
        } catch (Exception e) {
            throw e;
        }
    }





    @Transactional(readOnly = false)
    public String deletePersonById(Long id) throws Exception {
        String result = "";
        try {
            repo.deleteById(id);
            result = "Delete product success";
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}