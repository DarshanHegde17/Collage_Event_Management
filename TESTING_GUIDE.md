# 🧪 Testing Guide - College Event Management System

## Manual Testing Checklist

### ✅ Admin Module Testing

#### Test 1: Admin Login
**Steps:**
1. Navigate to `http://localhost:8080`
2. Click "Admin Portal"
3. Enter username: `nit`
4. Enter password: `nit`
5. Click "Login"

**Expected Result:**
- ✓ Redirected to admin dashboard
- ✓ Welcome message shows "Welcome, nit"
- ✓ Can see event creation form

**Test Invalid Login:**
1. Enter wrong username/password
2. Click "Login"

**Expected Result:**
- ✓ Error message: "Invalid credentials"
- ✓ Stays on login page

---

#### Test 2: Create Event
**Steps:**
1. Login as admin
2. Fill in event form:
   - Event Name: "Tech Fest 2026"
   - Venue: "Main Auditorium"
   - Date: Select future date
   - Participant Limit: 100
   - Description: "Annual technical festival"
3. Click "Create Event"

**Expected Result:**
- ✓ Success message appears
- ✓ Event appears in events list
- ✓ Form is cleared
- ✓ Event shows 0/100 participants

---

#### Test 3: View All Events
**Steps:**
1. Login as admin
2. Scroll to "All Events" section

**Expected Result:**
- ✓ All created events are displayed
- ✓ Each event shows:
  - Event name
  - Description
  - Venue
  - Date and time
  - Participant count
  - Progress bar
  - Delete button

---

#### Test 4: Delete Event
**Steps:**
1. Login as admin
2. Find an event
3. Click "Delete Event"
4. Confirm deletion

**Expected Result:**
- ✓ Confirmation dialog appears
- ✓ Event is removed from list
- ✓ Success message appears

---

#### Test 5: View All Registrations
**Steps:**
1. Login as admin
2. Scroll to "All Registrations" section
3. Click "Refresh"

**Expected Result:**
- ✓ Table shows all registrations
- ✓ Displays: Registration ID, Student Name, Event Name, Date, Status
- ✓ If no registrations: "No registrations yet" message

---

### ✅ Student Module Testing

#### Test 6: Student Registration
**Steps:**
1. Navigate to home page
2. Click "New Student? Register"
3. Fill in form:
   - Name: "John Doe"
   - Roll Number: "CS2026001"
   - Email: "john@example.com"
   - Department: "Computer Science"
   - Year: "2nd Year"
   - Username: "john"
   - Password: "password123"
4. Click "Register"

**Expected Result:**
- ✓ Success message appears
- ✓ Redirected to login page after 2 seconds

**Test Duplicate Registration:**
1. Try to register with same username/email/roll number

**Expected Result:**
- ✓ Error message: "Username already exists" (or email/roll number)

---

#### Test 7: Student Login
**Steps:**
1. Navigate to student login
2. Enter registered username
3. Enter password
4. Click "Login"

**Expected Result:**
- ✓ Redirected to student dashboard
- ✓ Welcome message shows student name
- ✓ Can see available events

**Test Invalid Login:**
1. Enter wrong credentials

**Expected Result:**
- ✓ Error message: "Invalid credentials"

---

#### Test 8: View Available Events
**Steps:**
1. Login as student
2. View "Available Events" section

**Expected Result:**
- ✓ All events are displayed
- ✓ Each event shows:
  - Event name
  - Description
  - Venue
  - Date
  - Available seats
  - Progress bar
  - "Register Now" button (if seats available)
  - "Event Full" button (if no seats)

---

#### Test 9: Register for Event
**Steps:**
1. Login as student
2. Find an event with available seats
3. Click "Register Now"
4. Confirm registration

**Expected Result:**
- ✓ Confirmation dialog appears
- ✓ Modal shows registration ID (format: REG-XXXXXXXX)
- ✓ Registration ID is displayed prominently
- ✓ Event participant count increases
- ✓ Available seats decrease

---

#### Test 10: View My Registrations
**Steps:**
1. Login as student
2. Scroll to "My Registrations" section
3. Click "Refresh"

**Expected Result:**
- ✓ Table shows all student's registrations
- ✓ Displays: Registration ID, Event Name, Date, Status
- ✓ Status shows "CONFIRMED"

---

#### Test 11: Duplicate Registration Prevention
**Steps:**
1. Login as student
2. Register for an event
3. Try to register for same event again

**Expected Result:**
- ✓ Error message: "Already registered for this event"
- ✓ Registration is not created

---

#### Test 12: Event Full Scenario
**Steps:**
1. Create event with limit of 2 participants
2. Register 2 students for the event
3. Try to register 3rd student

**Expected Result:**
- ✓ Button shows "Event Full" (disabled)
- ✓ If clicked: Error message "Event is full"
- ✓ Progress bar shows 100%

---

### ✅ Session Management Testing

#### Test 13: Logout Functionality
**Steps:**
1. Login as admin or student
2. Click "Logout"

**Expected Result:**
- ✓ Redirected to home page
- ✓ Session is cleared
- ✓ Cannot access dashboard without login

---

#### Test 14: Unauthorized Access
**Steps:**
1. Without logging in, try to access:
   - `http://localhost:8080/admin/dashboard`
   - `http://localhost:8080/student/dashboard`

**Expected Result:**
- ✓ Redirected to respective login pages

---

### ✅ UI/UX Testing

#### Test 15: Responsive Design
**Steps:**
1. Open application in browser
2. Resize window to mobile size
3. Test all pages

