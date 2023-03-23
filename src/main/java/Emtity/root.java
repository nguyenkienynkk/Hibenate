package Emtity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
    @Data
    @Entity(name = "root")
    @Table(name = "root")

    public class root {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String fullname;
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
        @Transient
        private String additionalPropery;


    }

