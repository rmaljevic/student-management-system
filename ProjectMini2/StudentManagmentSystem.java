package ProjectMini2;

import java.util.Scanner;

public class StudentManagmentSystem {
    private static final int MAX_STUDENTS = 100;
    private static final int MAX_GRADES = 20;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Izaberite opciju: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showAllStudents();
                    break;
                case 3:
                    findStudentByIndex();
                    break;
                case 4:
                    addGrade();
                    break;
                case 5:
                    showAverage();
                    break;
                case 0:
                    running = false;
                    System.out.println("Program je završen.");
                    break;
                default:
                    System.out.println("Nepoznata opcija.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT =====");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Prikaži sve studente");
        System.out.println("3. Pretraži po broju indeksa");
        System.out.println("4. Dodaj ocenu");
        System.out.println("5. Prikaži prosek studenta");
        System.out.println("0. Izlaz");
    }

    private static void addStudent() {
        if (studentCount == MAX_STUDENTS) {
            System.out.println("Dostignut je maksimalan broj studenata.");
            return;
        }

        String indexNumber = readIndexNumber();
        if (findStudent(indexNumber) != null) {
            System.out.println("Student sa tim brojem indeksa već postoji.");
            return;
        }

        String name = readRequiredText("Unesite ime i prezime: ");
        String studyProgram = readRequiredText("Unesite studijski program: ");
        students[studentCount++] = new Student(indexNumber, name, studyProgram, MAX_GRADES);
        System.out.println("Student je uspešno dodat.");
    }

    private static void showAllStudents() {
        if (studentCount == 0) {
            System.out.println("Nema dodatih studenata.");
            return;
        }

        System.out.println("\n--- Svi studenti ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    private static void findStudentByIndex() {
        String indexNumber = readIndexNumber();
        Student student = findStudent(indexNumber);

        if (student == null) {
            System.out.println("Student sa tim brojem indeksa ne postoji.");
        } else {
            System.out.println(student);
            System.out.println("Prosek: " + formatAverage(student.calculateAverage()));
        }
    }

    private static void addGrade() {
        String indexNumber = readIndexNumber();
        Student student = findStudent(indexNumber);

        if (student == null) {
            System.out.println("Student sa tim brojem indeksa ne postoji.");
            return;
        }

        if (student.getGradeCount() == MAX_GRADES) {
            System.out.println("Student već ima maksimalan broj ocena.");
            return;
        }

        int grade = readGrade();
        student.addGrade(grade);
        System.out.println("Ocena je uspešno dodata.");
    }

    private static void showAverage() {
        String indexNumber = readIndexNumber();
        Student student = findStudent(indexNumber);

        if (student == null) {
            System.out.println("Student sa tim brojem indeksa ne postoji.");
            return;
        }

        if (student.getGradeCount() == 0) {
            System.out.println("Student još nema ocena.");
        } else {
            System.out.println("Prosek studenta " + student.getName() + " je "
                    + formatAverage(student.calculateAverage()));
        }
    }

    private static Student findStudent(String indexNumber) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getIndexNumber().equalsIgnoreCase(indexNumber)) {
                return students[i];
            }
        }
        return null;
    }

    private static String formatAverage(double average) {
        return String.format("%.2f", average);
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Unesite ceo broj.");
            }
        }
    }

    private static String readRequiredText(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Polje ne sme biti prazno.");
        }
    }

    private static String readIndexNumber() {
        while (true) {
            String indexNumber = readRequiredText("Unesite broj indeksa (npr. 25/000): ");
            if (indexNumber.matches("\\d{2}/\\d{3}")) {
                return indexNumber;
            }
            System.out.println("Broj indeksa mora biti u formatu dve cifre/kosa crta/tri cifre (npr. 25/000).");
        }
    }

    private static int readGrade() {
        while (true) {
            int grade = readInt("Unesite ocenu (5-10): ");
            if (grade >= 5 && grade <= 10) {
                return grade;
            }
            System.out.println("Ocena mora biti između 5 i 10. Pokušajte ponovo.");
        }
    }
}
