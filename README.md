# Event Creation Application :
## Aaomile 🤝

This is a web application designed for users to discover, create, and attend local events. It allows users to view events, register, and book tickets, with functionality similar to Meetup or the event section of BookMyShow. The application includes user login/registration, event creation, and a ticket generation feature.

## Features

- **User Registration and Login**: Users can register and log in to access their profile and manage events.
- **View Local Events**: Browse upcoming events based on location and genre.
- **Event Creation**: Users can create events, providing details like event name, date, genre, and location.
- **Ticket Generation**: After booking an event, users will receive a ticket with their details.
- **Responsive Design**: Built with Bootstrap to ensure a seamless experience on both desktop and mobile.

## Tech Stack

- **Frontend**:
  - HTML
  - CSS
  - Bootstrap
  - JavaScript
- **Backend**:
  - Java
  - Spring Boot
- **Database**:
  - PostgreSQL

## Setup and Installation

### Prerequisites

- Java 11 or above
- Maven (for building the project)
- PostgreSQL

### Steps to Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/event-meetup.git
   cd event-meetup

2. Setup the PostgreSQL database:

Create a new PostgreSQL database and update the credentials in the application.properties file under the src/main/resources directory:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
```
3. Build the project using Maven:
   ```bash
          mvn clean install
4. Run the application:
  ```bash
          mvn spring-boot:run
```
5. Access the application at http://localhost:8080.

# Contributing
### We welcome contribution to improve the project! Here's how you can help

1. Fork the repository:
   ```bash
   git fork https://github.com/yourusername/event-meetup.git
2. Create a new branch for your feature or bug fix:
  ```bash
    git checkout -b feature/my-feature
```
3. Make your changes and commit them:
  ```bash
      git commit -m "Add my feature"
  ```
4. Push your changes to your forked repository:
```bash
  git push origin feature/my-feature
  ```
5. Create a pull request:

### Go to the original repository on GitHub.
Click on the Pull Requests tab and then New Pull Request.
Select your branch and submit your pull request for review.

# Acknowledgements
- Bootstrap for providing a responsive and modern design framework.
- Spring Boot for easy setup and backend functionality.
