package finki.advanced.lab02.challenge02;


public class Faculty {
    private final String facultyName;
    private final Student[] students;

    public Faculty(String facultyName, Student[] students) {
        this.facultyName = facultyName;
        this.students = new Student[students.length];
        System.arraycopy(students, 0, this.students, 0, students.length);
    }

    public int countStudentsFromCity(String cityName) {
        int numberOfStudents = 0;
        for (Student student: students) {
            if(student.getCity().compareTo(cityName) == 0) numberOfStudents++;
        }
        return numberOfStudents;
    }

    public Student getStudent(long index) {
        for (Student student: students) {
            if (student.getIndex() == index) {
                return student;
            }
        }
        return null;
    }

    public double getAverageNumberOfContacts() {
        int sum = 0;
        for (Student student: students) {
            sum += student.getNumberOfContacts();
        }
        return (double) sum / this.students.length;
    }

    public Student getStudentWithMostContacts(){
        int maxNumOfContacts = this.students[0].getNumberOfContacts();
        int index = 0;
        for (int i = 1;i < this.students.length;i++) {
            if (this.students[i].getNumberOfContacts() > maxNumOfContacts) {
                maxNumOfContacts = this.students[i].getNumberOfContacts();
                index = i;
            } else if (this.students[i].getNumberOfContacts() == maxNumOfContacts && this.students[i].getIndex() > this.students[index].getIndex()) {
                maxNumOfContacts = this.students[i].getNumberOfContacts();
                index = i;
            }
        }
        return this.students[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"fakultet\":\"").append(this.facultyName).append("\", ").append("\"studenti\":[");
        for (int i = 0;i < this.students.length;i++) {
            stringBuilder.append(this.students[i].toString());
            if (i < this.students.length - 1) stringBuilder.append(", ");
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
