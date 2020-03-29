import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCollectionTest {

    @Test
    void addManager() throws Exception{
        EmployeeCollection mc = new EmployeeCollection();
        assertEquals(0, mc.getManagerCount());
        mc.addManager("Amadou", "yes123");

        assertEquals(1, mc.getManagerCount());
        assertThrows(LimitException.class, ()-> mc.addManager("Kris","no123"));
        assertThrows(IllegalArgumentException.class, ()-> mc.addManager("Amadou", "yes123"));
    }

    @Test
    void deleteManagerAcct() throws Exception {
        EmployeeCollection mc = new EmployeeCollection();
        mc.addManager("Amadou", "yes123");
        mc.addManager("Kris", "no123");
        assertEquals(2, mc.getManagerCount());
        mc.deleteManagerAcct("Amadou");
        assertEquals(1, mc.getManagerCount());
        assertThrows(IllegalArgumentException.class, ()-> mc.deleteManagerAcct("Amadou"));
    }
}