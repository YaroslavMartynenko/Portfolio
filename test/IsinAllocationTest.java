import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class IsinAllocationTest {

    @BeforeClass
    public static void setup() {

    IsinAllocation isinAllocation = new IsinAllocation();
    Map<Isin, BigDecimal> isinAllocationMap = isinAllocation.getIsinAllocationMap();

    isinAllocationMap.put(new Isin("Apple", new BigDecimal(100.0)), new BigDecimal("20.0"));
    isinAllocationMap.put(new Isin("IBM", new BigDecimal(50.0)), new BigDecimal("30.0"));
    isinAllocationMap.put(new Isin("Microsoft", new BigDecimal(150.0)), new BigDecimal("50.0"));
    }


    @Test
    public void addNewIsinAndItsAllocationShouldReturnTrueIfNewIsinAndItsAllocationAdded() {


        Isin original = new Isin("Apple", new BigDecimal(100.0));
        BigDecimal allocation = new BigDecimal(20.0);




    }

    @Test
    public void cloneShouldReturnTrueIfIsinAllocationCloned() {



    }
}