**Expected Result:**
- ✓ Layout adapts to screen size
- ✓ Forms are usable on mobile
- ✓ Buttons are clickable
- ✓ Text is readable

---

#### Test 16: Form Validation
**Steps:**
1. Try to submit forms with empty fields
2. Try to submit with invalid email format

**Expected Result:**
- ✓ Browser validation prevents submission
- ✓ Required fields are marked
- ✓ Email format is validated

---

#### Test 17: Visual Feedback
**Steps:**
1. Hover over buttons
2. Click buttons
3. Submit forms

**Expected Result:**
- ✓ Buttons change color on hover
- ✓ Smooth transitions
- ✓ Success/error messages are visible
- ✓ Loading states (if applicable)

---

## 🔍 Database Testing

### Test 18: MongoDB Data Persistence
**Steps:**
1. Create events and registrations
2. Stop the application
3. Restart the application
4. Login and check data

**Expected Result:**
- ✓ All data is preserved
- ✓ Events still exist
- ✓ Registrations still exist
- ✓ User accounts still exist

---

### Test 19: Data Integrity
**Steps:**
1. Check MongoDB collections:
```bash
mongosh
use college_event_db
db.events.find().pretty()
db.students.find().pretty()
db.registrations.find().pretty()
db.admins.find().pretty()
```

**Expected Result:**
- ✓ All collections exist
- ✓ Data structure matches models
- ✓ Relationships are maintained

---

## 🐛 Error Handling Testing

### Test 20: MongoDB Connection Error
**Steps:**
1. Stop MongoDB service
2. Try to start application

**Expected Result:**
- ✓ Application shows connection error
- ✓ Error message is clear

---

### Test 21: Invalid Event ID
**Steps:**
1. Try to register for non-existent event
2. Use browser console to send request with invalid ID

**Expected Result:**
- ✓ Error message: "Event not found"
- ✓ No registration is created

---

## 📊 Performance Testing

### Test 22: Multiple Registrations
**Steps:**
1. Create event with 100 participant limit
2. Register 50 students quickly
3. Check participant count

**Expected Result:**
- ✓ All registrations are processed
- ✓ Participant count is accurate
- ✓ No duplicate registrations

---

### Test 23: Large Event List
**Steps:**
1. Create 20+ events
2. Load student dashboard
3. Check page load time

**Expected Result:**
- ✓ Page loads within reasonable time
- ✓ All events are displayed
- ✓ No performance issues

---

## 🔐 Security Testing

### Test 24: SQL Injection (Not applicable - using MongoDB)
**Steps:**
1. Try entering special characters in forms
2. Try entering MongoDB query syntax

**Expected Result:**
- ✓ Input is treated as string
- ✓ No database manipulation

---

### Test 25: XSS Prevention
**Steps:**
1. Try entering `<script>alert('XSS')</script>` in forms
2. Submit and view data

**Expected Result:**
- ✓ Script is not executed
- ✓ Data is escaped/sanitized

---

## 📝 Test Results Template

```
Test Date: ___________
Tester Name: ___________

| Test # | Test Name | Status | Notes |
|--------|-----------|--------|-------|
| 1 | Admin Login | ☐ Pass ☐ Fail | |
| 2 | Create Event | ☐ Pass ☐ Fail | |
| 3 | View All Events | ☐ Pass ☐ Fail | |
| 4 | Delete Event | ☐ Pass ☐ Fail | |
| 5 | View All Registrations | ☐ Pass ☐ Fail | |
| 6 | Student Registration | ☐ Pass ☐ Fail | |
| 7 | Student Login | ☐ Pass ☐ Fail | |
| 8 | View Available Events | ☐ Pass ☐ Fail | |
| 9 | Register for Event | ☐ Pass ☐ Fail | |
| 10 | View My Registrations | ☐ Pass ☐ Fail | |
| 11 | Duplicate Prevention | ☐ Pass ☐ Fail | |
| 12 | Event Full Scenario | ☐ Pass ☐ Fail | |
| 13 | Logout | ☐ Pass ☐ Fail | |
| 14 | Unauthorized Access | ☐ Pass ☐ Fail | |
| 15 | Responsive Design | ☐ Pass ☐ Fail | |
| 16 | Form Validation | ☐ Pass ☐ Fail | |
| 17 | Visual Feedback | ☐ Pass ☐ Fail | |
| 18 | Data Persistence | ☐ Pass ☐ Fail | |
| 19 | Data Integrity | ☐ Pass ☐ Fail | |
| 20 | Connection Error | ☐ Pass ☐ Fail | |
| 21 | Invalid Event ID | ☐ Pass ☐ Fail | |
| 22 | Multiple Registrations | ☐ Pass ☐ Fail | |
| 23 | Large Event List | ☐ Pass ☐ Fail | |
| 24 | SQL Injection | ☐ Pass ☐ Fail | |
| 25 | XSS Prevention | ☐ Pass ☐ Fail | |

Overall Result: ☐ All Tests Passed ☐ Some Tests Failed

Comments:
_________________________________
_________________________________
```

---

## 🎯 Quick Test Scenario

**Complete User Journey (5 minutes):**

1. ✅ Open application → Home page loads
2. ✅ Admin login (nit/nit) → Dashboard loads
3. ✅ Create event "Test Event" → Event created
4. ✅ Logout → Back to home
5. ✅ Student register → Account created
6. ✅ Student login → Dashboard loads
7. ✅ Register for "Test Event" → Get registration ID
8. ✅ View my registrations → Shows registration
9. ✅ Admin login → View registrations → Shows student registration
10. ✅ Delete event → Event removed

**If all steps pass: ✅ Application is working correctly!**

---

**Happy Testing! 🎉**
