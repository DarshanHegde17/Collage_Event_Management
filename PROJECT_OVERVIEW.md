# 📚 College Event Management System - Project Overview

## 🎯 Project Description

A full-stack web application for managing college events, allowing administrators to create and manage events while students can register and participate in them.

## 🏗️ Architecture

### Three-Tier Architecture

```
┌─────────────────────────────────────────┐
│         Presentation Layer              │
│    (HTML, CSS, JavaScript, Thymeleaf)   │
└─────────────────────────────────────────┘
                    ↓
┌─────────────────────────────────────────┐
│         Business Logic Layer            │
│    (Spring Boot Controllers & Services) │
└─────────────────────────────────────────┘
                    ↓
┌─────────────────────────────────────────┐
│         Data Access Layer               │
│    (Spring Data MongoDB Repositories)   │
└─────────────────────────────────────────┘
                    ↓
┌─────────────────────────────────────────┐
│         Database Layer                  │
│            (MongoDB)                    │
└─────────────────────────────────────────┘
```

## 📦 Components

### 1. Models (Data Entities)

#### Admin
- id (String)
- username (String)
- password (String)
- email (String)
- role (String) = "ADMIN"

#### Student
- id (String)
- username (String)
- password (String)
- name (String)
- email (String)
- rollNumber (String)
- department (String)
- year (String)
- role (String) = "STUDENT"

#### Event
- id (String)
- eventName (String)
- description (String)
- venue (String)
- eventDate (LocalDateTime)
- participantLimit (int)
- currentParticipants (int)
- createdBy (String)
- createdAt (LocalDateTime)

#### Registration
- id (String)
- registrationId (String) - Format: REG-XXXXXXXX
- studentId (String)
- studentName (String)
- eventId (String)
- eventName (String)
- registeredAt (LocalDateTime)
- status (String) = "CONFIRMED"

### 2. Repositories (Data Access)

- **AdminRepository** - CRUD operations for admins
- **StudentRepository** - CRUD operations for students
- **EventRepository** - CRUD operations for events
- **RegistrationRepository** - CRUD operations for registrations

### 3. Services (Business Logic)

#### AdminService
- `initAdmin()` - Creates default admin on startup
- `login(username, password)` - Admin authentication

#### StudentService
- `register(student)` - Student registration with validation
- `login(username, password)` - Student authentication
- `getStudentById(id)` - Fetch student details
- `getAllStudents()` - List all students

#### EventService
- `createEvent(event)` - Create new event
- `getAllEvents()` - List all events
- `getEventById(id)` - Fetch event details
- `deleteEvent(id)` - Remove event
- `updateEvent(event)` - Update event details
- `incrementParticipants(eventId)` - Update participant count

#### RegistrationService
- `registerForEvent(studentId, eventId)` - Register student for event
- `getStudentRegistrations(studentId)` - Student's registrations
- `getEventRegistrations(eventId)` - Event's registrations
- `getAllRegistrations()` - All registrations

### 4. Controllers (Request Handlers)

#### HomeController
- `GET /` - Home page
- `GET /admin/login` - Admin login page
- `GET /student/login` - Student login page
- `GET /student/register` - Student registration page

#### AdminController
- `POST /admin/login` - Admin authentication
- `GET /admin/dashboard` - Admin dashboard
- `POST /admin/event/create` - Create event
- `DELETE /admin/event/delete/{id}` - Delete event
- `GET /admin/registrations` - View all registrations
- `GET /admin/logout` - Logout

#### StudentController
- `POST /student/register` - Student registration
- `POST /student/login` - Student authentication
- `GET /student/dashboard` - Student dashboard
- `POST /student/event/register/{eventId}` - Register for event
- `GET /student/registrations` - View my registrations
- `GET /student/logout` - Logout

## 🔐 Security Features

1. **Separate Authentication** - Admin and student login systems are separate
2. **Session Management** - HTTP sessions track logged-in users
3. **Authorization Checks** - Controllers verify user sessions before operations
4. **Password Storage** - Currently plain text (should be encrypted in production)
5. **CSRF Protection** - Disabled for simplicity (should be enabled in production)

## 🎨 Frontend Pages

### 1. index.html (Home Page)
- Welcome page with two login options
- Admin portal button
- Student portal button
- Student registration link

### 2. admin-login.html
- Admin login form
- Default credentials display
- Error/success messages

### 3. admin-dashboard.html
- Event creation form
- List of all events with statistics
- Delete event functionality
- All registrations table
- Logout option

### 4. student-login.html
- Student login form
- Link to registration page
- Error/success messages

### 5. student-register.html
- Comprehensive registration form
- Department and year selection
- Form validation
- Success/error messages

