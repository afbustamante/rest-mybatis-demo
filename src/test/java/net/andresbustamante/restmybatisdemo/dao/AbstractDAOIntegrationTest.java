package net.andresbustamante.restmybatisdemo.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import net.andresbustamante.restmybatisdemo.config.MyBatisConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MyBatisConfig.class)
@PropertySource("classpath:application.properties")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
abstract class AbstractDAOIntegrationTest {
}
