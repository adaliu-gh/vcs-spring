package cn.edu.fudan.ada.vcspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.edu.fudan.ada.vcspring.models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

	@Bean
	public CommandLineRunner demo(IdentityRepository id, StudentRepository sRepo, CourseRepository cRepo, InstructorRepository iRepo,RegisterRepository rRepo) {
		return (args) -> {

        id.save(new Identity("0001","0001","student"));
        id.save(new Identity("0002","0002","student"));
        id.save(new Identity("0003","0003","student"));
        id.save(new Identity("0004","0004","student"));
        id.save(new Identity("0005","0005","student"));
        id.save(new Identity("1001","1001","instructor"));
        id.save(new Identity("1002","1002","instructor"));
        id.save(new Identity("1003","1003","instructor"));
      // save a couple of registers
      rRepo.save(new Register("0001", "English","0001","Individual","1001","Alice"));
      rRepo.save(new Register("0002", "Math","0002","O'Brian","1003","Cat"));
      rRepo.save(new Register("0003", "Computer","0003","Palmer","1001","Alice"));

        // fetch all registers
      log.info("Registers found with findAll():");
      log.info("-------------------------------");
      for (Register register : rRepo.findAll()) {
          log.info(register.toString());
      }
      log.info("");

        // fetch registers by course-id
      log.info("Register found with findByCId('0002'):");
      log.info("--------------------------------------------");
      for (Register individual : rRepo.findByCId("0002")) {
          log.info(individual.toString());
      }
      log.info("");

      // fetch registers by student-id
      log.info("Register found with findBySId('0002'):");
      log.info("--------------------------------------------");
      for (Register individual : rRepo.findBySId("0002")) {
          log.info(individual.toString());
      }
      log.info("");

      // fetch register by instructor-id
      log.info("Register found with findByIId('1002'):");
      log.info("--------------------------------------------");
      for (Register individual : rRepo.findByIId("1002")) {
          log.info(individual.toString());
      }
      log.info("");

      // save a couple of instructors
      iRepo.save(new Instructor("1001", "Alice"));
      iRepo.save(new Instructor("1002", "Bob"));
      iRepo.save(new Instructor("1003", "Cat"));

        // fetch all instructors
      log.info("Instructors found with findAll():");
      log.info("-------------------------------");
      for (Instructor instructor : iRepo.findAll()) {
          log.info(instructor.toString());
      }
      log.info("");
        // fetch an individual instructor by ID
      Instructor instructor = iRepo.findById("1002");
      log.info("Instructor found with findById(\"1002\"):");
      log.info("--------------------------------");
      log.info(instructor.toString());
      log.info("");
        // fetch instructors by name
      log.info("Instructor found with findByName('Cat'):");
      log.info("--------------------------------------------");
      for (Instructor individual : iRepo.findByName("Cat")) {
          log.info(individual.toString());
      }
      log.info("");

      // save a couple of students
      sRepo.save(new Student("0001", "Individual"));
      sRepo.save(new Student("0005", "O'Brian"));
			sRepo.save(new Student("0002", "Individual"));
			sRepo.save(new Student("0003", "Palmer"));
			sRepo.save(new Student("0004", "Dessler"));

			// fetch all students
			log.info("Students found with findAll():");
			log.info("-------------------------------");
			for (Student student : sRepo.findAll()) {
				log.info(student.toString());
			}
      log.info("");

			// fetch an individual student by ID
			Student student = sRepo.findById("0005");
			log.info("Student found with findById(\"0005\"):");
			log.info("--------------------------------");
			log.info(student.toString());
      log.info("");

			// fetch students by name
			log.info("Student found with findByName('Individual'):");
			log.info("--------------------------------------------");
			for (Student individual : sRepo.findByName("Individual")) {
				log.info(individual.toString());
			}
      log.info("");

      // save a couple of courses
      cRepo.save(new Course("0001", "English","1001","Alice"));
      cRepo.save(new Course("0005", "Chinese","1002","Bob"));
      cRepo.save(new Course("0002", "Math","1003","Cat"));
      cRepo.save(new Course("0003", "Computer","1001","Alice"));
      cRepo.save(new Course("0004", "Art","1002","Bob"));

      // fetch all courses
      log.info("Courses found with findAll():");
      log.info("-------------------------------");
      for (Course course : cRepo.findAll()) {
          log.info(course.toString());
      }
      log.info("");

      // fetch an individual course by ID
      Course course = cRepo.findById("0002");
      log.info("Course found with findById(\"0002\"):");
      log.info("--------------------------------");
      log.info(course.toString());
      log.info("");

      // fetch courses by name
      log.info("Course found with findByName('Math'):");
      log.info("--------------------------------------------");
      for (Course individual : cRepo.findByName("Math")) {
          log.info(individual.toString());
      }
      log.info("");

      // fetch courses by instructor-name
      log.info("Course found with findByIName('Alice'):");
      log.info("--------------------------------------------");
      for (Course individual : cRepo.findByIName("Alice")) {
          log.info(individual.toString());
      }
      log.info("");

      // fetch courses by instructor-id
      log.info("Course found with findByIId('1002'):");
      log.info("--------------------------------------------");
      for (Course individual : cRepo.findByIId("1002")) {
          log.info(individual.toString());
      }
      log.info("");
		};

  };
}
