package Student.example.StudentDB.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentDetails()
    {
        return studentRepository.findAll();
    }

    public void addnewStudent(Student student)
    {
         Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
         if(studentByEmail.isPresent())
         {
           throw new IllegalArgumentException("Email taken already");
         }
         studentRepository.save(student);
        System.out.println(student);
    }

    public void deletebyStudentId(Long studentId) {

      Boolean exists = studentRepository.existsById(studentId);
      if(!exists){
          throw new IllegalArgumentException("Id"+ studentId +"does not exist" );
      }
      studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudentbyId(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalArgumentException("Student does not exist"));
        if(name!=null && !name.isEmpty() && !Objects.equals(student.getName(),name))
        {
            student.setName(name);
        }
        if(email!=null && !email.isEmpty() && !Objects.equals(student.getEmail(),email))
        {
            student.setEmail(email);
        }
    }

}
