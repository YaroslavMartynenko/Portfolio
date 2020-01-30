import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Isin appleShare = new Isin("Apple", new BigDecimal(100.0));
        Isin ibmShare = new Isin("IBM", new BigDecimal(50.0));
        Isin microsoftShare = new Isin("Microsoft", new BigDecimal(150.0));

        Map<Isin, BigDecimal> isinAllocationMap = new HashMap<>();
        isinAllocationMap.put(appleShare, new BigDecimal(20.0));
        isinAllocationMap.put(ibmShare, new BigDecimal(20.0));
        isinAllocationMap.put(microsoftShare, new BigDecimal(60.0));

        IsinAllocation isinAllocation = new IsinAllocation();
        isinAllocation.setIsinAllocationMap(isinAllocationMap);

        Portfolio portfolio = new Portfolio(new BigDecimal(100000.0), isinAllocation);

        portfolio.showPortfolio();

        Portfolio newPortfolio = portfolio.clone();

        Isin someShare = new Isin("someCompany", new BigDecimal(200.0));
        newPortfolio.addNewIsinAndItsAllocationToPortfolio(someShare, new BigDecimal(20.0));

        newPortfolio.showPortfolio();
        portfolio.showPortfolio();







    }
}
