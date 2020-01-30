import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IsinTest {

    @Test
    public void cloneShouldReturnTrueIfIsinCloned() {

        Isin original = new Isin("Apple", new BigDecimal(100.0));
        Isin cloned = original.clone();

        assertEquals(original, cloned);
        assertTrue(original!=cloned);

    }
}