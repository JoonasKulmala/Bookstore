package fi.kulmala.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.kulmala.Bookstore.web.BookController;
import fi.kulmala.Bookstore.web.UserController;
import fi.kulmala.Bookstore.web.UserDetailServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bookcontroller;
	@Autowired
	private UserController usercontroller;
	@Autowired
	private UserDetailServiceImpl userdetailserviceimpl;

	// Controller smoke tests
	@Test
	public void contextLoadsBookController() throws Exception {
		assertThat(bookcontroller).isNotNull();
	}
	
	@Test
	public void contextLoadsUserController() throws Exception {
		assertThat(usercontroller).isNotNull();
	}
	
	@Test
	public void contextLoadsUserDetailServiceImpl() throws Exception {
		assertThat(userdetailserviceimpl).isNotNull();
	}

}
