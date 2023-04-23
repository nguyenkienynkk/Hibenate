package com.example.appdemo.Springboot.tutorial.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;
    @Data
    @Entity
    @Table(name = "person")
    @Getter
    @Setter
    @RequiredArgsConstructor
//    Trước khi lưu một entity mới – @PrePersist
//Sau khi lưu một entity mới – @PostPersist
//Trước khi một entity bị xoá – @PreRemove
//Sau khi một entity đã bị xoá – @PostRemove
//Trước khi cập nhật một entity – @PreUpdate
//Sau khi entity đã được cập nhật – @PostUpdate
//Sau khi một entity đã được tải – @PostLoad
    public class Person {
        private static Log log = LogFactory.getLog(Person.class);
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String fullname;
        @Column
        private int age;
        @Column
        private String yourMajor;
        @Column
        private String className;
        @Column
        private String sex;
        @Column(nullable = false, length = 255, unique = true)
        private String username;
        @Column(nullable = false)
        private String password;
        @Temporal(TemporalType.DATE)
        @Column(name="create_date")
        private Date createDate;
        @Column(name = "modified_date")
        @Temporal(value = TemporalType.TIMESTAMP)
        private Date modifiedAt;

        @PrePersist
        public void logNewUserAttempt() {
            log.info("Thêm người dùng mới: " + username);
        }
        @PostPersist
        public void logNewUserAdded() {
            log.info("Người dùng đã thêm:" + username + "' với ID: " + id);
        }
        @PreRemove
        public void logUserRemovalAttempt() {
            log.info("Đang cố xóa người dùng: " + username);
        }
        @PostRemove
        public void logUserRemoval() {
            log.info("Người dùng đã xóa: " + username);
        }
        @PreUpdate
        public void logUserUpdateAttempt() {
            log.info("Đang cố cập nhật người dùng: " + username);
        }
        @PostUpdate
        public void logUserUpdate() {
            log.info("Đã cập nhật người dùng: " + username);
        }

        public static Log getLog() {
            return log;
        }

        public static void setLog(Log log) {
            Person.log = log;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public Date getModifiedAt() {
            return modifiedAt;
        }

        public void setModifiedAt(Date modifiedAt) {
            this.modifiedAt = modifiedAt;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getYourMajor() {
            return yourMajor;
        }

        public void setYourMajor(String yourMajor) {
            this.yourMajor = yourMajor;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", fullname='" + fullname + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", createDate=" + createDate +
                    ", modifiedAt=" + modifiedAt +
                    '}';
        }
    }

