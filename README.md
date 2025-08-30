
# Email Sender Application - Spring Boot

This project is a simple Spring Boot application designed to send emails using a configured SMTP server. It uses environment variables to securely store the username and password required for the email service provider.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Setup and Installation](#setup-and-installation)
5. [Configuration](#configuration)
6. [Running the Application](#running-the-application)
7. [Testing the Application](#testing-the-application)
8. [Contributing](#contributing)
9. [License](#license)

## Project Overview

This Spring Boot application allows users to send emails using an SMTP service (like Gmail, SendGrid, etc.). The email credentials (username and password) are securely stored in environmental variables to avoid hardcoding sensitive data into the codebase. It uses the JavaMailSender API for email sending functionality.

## Features

* Send emails with custom subject, body, and recipient.
* Environment-based configuration for credentials.
* Configurable SMTP settings.
* Simple interface for future extensions.

## Prerequisites

* Java 11 or later
* Maven 3.x or Gradle
* Spring Boot 3.x
* SMTP server Gmail
* An email address to send from Gmail and its password stored in environment variables
* Docker (optional, if you want to run with Docker)

## Setup and Installation

### 1. Clone the Repository

Start by cloning the repository to your local machine.

```bash
git clone https://github.com/yourusername/email-sender-app.git
cd email-sender-app
```

### 2. Install Dependencies

Make sure you have Maven installed. If not, you can install it by following the [Maven Installation Guide](https://maven.apache.org/install.html).

To install dependencies, run:

```bash
mvn clean install
```

This will download the necessary dependencies required for the project.

### 3. Configure Environment Variables

Create the required environment variables for SMTP credentials.

* **MAIL\_USERNAME**: Your email address (e.g., `your-email@gmail.com`).
* **MAIL\_PASSWORD**: Your email password or need to create an Gmail [App Password](https://support.google.com/accounts/answer/185833).
* **SMTP\_HOST**: The SMTP server (e.g., for Gmail, use `smtp.gmail.com`).
* **SMTP\_PORT**: The SMTP port (e.g., for Gmail, use `587` for TLS).


For Windows users, you can use the `set` command in your terminal or set them permanently in your system environment variables.

### 4. Application Configuration

If you want to change default configurations such as SMTP settings or email templates, you can do so in the `src/main/resources/application.properties` File. 
Example:

```properties
spring.mail.host=${SMTP_HOST}
spring.mail.port=${SMTP_PORT}
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
```

Make sure these settings match the environmental variables you defined earlier.

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
```

This will start the application, and it will be ready to accept email requests.

Alternatively, if you prefer a JAR file to run, you can package the application with:

```bash
mvn clean package
```

Then, you can run the JAR file:

```bash
java -jar target/email-sender-app-0.0.1-SNAPSHOT.jar
```

## Testing the Application

Once the application is running, you can test the email-sending functionality by making a POST request to the following endpoint:

**POST** `/send-email`

### Request Body

```json
{
  "to": "recipient-email@example.com",
  "subject": "Test Email",
  "body": "This is a test email sent from the Spring Boot application."
}
```

You can use Postman or cURL to send a POST request to `http://localhost:8080/send-email` with the above JSON payload.

### Example cURL Command

```bash
curl -X POST http://localhost:8080/send-email \
     -H "Content-Type: application/json" \
     -d '{"to": "recipient-email@example.com", "subject": "Test", "body": "Hello World"}'
```

If everything is set up correctly, you should receive an email in the specified inbox.

## Contributing

Feel free to fork this repository and submit pull requests. If you find any bugs or want to add new features, feel free to open an issue and we’ll get to it.

* Clone the repo to your local machine.
* Create a new branch for the feature/bug fix.
* Commit your changes and push them to your fork.
* Submit a pull request with a description of what you’ve done.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to adjust any sections based on your project’s specifics or if you want to include anything else!
