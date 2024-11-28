package org.example.taskmanager.dao;

import jakarta.persistence.*;
import lombok.*;
import org.example.taskmanager.observer.ObservedSubject;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task implements ObservedSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    private String deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToMany
    @JoinTable(
            name = "task_observers",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private final List<Employee> observers = new ArrayList<>();


    @Override
    public void addObserver(Employee employee) {
        observers.add(employee);
    }

    @Override
    public void removeObserver(Employee employee) {
        observers.remove(employee);
    }

    @Override
    public void notifyObservers() {
        for (Employee observer : observers) {
            observer.sendNotification("The task '" + title + "' has been created.");
        }
    }

    public static TaskBuilder builder() {
        return new TaskBuilder();
    }

    public static class TaskBuilder {
        private Long id;
        private String title;
        private String description;
        private TaskPriority priority;
        private String deadline;
        private TaskStatus status;

        TaskBuilder() {}

        public TaskBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public TaskBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public TaskBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public TaskBuilder priority(final TaskPriority priority) {
            this.priority = priority;
            return this;
        }

        public TaskBuilder deadline(final String deadline) {
            this.deadline = deadline;
            return this;
        }

        public TaskBuilder status(final TaskStatus status) {
            this.status = status;
            return this;
        }

        public Task build() {
            return new Task(this.id, this.title, this.description, this.priority, this.deadline, this.status);
        }
    }
}
