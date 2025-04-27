# Software-Automation-and-JUnit-Test 

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

I ensure my code is functional by writing thorough unit tests that cover both positive and negative scenarios. For each service I created (Contact, Task, and Appointment), I validated user inputs against strict requirements and tested edge cases, such as maximum character lengths and null values. To improve security, I validate all inputs carefully to prevent unexpected behavior and consistently throw specific exceptions for invalid data. I also avoid exposing internal data structures directly, following good encapsulation practices.

### How do I interpret user needs and incorporate them into a program?

I interpret user needs by closely analyzing the requirements and translating them into clear, testable features. Each requirement — for example, "contact IDs must be no longer than 10 characters" — directly guided how I built constructors, methods, and validation logic. I created unit tests that specifically validated these user requirements, ensuring that if a user input did not match the expectations, the program responded appropriately. In this way, the user needs were always at the center of both design and testing.

### How do I approach designing software?

I approach software design by first understanding all project requirements, then planning how each class and method will meet those needs. I focus on modularity and separation of concerns, ensuring that each class has a clear and single responsibility. For this project, the data classes (such as `Contact`) handled validation and storage of data, while service classes (such as `ContactService`) managed collections and operations like add, delete, and update. I also prioritize writing unit tests early in the development process to guide my design decisions and ensure reliability from the start.

