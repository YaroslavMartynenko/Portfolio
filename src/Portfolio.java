import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Portfolio implements Cloneable {

    private BigDecimal budget;
    private IsinAllocation isinAllocation;

    public Portfolio(BigDecimal budget, IsinAllocation isinAllocation) {
        this.budget = budget;
        this.isinAllocation = isinAllocation;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public IsinAllocation getIsinAllocation() {
        return isinAllocation;
    }

    public void setIsinAllocation(IsinAllocation isinAllocation) {
        this.isinAllocation = isinAllocation;
    }

    @Override
    protected Portfolio clone() {

        try {
            Portfolio clonedPortfolio = (Portfolio) super.clone();
            clonedPortfolio.isinAllocation = isinAllocation.clone();
            return clonedPortfolio;

        } catch (CloneNotSupportedException e) {
            throw new NotCloneableRuntimeException("Cloneable not implemented!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(budget, portfolio.budget) &&
                Objects.equals(isinAllocation, portfolio.isinAllocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget, isinAllocation);
    }

    public void showPortfolio() {

        for (Map.Entry<Isin, BigDecimal> entry : isinAllocation.getIsinAllocationMap().entrySet()) {
            Isin isin = entry.getKey();
            BigDecimal isinQuantity = entry.getValue().divide(new BigDecimal(100.0))
                    .multiply(budget).divide(isin.getValue());

            String isinInfo = isin.getCompany() + ", isin value: " + isin.getValue() + ", quantity: " + isinQuantity;
            System.out.println(isinInfo);
        }
        System.out.println("-------------------");
    }

    public void addNewIsinAndItsAllocationToPortfolio(Isin isin, BigDecimal allocation) {
        isinAllocation.addNewIsinAndItsAllocationtoMap(isin, allocation);
    }
}
