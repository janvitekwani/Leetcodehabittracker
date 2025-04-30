# 📈 Leetcode Habit Tracker

A backend application to help users track their daily progress in Data Structures and Algorithms (DSA) preparation. Inspired by the [DSA Roadmap - 2024](https://www.codingshuttle.com?utm_source=notion&utm_medium=banner&utm_campaign=dsa_roadmap), this project allows users to log their daily problem-solving activities, monitor their consistency, and stay motivated throughout their DSA journey.

## 🛠 Tech Stack

- **Backend Framework:** Spring Boot
- **Language:** Java
- **Database:** MySQL
- **Build Tool:** Maven
-  **Security:** Spring security 


 ## 🚀 Features

- **User Management:**
  - Register and authenticate users.
  - Secure password storage.
- **Daily Tracking:**
  - Log daily problem-solving activities.
  - Track topics covered and difficulty levels.
- **Progress Monitoring:**
  - View weekly and monthly progress summaries.
  - Identify strengths and areas for improvement.
- **DSA Roadmap Integration:**
  - Align daily tasks with the DSA Roadmap - 2024.
  - Receive recommendations based on the roadmap.

## 📦 API Endpoints

### User Endpoints

- `POST /api/users/register` - Register a new user.
- `POST /api/users/login` - Authenticate a user.

### Habit Tracking Endpoints

- `POST /api/habits` - Log a new habit entry.
- `GET /api/habits/{userId}` - Retrieve habit entries for a user.
- `PUT /api/habits/{habitId}` - Update a habit entry.
- `DELETE /api/habits/{habitId}` - Delete a habit entry.

### Progress Endpoints

- `GET /api/progress/{userId}/weekly` - Get weekly progress summary.
- `GET /api/progress/{userId}/monthly` - Get monthly progress summary.

*Note: Replace `{userId}` and `{habitId}` with actual IDs.*


Access the application:


API endpoints will be available at http://localhost:8080/api/.



### SCREENSHOT OF THE IMAGES OF PROJECT
## database mapping for project ![Screenshot (15)](https://github.com/user-attachments/assets/04c94fde-a76f-4c7e-adb9-550f73513df4)
 ##  table mapping for user ![Screenshot (14)](https://github.com/user-attachments/assets/a601858e-1bee-43ee-9c8e-ab56c928553d)
 ## post request to add the user ![Screenshot (13)](https://github.com/user-attachments/assets/25325720-f5cc-48dc-81cd-c40c258cc820)
