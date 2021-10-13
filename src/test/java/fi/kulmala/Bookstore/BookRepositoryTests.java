package fi.kulmala.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.kulmala.Bookstore.domain.Book;
import fi.kulmala.Bookstore.domain.BookRepository;
import fi.kulmala.Bookstore.domain.Category;
import fi.kulmala.Bookstore.domain.CategoryRepository;
import fi.kulmala.Bookstore.domain.User;
import fi.kulmala.Bookstore.domain.UserRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {
	
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private CategoryRepository categoryrepository;
	@Autowired
	private UserRepository userrepository;
	
	// Find Book by title attribute
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookrepository.findByTitle("Example Title");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Example Title");
	}
	
	// Create new Category
	@Test
	public void createCategory() {
		Category category = new Category("Biology");
		categoryrepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	// Delete existing Book
	@Test
	public void deleteBook() {
		List<Book> books = bookrepository.findByTitle("Example Title");
		Book book = books.get(0);
		bookrepository.delete(book);
		List<Book> newBooks = bookrepository.findByTitle("Example title");
		assertThat(newBooks).hasSize(0);

	}

}
