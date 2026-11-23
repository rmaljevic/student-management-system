# Student Management System

A console-based application written in Java for managing student records. It stores students with their index number and study program, records their grades, and calculates their grade average.

## Features

- **Add students**: index number, full name and study program
- **Unique index numbers**: prevents adding two students with the same index number
- **Index format validation**: index numbers must follow the `YY/NNN` format (e.g. `25/000`)
- **List all students**: shows each student with number of grades and average
- **Search by index number**: finds a student and displays their details
- **Add grades**: grades from 5 to 10 (the university grading scale), up to 20 per student
- **Grade average**: calculates and displays a student's average, rounded to two decimals
- **Input validation**: rejects empty fields, non-numeric input and out-of-range grades

## Technologies

- Java (JDK 8+)
- Object-oriented design (`Student` model class, encapsulation)
- Arrays for storing students and grades
- Regular expressions for index number validation
- `Scanner` for console input
- Developed in Visual Studio Code

## Project Structure

```
ProjectMini2/
├── Student.java                 # Student model: data, grades, average calculation
└── StudentManagmentSystem.java  # Main class: menu and user interaction
```

## How to Run

From the repository root:

```bash
javac ProjectMini2/*.java
java ProjectMini2.StudentManagmentSystem
```

## Usage

```
===== STUDENT MANAGEMENT =====
1. Dodaj studenta                 (Add student)
2. Prikaži sve studente           (Show all students)
3. Pretraži po broju indeksa      (Search by index number)
4. Dodaj ocenu                    (Add grade)
5. Prikaži prosek studenta        (Show student average)
0. Izlaz                          (Exit)
```

> The console interface is in Montenegrin/Serbian.

## Possible Improvements

- Save students to a file or database so data persists between runs
- Store grades per subject
- Edit and delete student records
