package org.example.taskmanager.observer;

import org.example.taskmanager.dao.Employee;

public interface ObservedSubject {
    void addObserver(Employee employee);
    void removeObserver(Employee employee);
    void notifyObservers();
}