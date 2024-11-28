package org.example.taskmanager.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.taskmanager.observer.Observer;


@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Observer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Override
    public void sendNotification(String message) {
        System.out.println("Notification for " + name + " (Email: " + email + "): " + message);
    }
}