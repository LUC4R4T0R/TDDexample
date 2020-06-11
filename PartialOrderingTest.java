import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
public class PartialOrderingTest {
    @DisplayName("Test keine Bedingung | Kein Inhalt")
    @Test
    void leereOrdnung(){
        PartialOrdering p = new PartialOrdering(new String[][]{});
        Iterator s = p.iterator();
        assertFalse(s.hasNext());
    }
    @DisplayName("Test eine vorhandene Bedingung| erwartet richtige Reihenfolge der beiden Elemente")
    @Test
    void eineBedingung(){
        String[][] st = new String[][]{{"eins","zwei"}};
        PartialOrdering p = new PartialOrdering(st);
        Iterator s = p.iterator();
        assertTrue(s.hasNext());
        assertEquals(st[0][0], s.next());
        assertEquals(st[0][1], s.next());
    }
    @DisplayName("Test zwei vorhandene Bedingung aufeinanderfolgend| erwartet richtige Reihenfolge den Elemente")
    @Test
    void zweiBedingung(){
        String[][] st = new String[][]{{"eins","zwei"},{"zwei","drei"}};
        PartialOrdering p = new PartialOrdering(st);
        Iterator s = p.iterator();
        assertTrue(s.hasNext());
        assertEquals(st[0][0], s.next());
        assertTrue(s.hasNext());
        assertEquals(st[0][1], s.next());
        assertEquals(st[1][1], s.next());
    }
    @DisplayName("Test zwei vorhandene Bedingung unabhängig| erwartet richtige mögliche Reihenfolge den Elemente")
    @Test
    void zweiBedingungUnabhängig(){
        PartialOrdering p = new PartialOrdering(new String[][]{{"eins","zwei"},{"drei","vier"}});
        Iterator<String> s = p.iterator();
        assertTrue(s.hasNext());
        while (s.hasNext()){
            String temp = s.next();
            if (temp =="eins"){
                assertEquals("zwei", s.next());
            }else if(temp == "drei"){
                assertEquals("vier", s.next());
            }else{
                fail("eine Regel wurde nicht eingehalten");
            }
        }
    }
    @DisplayName("Test mehrere abhängige und unabhängige Regeln | erwarte mögliche Ordnung")
    @Test
    void mehrereBedingungen(){
        String[][] st = new String[][]{{"eins", "zwei"},
                {"eins", "drei"},
                {"zwei", "vier"},
                {"drei", "vier"}};
        PartialOrdering p = new PartialOrdering(st);
        Iterator<String> s = p.iterator();
        assertTrue(s.hasNext());
        assertEquals("eins", s.next());
        String tmp = s.next();
        boolean zweiFirst = false;
        try {
            assertEquals("zwei", tmp);
            zweiFirst = true;
        } catch (Exception e) {
            assertEquals("drei", tmp);
        }
        if(zweiFirst) {
            assertEquals("drei", s.next());
        }else{
            assertEquals("drei", s.next());
        }
        assertEquals("vier", s.next());
    }
    @DisplayName("Test mehrere abhängige und unabhängige Regeln | erwarte fehlermeldung")
    @Test
    void unerfüllbareBedingung(){
        PartialOrdering p = new PartialOrdering(new String[][]{{"eins", "zwei"}, {"zwei", "eins"}});
        Iterator<String> s = p.iterator();
        assertThrows(UnsupportedOperationException.class,()->s.hasNext());
        assertThrows(UnsupportedOperationException.class,()->s.next());
    }
}
