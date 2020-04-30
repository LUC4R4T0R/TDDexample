import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ttdInterfaceTest {

    ttd cl;

    @BeforeEach
    void createObject(){
        String[][] sorter = {{"A", "X"}, {"B", "C"}, {"Z", "Q"}, {"PHP", "Java"}};
        this.cl = new ttd(sorter);
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

    @Test
    @DisplayName("Test correct order")
    void isWellSortedOrderTrue() {
        String[] a = {"A", "B", "X"};

        assertEquals(true, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test wrong order")
    void isWellSortedOrderFalse() {
        String[] a = {"Java", "B", "C","PHP"};

        assertEquals(false, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test multiple occurances of the same String")
    void isWellSortedMultiFalse() {
        String[] a = {"Java", "B", "C","PHP", "Java", "X"};

        assertEquals(false, this.cl.isWellSorted(a));
    }
}