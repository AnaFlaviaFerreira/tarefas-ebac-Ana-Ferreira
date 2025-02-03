import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
ProdutoDAOTest.class, ProdutoServiceTest.class})
public class AllTests {
}
