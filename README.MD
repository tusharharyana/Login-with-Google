# OAuth Login (Google) - Full Stack

This project demonstrates **OAuth 2.0 Authentication (Authorization Code Flow)** using **Google Login**, built with:

- Backend: Spring Boot
- Frontend: React
- Authentication: OAuth 2.0 + JWT

---

## Features

- Google OAuth Login
- Authorization Code Flow
- Access Token Exchange (Backend)
- Fetch User Info (Name, Email)
- JWT Generation
- Protected Route (Frontend Ready)

---

## Concepts Covered

- OAuth 2.0 Flow (Authorization Code)
- Redirect URI
- Access Token vs JWT
- Authentication vs Authorization
- Secure Token Handling
- Backend Token Exchange

---


## Setup Instructions

### 🔹 1. Clone Repository

```bash
git clone https://github.com/tusharharyana/Login-with-Google.git
```

## 🔹 2. Backend Setup (Spring Boot)
- Install Dependencies

```bash
cd backend
mvn clean install
```

- Run Backend
```bash
mvn spring-boot:run
```

## 🔹 3. Frontend Setup (React)

```bash
cd frontend
npm install
```
- Run Frontend
```bash
npm run dev
```


### OAuth Flow
- User clicks Login with Google
- Redirect to Google OAuth
- User authenticates
- Google redirects back with authorization code
- Backend exchanges code → access token
- Backend fetches user info
- Backend generates JWT
- User redirected to frontend with token
