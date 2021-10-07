package fi.kulmala.Bookstore;

import fi.kulmala.Bookstore.domain.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner productionDemo(BookRepository repository, CategoryRepository repository2, UserRepository repository3) {
		return (args) -> {
			
			// Clear database on startup
			// repository.deleteAll();
			// repository2.deleteAll();
			// repository3.deleteAll();
			
			// Hard coded User
			// Credentials = user/user, admin/admin
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			repository3.save(user1);
			repository3.save(user2);
			
			// Hard coded Category
			repository2.save(new Category("Science"));
			repository2.save(new Category("Fiction"));
			repository2.save(new Category("History"));

			// Hard coded Book
			repository.save(new Book("Example Title", "Example Author", 2000, "Example ISBN", 20, repository2.findByName("Science").get(0)));
			repository.save(new Book("Spring Database & JPA", "Haaga-Helia", 2021,"isbn123", 0.0, repository2.findByName("Fiction").get(0)));

		};
	}

}
