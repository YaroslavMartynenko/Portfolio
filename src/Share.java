import java.util.Objects;

public class Share implements Cloneable {

    private String company;
    private double price;

    public Share(String company, double price) {
        this.company = company;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Share{" +
                "company='" + company + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    protected Share clone() {
        try {
            return (Share) super.clone();
        } catch (CloneNotSupportedException e){
            throw new NotCloneableRuntimeException("Clonable not implemented");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Share share = (Share) o;
        return Double.compare(share.price, price) == 0 &&
                Objects.equals(company, share.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, price);
    }
}
