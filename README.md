# EmailSenderApp
Email Sender Application - Spring Boot

This project is a simple Spring Boot application designed to send emails using a configured SMTP server. It uses environment variables to securely store the username and password required for the email service provider.

Table of Contents

Project Overview

Features

Prerequisites

Setup and Installation

Configuration

Running the Application

Testing the Application

Contributing

License

Project Overview

This Spring Boot application allows users to send emails using an SMTP service (like Gmail, SendGrid, etc.). The email credentials (username and password) are securely stored in environmental variables to avoid hardcoding sensitive data into the codebase. It uses the JavaMailSender API for email sending functionality.

Features

Send emails with custom subject, body, and recipient.

Environment-based configuration for credentials.

Configurable SMTP settings.

Simple interface for future extensions.

Prerequisites

Java 11 or later

Maven 3.x or Gradle

Spring Boot 2.x

SMTP server (e.g., Gmail, SendGrid, etc.)

An email address to send from (e.g., Gmail) and its password (stored in environment variables)

Docker (optional, if you want to run with Docker)

Setup and Installation
1. Clone the Repository

Start by cloning the repository to your local machine.

git clone https://github.com/yourusername/email-sender-app.git
cd email-sender-app

2. Install Dependencies

Make sure you have Maven installed. If not, you can install it by following the Maven Installation Guide
.

To install dependencies, run:

mvn clean install


This will download the necessary dependencies required for the project.

3. Configure Environment Variables

Create the required environment variables for SMTP credentials.

MAIL_USERNAME: Your email address (e.g., your-email@gmail.com).

MAIL_PASSWORD: Your email password or application-specific password (for Gmail, you need to create an App Password
).

SMTP_HOST: The SMTP server (e.g., for Gmail, use smtp.gmail.com).

SMTP_PORT: The SMTP port (e.g., for Gmail, use 587 for TLS).

On a UNIX-based system, you can set them like this:

export MAIL_USERNAME="your-email@gmail.com"
export MAIL_PASSWORD="your-password"
export SMTP_HOST="smtp.gmail.com"
export SMTP_PORT="587"


For Windows users, you can use the set command in your terminal or set them permanently in your system environment variables.

4. Application Configuration (Optional)

If you want to change default configurations such as SMTP settings or email templates, you can do so in the src/main/resources/application.properties file. Example:

spring.mail.host=${SMTP_HOST}
spring.mail.port=${SMTP_PORT}
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true


Make sure these settings match the environmental variables you defined earlier.

Running the Application

To run the application, use the following command:

mvn spring-boot:run


This will start the application, and it will be ready to accept email requests.

Alternatively, if you prefer a JAR file to run, you can package the application with:

mvn clean package


Then, you can run the JAR file:

java -jar target/email-sender-app-0.0.1-SNAPSHOT.jar

Testing the Application

Once the application is running, you can test the email-sending functionality by making a POST request to the following endpoint:

POST /send-email

Request Body
{
  "to": "recipient-email@example.com",
  "subject": "Test Email",
  "body": "This is a test email sent from the Spring Boot application."
}


You can use Postman or cURL to send a POST request to http://localhost:8080/send-email with the above JSON payload.

Example cURL Command
curl -X POST http://localhost:8080/send-email \
     -H "Content-Type: application/json" \
     -d '{"to": "recipient-email@example.com", "subject": "Test", "body": "Hello World"}'


If everything is set up correctly, you should receive an email in the specified inbox.

Contributing

Feel free to fork this repository and submit pull requests. If you find any bugs or want to add new features, feel free to open an issue and we’ll get to it.

Clone the repo to your local machine.

Create a new branch for the feature/bug fix.

Commit your changes and push them to your fork.

Submit a pull request with a description of what you’ve done.
