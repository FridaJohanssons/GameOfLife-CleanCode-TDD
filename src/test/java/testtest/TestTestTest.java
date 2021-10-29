package testtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTestTest {

    @Test
    public void givenNameBobShouldReturnHelloBob() {
        String answer = TestTest.greet("Bob");
        assertEquals("Hello, Bob", answer);
    }
}
