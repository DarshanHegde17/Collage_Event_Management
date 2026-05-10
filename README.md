# 🎓 College Event Management System

A comprehensive web-based event management system for colleges built with **Java Spring Boot**, **HTML/CSS**, and **MongoDB**.

> **👋 New here? Start with [START_HERE.md](START_HERE.md) or [QUICK_START.md](QUICK_START.md)**  
> **📚 Need documentation? Check [INDEX.md](INDEX.md) for complete guide**

## 📋 Features

### Admin Module
- ✅ Secure login (Username: `nit`, Password: `nit`)
- ✅ Create new events with details (name, venue, date, participant limit, description)
- ✅ View all events with participant statistics
- ✅ Delete events
- ✅ View all student registrations
- ✅ Real-time participant tracking

### Student Module
- ✅ Student registration with complete profile
- ✅ Secure login system
- ✅ View all available events
- ✅ Register for events
- ✅ Automatic registration ID generation
- ✅ View personal registrations
- ✅ Participant limit enforcement
- ✅ Real-time seat availability

## 🛠️ Technology Stack

- **Backend:** Java 17, Spring Boot 3.2.0
- **Frontend:** HTML5, CSS3, JavaScript
- **Database:** MongoDB
- **Template Engine:** Thymeleaf
- **Build Tool:** Maven

## 📦 Project Structure

```
college-event-management/
├── src/
│   ├── main/
│   │   ├── java/com/college/event/
│   │   │   ├── EventManagementApplication.java
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── HomeController.java
│   │   │   │   ├── AdminController.java
│   │   │   │   └── StudentController.java
│   │   │   ├── model/
│   │   │   │   ├── Admin.java
│   │   │   │   ├── Student.java
│   │   │   │   ├── Event.java
│   │   │   │   └── Registration.java
│   │   │   ├── repository/
│   │   │   │   ├── AdminRepository.java
│   │   │   │   ├── StudentRepository.java
│   │   │   │   ├── EventRepository.java
│   │   │   │   └── RegistrationRepository.java
│   │   │   └── service/
│   │   │       ├── AdminService.java
│   │   │       ├── StudentService.java
│   │   │       ├── EventService.java
│   │   │       └── RegistrationService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/css/
│   │       │   └── style.css
│   │       └── templates/
│   │           ├── index.html
│   │           ├── admin-login.html
│   │           ├── admin-dashboard.html
│   │           ├── student-login.html
│   │           ├── student-register.html
│   │           └── student-dashboard.html
├── pom.xml
└── README.md
```

## 🚀 Installation & Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MongoDB 4.4+ (running on localhost:27017)

### Step 1: Install MongoDB

**Windows:**
1. Download MongoDB from [https://www.mongodb.com/try/download/community](https://www.mongodb.com/try/download/community)
2. Install and start MongoDB service
3. MongoDB will run on `localhost:27017` by default

**Linux/Mac:**
```bash
# Install MongoDB
sudo apt-get install mongodb  # Ubuntu/Debian
brew install mongodb-community  # Mac

# Start MongoDB
sudo systemctl start mongodb  # Linux
brew services start mongodb-community  # Mac
```

### Step 2: Clone/Download Project
```bash
# If using git
git clone <repository-url>
cd college-event-management

# Or extract the project folder
```

### Step 3: Build the Project
```bash
mvn clean install
```

### Step 4: Run the Application
```bash
mvn spring-boot:run
```

Or run the JAR file:
```bash
java -jar target/event-management-1.0.0.jar
```

### Step 5: Access the Application
Open your browser and navigate to:
```
http://localhost:8080
```

## 👥 Default Credentials

### Admin Login
- **Username:** `nit`
- **Password:** `nit`

### Student Login
Students need to register first using the "Student Registration" page.

## 📱 Usage Guide

### For Admin:
1. Go to Admin Login
2. Enter credentials (nit/nit)
3. Create events with all details
4. View participant statistics
5. Delete events if needed
6. Monitor all registrations

### For Students:
1. Register as a new student
2. Login with your credentials
3. Browse available events
4. Register for events (if seats available)
5. Get unique registration ID
6. View your registrations

## 🗄️ Database Collections

The application automatically creates these MongoDB collections:

- **admins** - Admin user accounts
- **students** - Student user accounts
- **events** - Event information
- **registrations** - Event registrations

## 🔧 Configuration

Edit `src/main/resources/application.properties` to change:

```properties
# Server Port
server.port=8080

# MongoDB Configuration
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=college_event_db
```

## 🎨 Features Highlights

### Registration ID System
- Automatically generates unique registration IDs (format: REG-XXXXXXXX)
- Students receive their registration ID immediately after registration

### Participant Limit Management
- Events have configurable participant limits
- Real-time seat availability tracking
- Automatic prevention of over-registration

### Responsive Design
- Modern, clean UI with gradient backgrounds
- Mobile-friendly responsive layout
- Smooth animations and transitions

### Security
- Separate admin and student authentication
- Session-based authentication
- Password-protected access

## 🐛 Troubleshooting

### MongoDB Connection Error
```
Error: MongoSocketOpenException
```
**Solution:** Ensure MongoDB is running on localhost:27017

### Port Already in Use
```
Error: Port 8080 is already in use
```
**Solution:** Change port in application.properties or stop the process using port 8080

### Build Errors
```bash
# Clean and rebuild
mvn clean install -U
```

## 📝 API Endpoints

### Admin Endpoints
- `POST /admin/login` - Admin login
- `GET /admin/dashboard` - Admin dashboard
- `POST /admin/event/create` - Create event
- `DELETE /admin/event/delete/{id}` - Delete event
- `GET /admin/registrations` - View all registrations

### Student Endpoints
- `POST /student/register` - Student registration
- `POST /student/login` - Student login
- `GET /student/dashboard` - Student dashboard
- `POST /student/event/register/{eventId}` - Register for event
- `GET /student/registrations` - View my registrations

## 🤝 Contributing

Feel free to fork this project and submit pull requests for any improvements.

## 📄 License

This project is open source and available for educational purposes.

## 👨‍💻 Developer

Created for NIT College Event Management

---

**Happy Event Managing! 🎉**
