package Student.example.StudentDB.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student Sunil = new Student("Sunil",
                    LocalDate.of(2001, Month.SEPTEMBER,6),
                    "Sunilvj006@Gmail.com" );
            //studentRepository.save(Sunil);

            Student Hema = new Student("Hema",
                    LocalDate.of(1998, Month.NOVEMBER,10),
                    "Hemalathahariram@Gmail.com");
            studentRepository.saveAll(List.of(Sunil, Hema));
            System.out.println("Success: Student Records Saved");
        };
    }

}
