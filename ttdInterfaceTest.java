import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ttdInterfaceTest {

    @BeforeEach
    void createObject(){
        ttd cl = new ttd();
    }

    @Test
    @DisplayName("Test empty array")
    void isWellSorted() {
        String[] a = new String[0];

        assertEquals(true, cl.isWellSorted(a));
    }
}