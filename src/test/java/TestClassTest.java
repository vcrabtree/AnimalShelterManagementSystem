import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClassTest {

    @Test
    public void testHello(){
        assertEquals("Hello", TestClass.printHello());
    }
}
