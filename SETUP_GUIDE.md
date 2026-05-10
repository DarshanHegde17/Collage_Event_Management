# 🚀 Quick Setup Guide

## Step-by-Step Installation

### 1️⃣ Install Java (if not installed)

**Check if Java is installed:**
```bash
java -version
```

**If not installed:**
- Download Java 17 from: https://www.oracle.com/java/technologies/downloads/
- Or use OpenJDK: https://adoptium.net/

### 2️⃣ Install Maven (if not installed)

**Check if Maven is installed:**
```bash
mvn -version
```

**If not installed:**
- Download from: https://maven.apache.org/download.cgi
- Follow installation guide: https://maven.apache.org/install.html

### 3️⃣ Install MongoDB

**Windows:**
1. Download MongoDB Community Server: https://www.mongodb.com/try/download/community
2. Run the installer
3. Choose "Complete" installation
4. Install as a Windows Service (recommended)
5. MongoDB will start automatically

**Verify MongoDB is running:**
```bash
# Open Command Prompt and type:
mongo --version
```

**Start MongoDB manually (if needed):**
```bash
# Windows
net start MongoDB

# Linux/Mac
sudo systemctl start mongodb
```

### 4️⃣ Run the Application

**Option 1: Using the run script (Windows)**
```bash
run.bat
```

**Option 2: Using the run script (Linux/Mac)**
```bash
chmod +x run.sh
./run.sh
```

**Option 3: Manual commands**
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

### 5️⃣ Access the Application

Open your browser and go to:
```
http://localhost:8080
```

## 🎯 First Time Usage

### Admin Access
1. Click "Admin Portal"
2. Login with:
   - Username: `nit`
   - Password: `nit`
3. Create your first event!

### Student Access
1. Click "New Student? Register"
2. Fill in your details
3. Login with your credentials
4. Browse and register for events!

## 🔍 Verify MongoDB Connection

**Check if MongoDB is running:**
```bash
# Windows
tasklist | findstr mongod

# Linux/Mac
ps aux | grep mongod
```

**Connect to MongoDB shell:**
```bash
mongosh
# or older versions:
mongo
```

**View the database:**
```javascript
show dbs
use college_event_db
show collections
```

## ⚠️ Common Issues

### Issue 1: MongoDB not running
**Error:** `MongoSocketOpenException`

**Solution:**
```bash
# Windows
net start MongoDB

# Linux
sudo systemctl start mongodb

# Mac
brew services start mongodb-community
```

### Issue 2: Port 8080 already in use
**Error:** `Port 8080 is already in use`

**Solution 1:** Stop the process using port 8080
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Linux/Mac
lsof -i :8080
kill -9 <PID>
```

**Solution 2:** Change the port in `application.properties`
```properties
server.port=8081
```

### Issue 3: Maven build fails
**Solution:**
```bash
# Clean and rebuild
mvn clean install -U

# Skip tests if needed
mvn clean install -DskipTests
```

### Issue 4: Java version mismatch
**Error:** `Unsupported class file major version`

**Solution:** Ensure Java 17 or higher is installed
```bash
java -version
# Should show version 17 or higher
```

## 📊 Testing the Application

### Create Sample Event (Admin)
1. Login as admin
2. Fill in event details:
   - Event Name: "Tech Fest 2026"
   - Venue: "Main Auditorium"
   - Date: Select future date
   - Participant Limit: 100
   - Description: "Annual technical festival"
3. Click "Create Event"

### Register as Student
1. Go to Student Registration
2. Fill in details:
   - Name: "John Doe"
   - Roll Number: "CS2026001"
   - Email: "john@example.com"
   - Department: "Computer Science"
   - Year: "2nd Year"
   - Username: "john"
   - Password: "password123"
3. Click "Register"
4. Login with your credentials
5. Register for the event!

## 🎉 Success!

If you can see the home page and login successfully, your setup is complete!

## 📞 Need Help?

- Check MongoDB is running: `mongosh` or `mongo`
- Check Java version: `java -version`
- Check Maven version: `mvn -version`
- Check application logs in the terminal

---

**Enjoy managing your college events! 🎓**
