package ProjectMini2;

public class Student {
    private final String indexNumber;
    private final String name;
    private final String studyProgram;
    private final int[] grades;
    private int gradeCount;

    public Student(String indexNumber, String name, String studyProgram, int maxGrades) {
        this.indexNumber = indexNumber;
        this.name = name;
        this.studyProgram = studyProgram;
        this.grades = new int[maxGrades];
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getName() {
        return name;
    }

    public int getGradeCount() {
        return gradeCount;
    }

    public void addGrade(int grade) {
        grades[gradeCount++] = grade;
    }

    public double calculateAverage() {
        if (gradeCount == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return (double) sum / gradeCount;
    }

    @Override
    public String toString() {
        return "Broj indeksa: " + indexNumber
                + " | Ime: " + name
                + " | Studijski program: " + studyProgram
                + " | Broj ocena: " + gradeCount
                + " | Prosek: " + String.format("%.2f", calculateAverage());
    }
}
