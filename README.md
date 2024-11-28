# Task Management Application

This application is designed for managing tasks within a company, with the entities `Task` and `Employee`. The application uses **REST API** for task management, and `Employee` is used solely for implementing the **Observer Pattern**.

## Implemented Design Patterns

### 1. **Observer Pattern**
I implemented the **Observer Pattern** to notify all employees when a new task is created. Each employee (observer) is added to the list of observers for a task, and when a task is added to the system, all employees are notified about the new task creation. This pattern enhances communication and ensures that all users are kept up to date with important activities within the company.

### 2. **Builder Pattern**
I used the **Builder Pattern** to construct `Task` objects in a clear and concise manner. The Builder allows for the creation of `Task` objects without requiring a constructor with many parameters. Each attribute is set step-by-step in a fluent manner, and the final `Task` object is created using the `build()` method. This pattern simplifies the process of creating tasks and makes the code easier to manage and read.

### 3. **DTO Pattern**
Although the **DTO Pattern** was not included in the official list of design patterns, I implemented it to ensure the transfer of data between the layers of the application (e.g., between the `Task` entity and the API). DTOs were used to encapsulate the task data and transfer it efficiently between the client and the server, improving the separation of concerns and the clarity of the code. It was essential in creating a structured and clear data flow.

## Features

- **Task Management**: Create, update, and delete tasks via a REST API.
- **Automatic Notification**: When a task is created, all employees are notified via the **Observer Pattern**.
- **Simplified Task Creation**: Tasks are created using the **Builder Pattern**, eliminating the need for a constructor with many parameters.

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database**

## Installation and Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/username/repo-name.git
    ```

2. Run the application:
    ```bash
    mvn spring-boot:run
    ```

The application will start on port 8080 and will automatically populate the database with initial data.

## API Examples

### Create Task
- Endpoint: `POST /api/tasks`
- Request:
    ```json
    {
      "title": "Fix login bug",
      "description": "Resolve login issue.",
      "priority": "HIGH",
      "deadline": "2024-10-15",
      "status": "TO_DO"
    }
    ```

- Response: 
    ```json
    {
      "id": 1,
      "title": "Fix login bug",
      "description": "Resolve login issue.",
      "priority": "HIGH",
      "deadline": "2024-10-15",
      "status": "TO_DO"
    }
    ```

## Conclusion

The application uses **Observer**, **Builder**, and **DTO** patterns to optimize task management and object creation. **Observer** enhances notifications, **Builder** simplifies task creation, and **DTO Pattern** ensures clear data transfer between entities and the API, improving the overall structure of the application.
