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
    void isWellSorted() {
        String[] a = new String[0];

        assertEquals(true, this.cl.isWellSorted(a));
    }
}