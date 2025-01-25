package Student.example.StudentDB.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path ="/api/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
   public List<Student> getStudent()
   {
       return studentService.getStudentDetails();
   }

   // Take a request body from client and map it to Student
   @PostMapping
    public void registernewStudent(@RequestBody Student student)
   {
       studentService.addnewStudent(student);
       logger.info("New Student record Saved");
   }

   @DeleteMapping(path = "{studentId}")
   public void deleteStudent(@PathVariable ("studentId") Long studentId)
   {
       studentService.deletebyStudentId(studentId);
       logger.info("Student Id: {} Deleted Successfully", studentId);
   }

   @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable ("studentId") Long studentId,
                              @RequestParam (required = false) String name, @RequestParam(required = false) String email)
   {
        studentService.updateStudentbyId(studentId,name,email);
   }
}
