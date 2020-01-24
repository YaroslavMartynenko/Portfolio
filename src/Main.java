import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Share share1 = new Share("Apple", 100.0);
        Share share2 = new Share("IBM", 60.0);
        Share share3 = new Share("Microsoft", 80.0);

        Portfolio portfolio = new Portfolio(100000, share1, share2, share3, 20, 60, 20);

        portfolio.showInfo();

        System.out.println("-----------------------");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input new shares percentage:");
        double newShare1Percentage = scanner.nextDouble();
        double newShare2Percentage = scanner.nextDouble();
        double newShare3Percentage = scanner.nextDouble();

        Portfolio newPortfolio = newPortfolio = portfolio.clone();

        newPortfolio.setShare1Percentage(newShare1Percentage);
        newPortfolio.setShare2Percentage(newShare2Percentage);
        newPortfolio.setShare3Percentage(newShare3Percentage);

        newPortfolio.showInfo();


        System.out.println("-----------------------");
        portfolio.showInfo();

    }
}
