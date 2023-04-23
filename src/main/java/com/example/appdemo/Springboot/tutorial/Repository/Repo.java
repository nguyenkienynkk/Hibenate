package com.example.appdemo.Springboot.tutorial.Repository;
import com.example.appdemo.Springboot.tutorial.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Modifier;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Repository
public interface Repo extends JpaRepository<Person,Long> {
    List<Person> findAllByFullnameAndAge(String fullname , int age);


    @Query("select p from Person p where p.fullname = :fullname and p.age =:age")
    List<Person> searchOne (@Param("fullname") String fullname , @Param("age") int age);
    //select * from Person where fullname = 'Nguyễn Kiên' and age = 19
    @Query("select p from Person p where p.age = :age and p.password =:password")
    List<Person> searchOne (@Param("18") int age , @Param("minh2003") String password);

    @Query("select p from Person p where p.username = :username and p.password =:password")
    List<Person> searchOne (@Param("MinhMd") String username , @Param("minh2003") String password);

    @Query("SELECT u FROM Person u WHERE u.yourMajor = :yourMajor and u.className = :className")
    Person findPersonByYourMajorAndClassName(@Param("yourmajor") String yourMajor, @Param("classname") String name);

    @Query("select p from Person p where p.className = :className and p.id =:id")
    List<Person> findAllByClassNameAndId(@Param("IT12819") String className , @Param("2") Integer id);

    @Query("select p from Person p where p.createDate = :createDate and p.id =:id")
    List<Person> findAllByCreateDateAndId(@Param("2003-07-16") String createDate , @Param("1") Integer id);
    @Query("select p from Person p where p.yourMajor = :yourMajor and p.modifiedAt =:modifiedAt")
    List<Person> findAllByYourMajorAndModifiedAt(@Param("SoftDevelopment") String yourMajor , @Param("2002-2-2") Modifier modifiedAt);
    @Query("select p from Person p where p.sex = :sex and p.age =:age and p.password =:password")
    List<Person> findAllBySexAndAgeAndPassword(@Param("Nữ") String sex , @Param("20") int age ,@Param("Kien2003") String password);
    @Query("select p from Person p where p.yourMajor = :yourMajor and p.modifiedAt =:modifiedAt and p.fullname =:fullname")
    List<Person> findAllByYourMajorAndModifiedAtAndFullname(@Param("SoftDevelopment") String yourMajor , @Param("2002-2-2") Modifier modifiedAt, @Param("Trần Minh") String fullname);
    @Query("select p from Person p where p.id =: id")
    List<Person> searchOne (@Param("1") int id);

    Person findAllById(Long id);
    //select * from Person where yourmajor = 'Software development' and classname like 'IT18325'
//      List<Person> findAllByIdBetween(int start, int end);
    //seach theo 5 điều kiện
    @Query("select p from Person p where p.fullname = :fullname and p.age =:age and p.className =: className and p.yourMajor =:yourMajor and p.id =:id")
    List<Person> searchOne (@Param("Nguyễn Kiên") String fullname , @Param("19") int age , @Param("classname") String classname, @Param("SoftDevelopment") String yourMajor ,@Param("1") int id);

    @Query("select p from Person p where p.createDate = :createDate and p.sex =:sex and p.username =: username and p.password =:password and p.modifiedAt =:modifiedAt")
    List<Person> searchOne (@Param("2003-07-16") Date date , @Param("Nam") String sex , @Param("CienMinus") String username, @Param("kien2003@@") String password , @Param("2003-6-4") DateTimeException dateTimeException);





}
