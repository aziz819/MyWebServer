/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import jp.co.topgate.asada.web.App;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
    @Test public void hamcrestを使ってみよう() {
        //App app = new App();
        //assertThat("Hello, world.", is(app.getGreeting()));
    }
}
