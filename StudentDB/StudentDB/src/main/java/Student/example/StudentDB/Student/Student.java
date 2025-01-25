package Student.example.StudentDB.Student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_Sequence",
            sequenceName =  "student_Sequence",
            allocationSize= 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_Sequence"
    )

    @Column(name = "Id",nullable = false, updatable = false)
    private Long Id;

    @Column(name = "Name",nullable = false, columnDefinition = "TEXT")
    private String Name;

    @Column(name = "date_of_joining",nullable = false)
    private LocalDate DOJ;

    @Column(name = "Email",nullable = false,unique = true, columnDefinition = "TEXT")
    private String Email;

    @Transient
    private int age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate DOJ, String email) {
        Id = id;
        Name = name;
        this.DOJ = DOJ;
        Email = email;
    }

    public Student(String name, LocalDate DOJ, String email) {
        Name = name;
        this.DOJ = DOJ;
        Email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDOJ() {
        return DOJ;
    }

    public void setDOJ(LocalDate DOJ) {
        this.DOJ = DOJ;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return Period.between(this.DOJ,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", DOJ=" + DOJ +
                ", Email='" + Email + '\'' +
                ", age=" + age +
                '}';
    }
}
