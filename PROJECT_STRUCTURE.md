# 📁 Project Structure - College Event Management System

## Complete File Tree

```
college-event-management/
│
├── 📄 pom.xml                          # Maven configuration & dependencies
├── 📄 .gitignore                       # Git ignore rules
├── 📄 README.md                        # Main documentation
├── 📄 QUICK_START.md                   # Quick start guide
├── 📄 SETUP_GUIDE.md                   # Detailed setup instructions
├── 📄 TESTING_GUIDE.md                 # Testing checklist
├── 📄 PROJECT_OVERVIEW.md              # Architecture documentation
├── 📄 PROJECT_STRUCTURE.md             # This file
├── 🔧 run.bat                          # Windows run script
├── 🔧 run.sh                           # Linux/Mac run script
│
└── 📁 src/
    └── 📁 main/
        ├── 📁 java/
        │   └── 📁 com/
        │       └── 📁 college/
        │           └── 📁 event/
        │               │
        │               ├── 📄 EventManagementApplication.java  # Main Spring Boot application
        │               │
        │               ├── 📁 config/
        │               │   └── 📄 SecurityConfig.java          # Security configuration
        │               │
        │               ├── 📁 controller/                      # REST Controllers
        │               │   ├── 📄 HomeController.java          # Home & navigation routes
        │               │   ├── 📄 AdminController.java         # Admin endpoints
        │               │   └── 📄 StudentController.java       # Student endpoints
        │               │
        │               ├── 📁 model/                           # Data Models (Entities)
        │               │   ├── 📄 Admin.java                   # Admin entity
        │               │   ├── 📄 Student.java                 # Student entity
        │               │   ├── 📄 Event.java                   # Event entity
        │               │   └── 📄 Registration.java            # Registration entity
        │               │
        │               ├── 📁 repository/                      # Database Repositories
        │               │   ├── 📄 AdminRepository.java         # Admin data access
        │               │   ├── 📄 StudentRepository.java       # Student data access
        │               │   ├── 📄 EventRepository.java         # Event data access
        │               │   └── 📄 RegistrationRepository.java  # Registration data access
        │               │
        │               └── 📁 service/                         # Business Logic Services
        │                   ├── 📄 AdminService.java            # Admin business logic
        │                   ├── 📄 StudentService.java          # Student business logic
        │                   ├── 📄 EventService.java            # Event business logic
        │                   └── 📄 RegistrationService.java     # Registration business logic
        │
        └── 📁 resources/
            ├── 📄 application.properties                       # Application configuration
            │
            ├── 📁 static/                                      # Static resources
            │   └── 📁 css/
            │       └── 📄 style.css                            # Main stylesheet
            │
            └── 📁 templates/                                   # HTML templates (Thymeleaf)
                ├── 📄 index.html                               # Home page
                ├── 📄 admin-login.html                         # Admin login page
                ├── 📄 admin-dashboard.html                     # Admin dashboard
                ├── 📄 student-login.html                       # Student login page
                ├── 📄 student-register.html                    # Student registration page
                └── 📄 student-dashboard.html                   # Student dashboard
```

---

## 📊 File Count Summary

| Category | Count | Description |
|----------|-------|-------------|
| Java Files | 19 | Backend code |
| HTML Files | 6 | Frontend pages |
| CSS Files | 1 | Styling |
| Config Files | 2 | Configuration |
| Documentation | 6 | Guides & docs |
| Scripts | 2 | Run scripts |
| **Total** | **36** | **All files** |

---

## 🎯 File Purposes

### 📄 Configuration Files

#### `pom.xml`
- Maven project configuration
- Dependencies: Spring Boot, MongoDB, Thymeleaf, Lombok, Security
- Build configuration
- Java version: 17

#### `application.properties`
- Server port: 8080
- MongoDB connection settings
- Thymeleaf configuration
- Logging settings

#### `.gitignore`
- Excludes build files, IDE files, logs
- Keeps repository clean

---

### 🔧 Run Scripts

#### `run.bat` (Windows)
```batch
Builds and runs the application on Windows
Commands: mvn clean install && mvn spring-boot:run
```

#### `run.sh` (Linux/Mac)
```bash
Builds and runs the application on Unix systems
Commands: mvn clean install && mvn spring-boot:run
```

---

### 📚 Documentation Files

