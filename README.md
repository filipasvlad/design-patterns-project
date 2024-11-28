# Task Management Application

This application is designed for managing tasks within a company, with the entities `Task` and `Employee`. The application uses **REST API** for task management, and `Employee` is used solely for implementing the **Observer Pattern**.

## Implemented Design Patterns

### 1. **Observer Pattern**
I implemented the **Observer Pattern** to notify all employees when a new task is created. Each employee (observer) is added to the list of observers for a task, and when a task is added to the system, all employees are notified about the new task creation. This pattern enhances communication and ensures that all users are kept up to date with important activities within the company.

### 2. **Builder Pattern**
I used the **Builder Pattern** to construct `Task` objects in a clear and concise manner. The Builder allows for the creation of `Task` objects without requiring a constructor with many parameters. Each attribute is set step-by-step in a fluent manner, and the final `Task` object is created using the `build()` method. This pattern simplifies the process of creating tasks and makes the code easier to manage and read.

## Features

- **Task Management**: Create, update, and delete tasks via a REST API.
- **Automatic Notification**: When a task is created, all employees are notified via the **Observer Pattern**.
- **Simplified Task Creation**: Tasks are created using the **Builder Pattern**, eliminating the need for a constructor with many parameters.

## API Examples

### Create Task
- Endpoint: `POST /tasks`
- Request:
    ```json
    {
      "title": "Fix login bug",
      "description": "Resolve login issue.",
      "priority": "HIGH",
      "deadline": "2024-10-15"
    }
    ```

- Response: 
    ```json
    {
        "id": 11,
        "title": "Fix login bug",
        "description": "Resolve login issue.",
        "priority": "HIGH",
        "deadline": "2024-10-15",
        "status": "TO_DO"
    }
    ```
