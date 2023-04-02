//package com.example.appdemo.Springboot.tutorial.Session;
//import com.example.appdemo.Springboot.tutorial.Entity.Person;
//import jakarta.websocket.Session;
//
//import java.util.List;
//
//
//public class SessionFactoryUpdate {
//
//    public Person findById(int id) {
//        org.hibernate.SessionFactory sessionFactory;
//        Session session = SessionFactory.openSession();
//        Person person = session.load(Person.class, id);
//        System.out.println(person);
//        return person;
//    }
//    public void showAll() {
//        Session session = SessionFactory.openSession();
//        List<Person> list = session.createQuery("FROM Person ").list();
//        for (Person person : list) {
//            System.out.println(person);
//        }
//    }
////    public void updateName(int id, String name) {
////        Session session = sessionFactory.openSession();
////        String sql = "UPDATE Person u SET u.fullname = :newName WHERE u.id = :id";
////        session.createQuery(sql).getSession("newName", name).setInteger("id", id).executeUpdate();
////    }
//    public void update(Person person) {
//        Session session = SessionFactory.openSession();
//        session.update(person);
//    }
//    public void delete(int id) {
//        Session session = SessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            Person person = session.load(Person.class, id);
//            session.delete(person);
//            session.getTransaction().commit();
//            System.out.println("detete success!");
//        } catch (RuntimeException e) {
//            session.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//            session.flush();
//            session.close();
//        }
//    }
//    public void searchByName(String name) {
//        Session session = SessionFactory.openSession();
//        List<Person> list = session.createQuery("FROM Person WHERE fullname LIKE :fullname")
//                .setParameter("name", "%" + name + "%").list();
//        for (Person person : list) {
//            System.out.println(person);
//        }
//    }
//
//}
