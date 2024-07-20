# Rinnai Cafe

Rinnai Cafe is a GUI-based application developed in Java using PostgreSQL for managing a cafe's operations, including selling coffee, pastries, and main dishes such as salads and pasta. This application provides features like login/signup, main page, food and beverage menu page, transaction or cart page, food and beverage details page, and customer review page.

## Features
- **User Authentication:** Login and signup functionality.
- **Main Page:** Overview of the cafe’s offerings.
- **Menu Page:** Display of available food and beverages.
- **Transaction Page:** Manage cart and checkout process.
- **Details Page:** Detailed information about each item.
- **Customer Reviews:** View and add reviews for items.

## Technologies Used
- **Java:** For developing the application.
- **PostgreSQL:** For database management.
- **JavaFX/Swing:** For GUI development.
- **Docker:** For containerizing the database.
- **Google Cloud Platform:** For deploying the database.

## Installation
To run this project locally, follow these steps:
1. Clone the repository:
    ```bash
    git clone https://github.com/audreynaila/RinnaiCafe.git
    ```
2. Navigate to the project directory:
    ```bash
    cd RinnaiCafe
    ```
3. Set up the PostgreSQL database using Docker:
    ```bash
    docker run --name rinnai-cafe-db -e POSTGRES_PASSWORD=yourpassword -d postgres
    ```
4. Deploy the database on Google Cloud Platform.

## Usage
1. Compile the Java application:
    ```bash
    javac -cp .:postgresql-42.2.18.jar com/rinnaicafe/*.java
    ```
2. Run the application:
    ```bash
    java -cp .:postgresql-42.2.18.jar com.rinnaicafe.Main
    ```