### 6. student-dashboard.html
- Available events grid
- Event registration buttons
- Seat availability display
- My registrations table
- Registration ID modal
- Logout option

## 🎨 CSS Styling

### Design Features
- **Color Scheme:** Purple gradient background (#667eea to #764ba2)
- **Cards:** White cards with rounded corners and shadows
- **Buttons:** Multiple styles (primary, success, danger, outline)
- **Responsive:** Grid layout adapts to screen size
- **Animations:** Smooth transitions and hover effects
- **Typography:** Segoe UI font family

### Key CSS Classes
- `.container` - Main content wrapper
- `.card` - Card component
- `.btn` - Button styles
- `.form-group` - Form field wrapper
- `.event-card` - Event display card
- `.data-table` - Table styling
- `.modal` - Modal dialog
- `.progress-bar` - Progress indicator

## 🔄 Application Flow

### Admin Flow
```
1. Admin visits /admin/login
2. Enters credentials (nit/nit)
3. POST /admin/login validates credentials
4. Session created with adminId
5. Redirected to /admin/dashboard
6. Can create/delete events
7. Can view all registrations
8. Logout clears session
```

### Student Flow
```
1. New student visits /student/register
2. Fills registration form
3. POST /student/register creates account
4. Redirected to /student/login
5. Enters credentials
6. POST /student/login validates credentials
7. Session created with studentId
8. Redirected to /student/dashboard
9. Views available events
10. Clicks "Register Now"
11. POST /student/event/register/{eventId}
12. Receives unique registration ID
13. Can view all registrations
14. Logout clears session
```

## 📊 Database Schema

### MongoDB Collections

```javascript
// admins collection
{
  "_id": ObjectId,
  "username": "nit",
  "password": "nit",
  "email": "admin@nit.edu",
  "role": "ADMIN"
}

// students collection
{
  "_id": ObjectId,
  "username": "john",
  "password": "password123",
  "name": "John Doe",
  "email": "john@example.com",
  "rollNumber": "CS2026001",
  "department": "Computer Science",
  "year": "2nd Year",
  "role": "STUDENT"
}

// events collection
{
  "_id": ObjectId,
  "eventName": "Tech Fest 2026",
  "description": "Annual technical festival",
  "venue": "Main Auditorium",
  "eventDate": ISODate("2026-06-15T10:00:00Z"),
  "participantLimit": 100,
  "currentParticipants": 25,
  "createdBy": "nit",
  "createdAt": ISODate("2026-05-07T12:00:00Z")
}

// registrations collection
{
  "_id": ObjectId,
  "registrationId": "REG-A1B2C3D4",
  "studentId": "student_object_id",
  "studentName": "John Doe",
  "eventId": "event_object_id",
  "eventName": "Tech Fest 2026",
  "registeredAt": ISODate("2026-05-07T14:30:00Z"),
  "status": "CONFIRMED"
}
```

## 🚀 Key Features Implementation

### 1. Registration ID Generation
```java
String registrationId = "REG-" + UUID.randomUUID()
    .toString()
    .substring(0, 8)
    .toUpperCase();
```

### 2. Participant Limit Check
```java
long currentRegistrations = registrationRepository.countByEventId(eventId);
if (currentRegistrations >= event.getParticipantLimit()) {
    throw new RuntimeException("Event is full");
}
```

### 3. Duplicate Registration Prevention
```java
if (registrationRepository.findByStudentIdAndEventId(studentId, eventId).isPresent()) {
    throw new RuntimeException("Already registered for this event");
}
```

### 4. Session-Based Authentication
```java
session.setAttribute("studentId", student.getId());
session.setAttribute("studentName", student.getName());
session.setAttribute("userType", "STUDENT");
```

## 🔧 Configuration

### application.properties
```properties
# Server runs on port 8080
server.port=8080

# MongoDB connection
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=college_event_db

# Thymeleaf template engine
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

## 📈 Future Enhancements

1. **Security Improvements**
   - Password encryption (BCrypt)
   - JWT token authentication
   - CSRF protection
   - Role-based access control

2. **Features**
   - Email notifications
   - Event categories
   - Event search and filter
   - Student profile management
   - Event attendance tracking
   - QR code for registration
   - Event feedback system

3. **UI/UX**
   - Dashboard analytics
   - Charts and graphs
   - Image upload for events
   - Calendar view
   - Dark mode

4. **Technical**
   - Input validation
   - Error handling
   - Logging
   - Unit tests
   - API documentation (Swagger)
   - Docker containerization

## 📝 Notes

- Default admin is created automatically on first run
- MongoDB must be running before starting the application
- Sessions are stored in memory (lost on restart)
- No email verification currently implemented
- Passwords are stored in plain text (not production-ready)

---

**This project demonstrates a complete full-stack application with proper separation of concerns and modern web development practices.**
