package kz.techboot.Sprint_task_61.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.naming.Name;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "t-applicationRequests")
public class ApplicationRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "commentary", columnDefinition = "TEXT")
    private String commentary;

    @Column(name = "phone")
    private String phone;

    @Column(name = "handled")
    private boolean handled;

}
