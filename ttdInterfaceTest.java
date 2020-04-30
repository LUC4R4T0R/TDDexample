import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ttdInterfaceTest {

    ttd cl;

    @BeforeEach
    void createObject(){
        this.cl = new ttd();
    }

    @Test
    @DisplayName("Test empty array")
    void isWellSortedZero() {
        String[] a = new String[0];

        assertEquals(true, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test arrays with only one element")
    void isWellSortedOne() {
        String[] a = new String[1];
        a[0] = "Test";

        assertEquals(true, this.cl.isWellSorted(a));
    }
}