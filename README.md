# EduManage — Course Management System

A full-stack Course Management System built with **Spring Boot** (backend REST API) and **HTML/CSS/JavaScript** (front-end). Students can register, log in, browse available courses, and enroll in them.

## Project Structure

```
├── backend/                 Spring Boot REST API (port 8080)
│   └── src/main/java/com/example/course_management_system/
│       ├── Controller/      REST endpoints (students, courses, enrollments)
│       ├── Service/         Business logic
│       ├── Repositary/      In-memory data storage (HashMap)
│       ├── Model/           Student, Course, Enrollment
│       ├── ResquestDTO/     Incoming request bodies
│       └── ResponseDto/     Outgoing responses
└── front-end/               Web UI (port 5500)
    ├── index.html
    ├── style.css
    └── script.js
```

## Tech Stack

- **Backend:** Java 17, Spring Boot, Maven (wrapper included — no separate Maven install needed)
- **Front-end:** Vanilla HTML, CSS, JavaScript
- **Storage:** In-memory HashMap — no database required

## Prerequisites

- **JDK 17** or newer — [adoptium.net](https://adoptium.net)
- VS Code with the **Live Server** extension (for the front-end)

## How to Run

### 1. Start the backend (port 8080)

```bash
cd backend
```

Windows:

```bat
mvnw.cmd spring-boot:run
```

Mac/Linux:

```bash
./mvnw spring-boot:run
```

Wait for the line `Tomcat started on port 8080`. The first run downloads all dependencies, which can take a few minutes.

### 2. Start the front-end (port 5500)

Open the `front-end` folder in VS Code, right-click `index.html`, and choose **Open with Live Server**.

### 3. Use the app

1. Click **Register** and create a student account
2. Click **Login** and sign in — the dashboard appears
3. Browse **Available Courses** and click **Enroll** on any course

## API Endpoints

| Method | Endpoint               | Description                      |
|--------|------------------------|----------------------------------|
| POST   | `/students/register`   | Register a new student           |
| POST   | `/students/login`      | Log in (returns name and email)  |
| GET    | `/course/all`          | List all available courses       |
| POST   | `/enrollment/create`   | Enroll a student in a course     |

## Important Notes

- **Data is stored in memory.** All students, courses, and enrollments disappear every time the backend restarts. When testing, do register → login → enroll in one server session.
- The front-end expects the backend at `http://localhost:8080` — configured in `front-end/script.js` (`const api`).