| File | Purpose | Audience |
|------|---------|----------|
| `README.md` | Complete project documentation | Everyone |
| `QUICK_START.md` | 5-minute quick start guide | New users |
| `SETUP_GUIDE.md` | Detailed installation steps | Developers |
| `TESTING_GUIDE.md` | Manual testing checklist | Testers |
| `PROJECT_OVERVIEW.md` | Architecture & design | Developers |
| `PROJECT_STRUCTURE.md` | File organization | Developers |

---

### ☕ Java Source Files

#### Main Application
```
EventManagementApplication.java
└── Entry point for Spring Boot application
```

#### Configuration Layer
```
config/
└── SecurityConfig.java
    └── Spring Security configuration
    └── Disables CSRF for simplicity
    └── Permits all requests
```

#### Controller Layer (REST APIs)
```
controller/
├── HomeController.java
│   ├── GET /                      → Home page
│   ├── GET /admin/login           → Admin login page
│   ├── GET /student/login         → Student login page
│   └── GET /student/register      → Student registration page
│
├── AdminController.java
│   ├── POST /admin/login          → Admin authentication
│   ├── GET /admin/dashboard       → Admin dashboard
│   ├── POST /admin/event/create   → Create event
│   ├── DELETE /admin/event/delete/{id} → Delete event
│   ├── GET /admin/registrations   → View all registrations
│   └── GET /admin/logout          → Logout
│
└── StudentController.java
    ├── POST /student/register     → Student registration
    ├── POST /student/login        → Student authentication
    ├── GET /student/dashboard     → Student dashboard
    ├── POST /student/event/register/{eventId} → Register for event
    ├── GET /student/registrations → View my registrations
    └── GET /student/logout        → Logout
```

#### Model Layer (Entities)
```
model/
├── Admin.java
│   ├── id: String
│   ├── username: String
│   ├── password: String
│   ├── email: String
│   └── role: String = "ADMIN"
│
├── Student.java
│   ├── id: String
│   ├── username: String
│   ├── password: String
│   ├── name: String
│   ├── email: String
│   ├── rollNumber: String
│   ├── department: String
│   ├── year: String
│   └── role: String = "STUDENT"
│
├── Event.java
│   ├── id: String
│   ├── eventName: String
│   ├── description: String
│   ├── venue: String
│   ├── eventDate: LocalDateTime
│   ├── participantLimit: int
│   ├── currentParticipants: int
│   ├── createdBy: String
│   └── createdAt: LocalDateTime
│
└── Registration.java
    ├── id: String
    ├── registrationId: String (REG-XXXXXXXX)
    ├── studentId: String
    ├── studentName: String
    ├── eventId: String
    ├── eventName: String
    ├── registeredAt: LocalDateTime
    └── status: String = "CONFIRMED"
```

#### Repository Layer (Data Access)
```
repository/
├── AdminRepository.java
│   └── Extends MongoRepository<Admin, String>
│   └── Methods: findByUsername(), existsByUsername()
│
├── StudentRepository.java
│   └── Extends MongoRepository<Student, String>
│   └── Methods: findByUsername(), existsByUsername(), existsByEmail(), existsByRollNumber()
│
├── EventRepository.java
│   └── Extends MongoRepository<Event, String>
│   └── Methods: findAllByOrderByEventDateDesc()
│
└── RegistrationRepository.java
    └── Extends MongoRepository<Registration, String>
    └── Methods: findByStudentId(), findByEventId(), findByStudentIdAndEventId(), countByEventId()
```

#### Service Layer (Business Logic)
```
service/
├── AdminService.java
│   ├── initAdmin()                    → Create default admin
│   └── login(username, password)      → Admin authentication
│
├── StudentService.java
│   ├── register(student)              → Student registration
│   ├── login(username, password)      → Student authentication
│   ├── getStudentById(id)             → Get student details
│   └── getAllStudents()               → List all students
│
├── EventService.java
│   ├── createEvent(event)             → Create new event
│   ├── getAllEvents()                 → List all events
│   ├── getEventById(id)               → Get event details
│   ├── deleteEvent(id)                → Delete event
│   ├── updateEvent(event)             → Update event
│   └── incrementParticipants(eventId) → Update participant count
│
└── RegistrationService.java
    ├── registerForEvent(studentId, eventId) → Register for event
    ├── getStudentRegistrations(studentId)   → Student's registrations
    ├── getEventRegistrations(eventId)       → Event's registrations
    └── getAllRegistrations()                → All registrations
```

