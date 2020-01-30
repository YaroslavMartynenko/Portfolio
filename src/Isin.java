import java.math.BigDecimal;
import java.util.Objects;

public class Isin implements Cloneable {

    private String company;
    private BigDecimal value;

    public Isin(String company, BigDecimal value) {
        this.company = company;
        this.value = value;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    protected Isin clone() {
        try {
            return (Isin) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new NotCloneableRuntimeException("Cloneable not implemented!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Isin isin = (Isin) o;
        return Objects.equals(company, isin.company) &&
                Objects.equals(value, isin.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, value);
    }
}
