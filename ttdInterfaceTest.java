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
    @DisplayName("Test empty array | expected true for empty array")
    void isWellSortedZero() {
        String[] a = new String[0];

        assertEquals(true, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test arrays with only one element | expected true for array with only one element")
    void isWellSortedOne() {
        String[] a = new String[1];
        a[0] = "Test";

        assertEquals(true, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test correct order | expected true for correct order")
    void isWellSortedOrderTrue() {
        String[] a = {"A", "B", "X"};

        assertEquals(true, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test wrong order | expected false for wrong order")
    void isWellSortedOrderFalse() {
        String[] a = {"Java", "B", "C","PHP"};

        assertEquals(false, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test multiple occurances of the same String | expected false")
    void isWellSortedMultiFalse() {
        String[] a = {"Java", "B", "C","PHP", "Java", "X"};

        assertEquals(false, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test for null values | expected true when passing correct order with null element")
    void isWellSortedNullElement() {
        String[] a = {"B", null, "PHP", "Java", "X"};

        assertEquals(true, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test null array | expected true for null - array")
    void isWellSortedNull() {
        String[] a = null;

        assertEquals(true, this.cl.isWellSorted(a));
    }


    @Test
    @DisplayName("Test unexpected value | expected true for correct order with unknown element")
    void isWellSortedUnexpectedtrue() {
        String[] a = {"A", "B", "Z", "X"};

        assertEquals(true, this.cl.isWellSorted(a));
    }

    @Test
    @DisplayName("Test empty ruleset | expected true for empty ruleset")
    void isWellSortedNullSorter() {
        this.cl = new ttd(null);
        String[] a = {"A", "B", "C", "X"};

        assertEquals(true, this.cl.isWellSorted(a));
    }
}