import java.util.Objects;

public class Portfolio implements Cloneable {

    private double budget;
    private Share share1;
    private Share share2;
    private Share share3;
    private double share1Percentage;
    private double share2Percentage;
    private double share3Percentage;


    public Portfolio(double budget, Share share1, Share share2, Share share3, double share1Percentage, double share2Percentage, double share3Percentage) {
        this.budget = budget;
        this.share1 = share1;
        this.share2 = share2;
        this.share3 = share3;
        this.share1Percentage = share1Percentage;
        this.share2Percentage = share2Percentage;
        this.share3Percentage = share3Percentage;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Share getShare1() {
        return share1;
    }

    public void setShare1(Share share1) {
        this.share1 = share1;
    }

    public Share getShare2() {
        return share2;
    }

    public void setShare2(Share share2) {
        this.share2 = share2;
    }

    public Share getShare3() {
        return share3;
    }

    public void setShare3(Share share3) {
        this.share3 = share3;
    }

    public double getShare1Percentage() {
        return share1Percentage;
    }

    public void setShare1Percentage(double share1Percentage) {
        this.share1Percentage = share1Percentage;
    }

    public double getShare2Percentage() {
        return share2Percentage;
    }

    public void setShare2Percentage(double share2Percentage) {
        this.share2Percentage = share2Percentage;
    }

    public double getShare3Percentage() {
        return share3Percentage;
    }

    public void setShare3Percentage(double share3Percentage) {
        this.share3Percentage = share3Percentage;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "budget=" + budget +
                ", share1=" + share1 +
                ", share2=" + share2 +
                ", share3=" + share3 +
                ", share1Percentage=" + share1Percentage +
                ", share2Percentage=" + share2Percentage +
                ", share3Percentage=" + share3Percentage +
                '}';
    }

    @Override
    protected Portfolio clone() {
        try {
            Portfolio newPortfolio = (Portfolio) super.clone();
            newPortfolio.share1 = share1.clone();
            newPortfolio.share2 = share2.clone();
            newPortfolio.share3 = share3.clone();
            return newPortfolio;
        } catch (CloneNotSupportedException e) {
            throw new NotCloneableRuntimeException("Clonable not implemented");
        }
    }

    public void showInfo() {
        System.out.println(share1.getCompany() + ", shares quantity: " + (int) (budget * share1Percentage / (100 * share1.getPrice())) + "\n" +
                share2.getCompany() + ", shares quantity: " + (int) (budget * share2Percentage / (100 * share2.getPrice())) + "\n" +
                share3.getCompany() + ", shares quantity: " + (int) (budget * share3Percentage / (100 * share3.getPrice())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Double.compare(portfolio.budget, budget) == 0 &&
                Double.compare(portfolio.share1Percentage, share1Percentage) == 0 &&
                Double.compare(portfolio.share2Percentage, share2Percentage) == 0 &&
                Double.compare(portfolio.share3Percentage, share3Percentage) == 0 &&
                Objects.equals(share1, portfolio.share1) &&
                Objects.equals(share2, portfolio.share2) &&
                Objects.equals(share3, portfolio.share3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget, share1, share2, share3, share1Percentage, share2Percentage, share3Percentage);
    }
}
