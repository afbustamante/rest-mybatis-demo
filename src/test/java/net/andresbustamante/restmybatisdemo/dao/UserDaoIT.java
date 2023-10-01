package net.andresbustamante.restmybatisdemo.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import net.andresbustamante.restmybatisdemo.beans.User;
import net.andresbustamante.restmybatisdemo.enums.GenderEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.springtestdbunit.annotation.DatabaseOperation.DELETE_ALL;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for {@link UserDao}.
 */
@DatabaseSetup(value = "classpath:datasets/usersDataset.xml")
@DatabaseTearDown(value = "classpath:datasets/usersDataset.xml", type = DELETE_ALL)
class UserDaoIT extends AbstractDAOIntegrationTest {

    @Autowired
    private UserDao userDAO;

    @Test
    void findUserById() {
        User user1 = userDAO.findUserById(10L);
        User user2 = userDAO.findUserById(20L);

        assertNotNull(user1);
        assertNotNull(user1.getId());
        assertEquals(10, user1.getId());
        assertNotNull(user1.getFirstName());
        assertEquals("Richard", user1.getFirstName());
        assertNotNull(user1.getSurname());
        assertEquals("Ashcroft", user1.getSurname());
        assertNotNull(user1.getEmail());
        assertEquals("richard.ashcroft@email.com", user1.getEmail());
        assertNotNull(user1.getGender());
        assertEquals(GenderEnum.MALE, user1.getGender());

        assertNotNull(user2);
        assertNotNull(user2.getId());
        assertEquals(20, user2.getId());
        assertNotNull(user2.getFirstName());
        assertEquals("Amy", user2.getFirstName());
        assertNotNull(user2.getSurname());
        assertEquals("Winehouse", user2.getSurname());
        assertNotNull(user2.getEmail());
        assertEquals("amy.winehouse@email.com", user2.getEmail());
        assertNotNull(user2.getGender());
        assertEquals(GenderEnum.FEMALE, user2.getGender());
    }

    @Test
    void createUser() {
        // Given
        User user = new User();
        user.setFirstName("John");
        user.setSurname("Doe");
        user.setEmail("john.doe@email.com");
        user.setGender(GenderEnum.MALE);

        // When
        int insertedLines = userDAO.createUser(user);
        User dbUser = userDAO.findUserById(user.getId());

        // Then
        assertEquals(1, insertedLines);
        assertNotNull(user.getId());
        assertNotNull(dbUser);
        assertTrue(user.getId() > 0);
    }
}