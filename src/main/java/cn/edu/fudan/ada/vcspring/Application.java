//package cn.edu.fudan.ada.vcspring;
//
//import cn.edu.fudan.ada.vcspring.models.*;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class Application {
//
//public static void main(String[] args) {
//SpringApplication.run(Application.class, args);
//}
//
//}
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
	public CommandLineRunner demo(IdentityDao id, StudentDao sRepo, CourseDao cRepo, InstructorDao iRepo,RegisterDao rRepo) {
		return (args) -> {


      // save a couple of instructors
      iRepo.save(new Instructor("0001", "Alice"));
      iRepo.save(new Instructor("0002", "Bob"));
      iRepo.save(new Instructor("0003", "Cat"));


      // save a couple of students
      sRepo.save(new Student("0001", "Individual"));
      sRepo.save(new Student("0005", "O'Brian"));
			sRepo.save(new Student("0002", "Individual"));
			sRepo.save(new Student("0003", "Palmer"));
			sRepo.save(new Student("0004", "Dessler"));


      // save a couple of courses
      cRepo.save(new Course("0001", "English","0001","Alice"));
      cRepo.save(new Course("0005", "Chinese","0002","Bob"));
      cRepo.save(new Course("0002", "Math","0003","Cat"));
      cRepo.save(new Course("0003", "Computer","0001","Alice"));
      cRepo.save(new Course("0004", "Art","0002","Bob"));

      //save a couple of identities
      id.save(new Identity("0001","0001","student"));
      id.save(new Identity("0002","0002","student"));
      id.save(new Identity("0003","0003","student"));
      id.save(new Identity("0004","0004","student"));
      id.save(new Identity("0005","0005","student"));

    };
  };
}