---

### 🎨 Frontend Files

#### HTML Templates (Thymeleaf)
```
templates/
├── index.html
│   └── Home page with login options
│   └── Links to admin and student portals
│
├── admin-login.html
│   └── Admin login form
│   └── Shows default credentials
│
├── admin-dashboard.html
│   └── Event creation form
│   └── Events list with statistics
│   └── All registrations table
│   └── Delete event functionality
│
├── student-login.html
│   └── Student login form
│   └── Link to registration
│
├── student-register.html
│   └── Student registration form
│   └── Complete profile fields
│   └── Department and year selection
│
└── student-dashboard.html
    └── Available events grid
    └── Event registration buttons
    └── My registrations table
    └── Registration ID modal
```

#### CSS Stylesheet
```
static/css/style.css
├── Global styles (reset, fonts, colors)
├── Layout (container, grid, flexbox)
├── Components (cards, buttons, forms)
├── Dashboard styles
├── Event cards
├── Tables
├── Modal
├── Progress bars
├── Responsive design
└── Animations & transitions
```

---

## 🔄 Data Flow

### Admin Creates Event
```
1. admin-dashboard.html (Form)
   ↓
2. AdminController.createEvent()
   ↓
3. EventService.createEvent()
   ↓
4. EventRepository.save()
   ↓
5. MongoDB (events collection)
```

### Student Registers for Event
```
1. student-dashboard.html (Button click)
   ↓
2. StudentController.registerForEvent()
   ↓
3. RegistrationService.registerForEvent()
   ├── Check if already registered
   ├── Check event capacity
   ├── Generate registration ID
   ├── Update participant count
   ↓
4. RegistrationRepository.save()
   ↓
5. MongoDB (registrations collection)
   ↓
6. Return registration ID to frontend
   ↓
7. Display in modal
```

---

## 🗄️ MongoDB Collections

```
college_event_db/
├── admins
│   └── Admin documents
│
├── students
│   └── Student documents
│
├── events
│   └── Event documents
│
└── registrations
    └── Registration documents
```

---

## 📦 Dependencies (from pom.xml)

| Dependency | Purpose |
|------------|---------|
| spring-boot-starter-web | Web application & REST APIs |
| spring-boot-starter-data-mongodb | MongoDB integration |
| spring-boot-starter-thymeleaf | Template engine |
| spring-boot-starter-security | Security framework |
| lombok | Reduce boilerplate code |
| spring-boot-devtools | Development tools |
| spring-boot-starter-test | Testing framework |

---

## 🎯 Key Features by File

### Registration ID Generation
**File:** `RegistrationService.java`
```java
String registrationId = "REG-" + UUID.randomUUID()
    .toString().substring(0, 8).toUpperCase();
```

### Default Admin Creation
**File:** `AdminService.java`
```java
@PostConstruct
public void initAdmin() {
    if (!adminRepository.existsByUsername("nit")) {
        // Create default admin
    }
}
```

### Participant Limit Check
**File:** `RegistrationService.java`
```java
long currentRegistrations = registrationRepository.countByEventId(eventId);
if (currentRegistrations >= event.getParticipantLimit()) {
    throw new RuntimeException("Event is full");
}
```

### Session Management
**File:** `StudentController.java`, `AdminController.java`
```java
session.setAttribute("studentId", student.getId());
session.setAttribute("studentName", student.getName());
```

---

## 🚀 Build & Run Process

```
1. Maven reads pom.xml
   ↓
2. Downloads dependencies
   ↓
3. Compiles Java files
   ↓
4. Packages into JAR
   ↓
5. Spring Boot starts
   ↓
6. Connects to MongoDB
   ↓
7. Creates default admin
   ↓
8. Server ready on port 8080
```

---

## 📝 Notes

- **Total Lines of Code:** ~2,500+ lines
- **Java Classes:** 19 files
- **HTML Pages:** 6 pages
- **CSS Rules:** 200+ rules
- **API Endpoints:** 15+ endpoints
- **Database Collections:** 4 collections

---

**This structure follows Spring Boot best practices with clear separation of concerns! 🎯**
