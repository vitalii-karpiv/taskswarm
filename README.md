# TaskSwarm API

This is the API for TaskSwarm - a task management application that allows users to create, update, and delete tasks, as well as assign tasks to other users.

## Getting Started

### Prerequisites

- Java 17 or higher
- MySQL
- Gradle 7.5 or higher

### Installation

1. Clone the repository

- git clone https://github.com/yourusername/taskswarm.git

2. Create a MySQL database named `taskswarm`

3. Set the MySQL username and password in `src/main/resources/application.properties`

4. Build and run the application using Gradle

### API Documentation

The API documentation can be found at `/swagger-ui.html` after starting the application.

### API Endpoints

The following endpoints are available:

| Endpoint | Description | Request Body | Response Body |
| -------- | ----------- | ------------ | ------------- |
| `GET /api/v1/tasks` | Get all tasks | None | List of tasks |
| `GET /api/v1/tasks/{id}` | Get a task by ID | None | Task |
| `POST /api/v1/tasks` | Create a new task | Task | Created task |
| `PUT /api/v1/tasks/{id}` | Update a task by ID | Task | Updated task |
| `DELETE /api/v1/tasks/{id}` | Delete a task by ID | None | None |
| `GET /api/v1/users` | Get all users | None | List of users |
| `GET /api/v1/users/{id}` | Get a user by ID | None | User |
| `POST /api/v1/users` | Create a new user | User | Created user |
| `PUT /api/v1/users/{id}` | Update a user by ID | User | Updated user |
| `DELETE /api/v1/users/{id}` | Delete a user by ID | None | None |

### Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Gradle](https://gradle.org/) - Dependency Management
- [MySQL](https://www.mysql.com/) - Database Management

### Versioning

We use [SemVer](https://semver.org/) for versioning.

### License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
