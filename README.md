<b> Library Management System </b>

<b> Project Description </b>

The Library Management System is a RESTful API built using Java and Spring Boot. This project allows users to manage a collection of books in a library by providing various functionalities, including adding new books, listing all books, searching by title or author, borrowing, and returning books. It is a simple and educational project designed for learning purposes and to get familiar with building APIs using Spring Boot.

<b>Features Implemented</b>

- Add a New Book: Users can add a new book to the library by providing information like title, author, ISBN, published year, and availability status.

- List All Books: Retrieve a list of all books currently available in the library.

- Retrieve a Book by ISBN: Fetch the details of a specific book using its unique ISBN number.

Search Books by Title or Author: Search for books using either the title or author (or both).

Borrow a Book: Borrow a book, which marks it as unavailable in the library.

Return a Book: Return a previously borrowed book, marking it as available again.

<b>How to Run the Application</b>

-Prerequisites

Java 17 installed on your system.

Maven installed (usually, it's included in IntelliJ, but you can also install it separately).

IntelliJ IDEA (or any other Java IDE).

-Steps to Run

Clone the Project: If you haven't already, clone the repository using the following command:

git clone https://github.com/mganzert/library-management

Open the Project:

Open IntelliJ IDEA.

Click Open and navigate to the folder where you cloned the project.

Build the Project:

Allow the dependencies to download. Maven should automatically download the necessary dependencies.

Go to the top menu and click Build -> Rebuild Project to ensure everything is ready.

Run the Application:

Locate the file LibraryApplication.java in the folder src/main/java/com/example/library.

Click on the green play button next to the main() method to run the application.

Access the API:

Once the application is running, you can test the endpoints using Postman or cURL.

The base URL for accessing the API is http://localhost:8080/books.

Example Endpoints

Add a New Book (POST): http://localhost:8080/books

List All Books (GET): http://localhost:8080/books

Retrieve a Book by ISBN (GET): http://localhost:8080/books/{isbn}

Search for Books (GET): http://localhost:8080/books/search?title=Harry&author=Rowling

Borrow a Book (PUT): http://localhost:8080/books/{isbn}/borrow

Return a Book (PUT): http://localhost:8080/books/{isbn}/return

Technologies Used

Java 17

Spring Boot 3.3.5

H2 In-Memory Database (for data storage during runtime)

Assumptions and Limitations

The ISBN is assumed to be unique for each book.

No persistent storage is implemented, meaning that data is lost every time the application stops.

The application uses an in-memory H2 database for simplicity and testing purposes.

Future Improvements

Implement user authentication to control who can borrow or return books.

Add persistent storage to keep the data intact even after restarting the application.

Add more advanced search options and pagination for listing books.
