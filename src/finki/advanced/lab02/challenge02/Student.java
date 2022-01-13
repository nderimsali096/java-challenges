package finki.advanced.lab02.challenge02;

import java.text.ParseException;
import java.util.*;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String city;
    private final int age;
    private final long index;
    private Contact[] contacts;
    private int numberOfEmailContacts;
    private int numberOfPhoneContacts;

    public Student(String firstName, String lastName, String city, int age, long index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.index = index;
        this.contacts = new Contact[0];
        this.numberOfEmailContacts = 0;
        this.numberOfPhoneContacts = 0;
    }

    public void addEmailContact(String date, String email) {
        Contact[] helpContacts = new Contact[this.contacts.length + 1];
        System.arraycopy(this.contacts, 0, helpContacts, 0, this.contacts.length);
        helpContacts[this.contacts.length] = new EmailContact(date, email);
        this.contacts = helpContacts;
        this.numberOfEmailContacts++;
    }

    public void addPhoneContact(String date, String phone) {
        Contact[] helpContacts = new Contact[this.contacts.length + 1];
        System.arraycopy(this.contacts, 0, helpContacts, 0, this.contacts.length);
        helpContacts[this.contacts.length] = new PhoneContact(date, phone);
        this.contacts = helpContacts;
        this.numberOfPhoneContacts++;
    }

    public Contact[] getEmailContacts() {
        Contact[] emailContacts = new Contact[this.numberOfEmailContacts];
        int index = 0;
        for (Contact contact : this.contacts) {
            if (contact.getType().compareTo("Email") == 0) {
                emailContacts[index++] = contact;
            }
        }
        return emailContacts;
    }

    public Contact[] getPhoneContacts() {
        Contact[] phoneContacts = new Contact[this.numberOfPhoneContacts];
        int index = 0;
        for (Contact contact : this.contacts) {
            if (contact.getType().compareTo("Phone") == 0) {
                phoneContacts[index++] = contact;
            }
        }
        return phoneContacts;
    }

    public int getNumberOfContacts() {
        return this.contacts.length;
    }

    public String getCity() {
        return city;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public int getAge() {
        return age;
    }

    public long getIndex() {
        return index;
    }

    public Contact getLatestContact() throws ParseException {
        Contact latestContact = this.contacts[0];
        for (int i = 1;i < this.contacts.length;i++) {
            if (this.contacts[i].isNewerThan(latestContact)) {
                latestContact = this.contacts[i];
            }
        }
        return latestContact;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Contact[] phoneContacts = this.getPhoneContacts();
        Contact[] emailContacts = this.getEmailContacts();
        stringBuilder
                .append("{\"ime\":\"").append(this.firstName).append("\", ")
                .append("\"prezime\":\"").append(this.lastName).append("\", ")
                .append("\"vozrast\":").append(this.age).append(", ")
                .append("\"grad\":\"").append(this.city).append("\", ")
                .append("\"indeks\":").append(this.index).append(", ")
                .append("\"telefonskiKontakti\":[");
        for(int i = 0;i < phoneContacts.length;i++) {
            PhoneContact phoneContact = (PhoneContact) phoneContacts[i];
            stringBuilder.append("\"").append(phoneContact.getPhone()).append("\"");
            if (i < phoneContacts.length - 1) stringBuilder.append(", ");
        }
        stringBuilder.append("], \"emailKontakti\":[");
        for(int i = 0;i < emailContacts.length;i++) {
            EmailContact emailContact = (EmailContact) emailContacts[i];
            stringBuilder.append("\"").append(emailContact.getEmail()).append("\"");
            if (i < emailContacts.length - 1) stringBuilder.append(", ");
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }


    @Override
    public int compareTo(Student o) {
        return (int) (this.getIndex() - o.getIndex());
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("nderim","sali","Tetovo",22,186096);
        students[1] = new Student("nejla","sali","Tetovo",18,186093);
        students[2] = new Student("shpresa","sali","Tetovo",29,186092);
        List<Student> studentList = Arrays.asList(students);
        StudentAgeComparator studentAgeComparator = new StudentAgeComparator();
        System.out.println(studentList);
        studentList.sort(studentAgeComparator);
        System.out.println(studentList);
        Collections.sort(studentList);
        System.out.println(studentList);
        Comparator<Student> byAge = (Student student1, Student student2) -> Integer.compare(student1.getAge(), student2.getAge());
    }

}

class StudentAgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        return Integer.compare(firstStudent.getAge(), secondStudent.getAge());
    }

}
