package pt.iade.unimanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.iade.unimanager.models.StudentRepository;
import pt.iade.unimanager.models.TeacherRepository;

@SpringBootApplication
public class UnimanagerApplication {

	public static void main(String[] args) {
		StudentRepository.populate();
		TeacherRepository.populate();
	SpringApplication.run(UnimanagerApplication.class, args);
	}

}
