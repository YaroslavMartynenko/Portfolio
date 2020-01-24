import org.junit.Test;

import static org.junit.Assert.*;

public class ShareTest {

    @Test
    public void shouldReturnTrueIfShareCloned() {

        Share share = new Share("Apple", 100.0);

        Share clonedShare = share.clone();

        assertEquals(share, clonedShare);

    }
}