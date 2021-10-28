package testtest;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTestTest {

    @Test
    public void givenNameBobShouldReturnHelloBob() {
        String answer = TestTest.greet("Bob");
        assertEquals("Hello, Bob", answer);
    }
}
