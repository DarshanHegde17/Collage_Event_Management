# ⚡ Quick Start - College Event Management System

## 🚀 Get Started in 5 Minutes!

### Prerequisites Check
```bash
# Check Java (need 17+)
java -version

# Check Maven
mvn -version

# Check MongoDB
mongosh --version
```

### Installation Steps

#### 1️⃣ Start MongoDB
```bash
# Windows
net start MongoDB

# Linux
sudo systemctl start mongodb

# Mac
brew services start mongodb-community
```

#### 2️⃣ Run the Application
```bash
# Windows
run.bat

# Linux/Mac
chmod +x run.sh
./run.sh
```

#### 3️⃣ Access the Application
Open browser: **http://localhost:8080**

---

## 🎯 First Steps

### Try Admin Features (2 minutes)

1. **Login as Admin**
   - Click "Admin Portal"
   - Username: `nit`
   - Password: `nit`

2. **Create Your First Event**
   ```
   Event Name: Tech Fest 2026
   Venue: Main Auditorium
   Date: [Select future date]
   Participant Limit: 100
   Description: Annual technical festival
   ```
   - Click "Create Event"
   - ✅ Event appears in the list!

3. **View Dashboard**
   - See event statistics
   - Monitor participant count
   - View all registrations

---

### Try Student Features (3 minutes)

1. **Register as Student**
   - Go back to home
   - Click "New Student? Register"
   - Fill in your details:
     ```
     Name: John Doe
     Roll Number: CS2026001
     Email: john@example.com
     Department: Computer Science
     Year: 2nd Year
     Username: john
     Password: password123
     ```
   - Click "Register"

2. **Login as Student**
   - Username: `john`
   - Password: `password123`

3. **Register for Event**
   - Browse available events
   - Click "Register Now" on Tech Fest
   - ✅ Get your registration ID!
   - View in "My Registrations"

---

## 📱 Application URLs

| Page | URL |
|------|-----|
| Home | http://localhost:8080 |
| Admin Login | http://localhost:8080/admin/login |
| Admin Dashboard | http://localhost:8080/admin/dashboard |
| Student Login | http://localhost:8080/student/login |
| Student Register | http://localhost:8080/student/register |
| Student Dashboard | http://localhost:8080/student/dashboard |

---

## 🎨 Features Overview

### Admin Can:
- ✅ Login with default credentials (nit/nit)
- ✅ Create events with details
- ✅ Set participant limits
- ✅ Delete events
- ✅ View all registrations
- ✅ Monitor participant statistics

### Students Can:
- ✅ Register with complete profile
- ✅ Login securely
- ✅ Browse all events
- ✅ Register for events
- ✅ Get unique registration ID
- ✅ View their registrations
- ✅ See real-time seat availability

---

## 🔧 Configuration

### Change Port (if 8080 is busy)
Edit `src/main/resources/application.properties`:
```properties
server.port=8081
```

### Change MongoDB Settings
```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=college_event_db
```

---

## 🐛 Troubleshooting

### Problem: MongoDB not running
```bash
# Windows
net start MongoDB

# Linux
sudo systemctl start mongodb

# Mac
brew services start mongodb-community
```

### Problem: Port 8080 in use
**Option 1:** Stop the process
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Linux/Mac
lsof -i :8080
kill -9 <PID>
```

**Option 2:** Change port in `application.properties`

### Problem: Build fails
```bash
mvn clean install -U
```

---

## 📊 Project Structure

```
college-event-management/
├── src/
│   ├── main/
│   │   ├── java/com/college/event/
│   │   │   ├── EventManagementApplication.java  ← Main class
│   │   │   ├── controller/                      ← Request handlers
│   │   │   ├── service/                         ← Business logic
│   │   │   ├── repository/                      ← Database access
│   │   │   ├── model/                           ← Data models
│   │   │   └── config/                          ← Configuration
│   │   └── resources/
│   │       ├── application.properties           ← Settings
│   │       ├── static/css/                      ← Stylesheets
│   │       └── templates/                       ← HTML pages
├── pom.xml                                      ← Dependencies
├── README.md                                    ← Documentation
├── SETUP_GUIDE.md                              ← Setup instructions
├── TESTING_GUIDE.md                            ← Testing guide
├── PROJECT_OVERVIEW.md                         ← Architecture
└── run.bat / run.sh                            ← Run scripts
```

---

## 🎓 Default Credentials

### Admin
- **Username:** nit
- **Password:** nit

### Students
- Register your own account!

---

## 📚 Documentation Files

| File | Description |
|------|-------------|
| `README.md` | Complete project documentation |
| `SETUP_GUIDE.md` | Detailed installation guide |
| `TESTING_GUIDE.md` | Manual testing checklist |
| `PROJECT_OVERVIEW.md` | Architecture and design |
| `QUICK_START.md` | This file - quick start guide |

---

## 🎯 Success Checklist

- ☐ MongoDB is running
- ☐ Application starts without errors
- ☐ Can access http://localhost:8080
- ☐ Admin login works (nit/nit)
- ☐ Can create events
- ☐ Student registration works
- ☐ Student can register for events
- ☐ Registration ID is generated

**All checked? You're ready to go! 🎉**

---

## 💡 Tips

1. **Keep MongoDB running** - Application needs it
2. **Use Chrome/Firefox** - Best browser support
3. **Check console logs** - For debugging
4. **Read error messages** - They're helpful!
5. **Test with multiple students** - More fun!

---

## 🆘 Need Help?

1. Check `SETUP_GUIDE.md` for detailed instructions
2. Check `TESTING_GUIDE.md` for testing scenarios
3. Check `PROJECT_OVERVIEW.md` for architecture details
4. Check application logs in terminal
5. Verify MongoDB is running: `mongosh`

---

## 🎉 What's Next?

After getting started:

1. **Explore Features**
   - Create multiple events
   - Register multiple students
   - Test participant limits
   - View registration reports

2. **Customize**
   - Change colors in `style.css`
   - Add more departments
   - Modify event fields
   - Add new features

3. **Learn**
   - Study the code structure
   - Understand Spring Boot
   - Learn MongoDB queries
   - Explore REST APIs

---

**Enjoy your College Event Management System! 🎓✨**

---

## 📞 Quick Commands Reference

```bash
# Start MongoDB
net start MongoDB                    # Windows
sudo systemctl start mongodb         # Linux
brew services start mongodb-community # Mac

# Build project
mvn clean install

# Run application
mvn spring-boot:run

# Access MongoDB shell
mongosh

# View database
use college_event_db
show collections
db.events.find().pretty()

# Stop application
Ctrl + C
```

---

**Ready? Let's go! 🚀**
