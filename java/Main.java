import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "daily_price.csv";

        ArrayList<FruitRecord> records = CSVReader.readCSV(fileName);

        if (records.size() == 0) {
            System.out.println("No records loaded.");
            sc.close();
            return;
        }

        System.out.println("======================================");
        System.out.println("   FRUIT MARKET PRICE ANALYZER");
        System.out.println("======================================");
        System.out.println("Records Loaded: " + records.size());

        int choice;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Display Records");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search");
            System.out.println("4. Sort by Modal Price");
            System.out.println("5. Analyze Fruit Prices");
            System.out.println("6. Display Abnormal Prices");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayRecords(records);
                    break;

                case 2:
                    System.out.print("Enter fruit name: ");
                    String linearFruit = sc.nextLine();
                    int linearIndex = Search.linearSearch(records, linearFruit);
                    Search.displayAllMatches(records, linearFruit, linearIndex);
                    break;

                case 3:
                    System.out.print("Enter fruit name: ");
                    String binaryFruit = sc.nextLine();
                    MergeSort.sortByCommodity(records);
                    int binaryIndex = Search.binarySearch(records, binaryFruit);
                    Search.displayAllMatches(records, binaryFruit, binaryIndex);
                    break;

                case 4:
                    MergeSort.sortByPrice(records);
                    System.out.println("Records sorted successfully using Merge Sort.");
                    System.out.println("Lowest Modal Price: ₹" + records.get(0).modalPrice);
                    System.out.println("Highest Modal Price: ₹"
                            + records.get(records.size() - 1).modalPrice);
                    break;

                case 5:
                    System.out.print("Enter fruit name: ");
                    String analyzeFruit = sc.nextLine();
                    PriceAnalyzer.analyzePrices(records, analyzeFruit);
                    break;

                case 6:
                    System.out.print("Enter fruit name: ");
                    String abnormalFruit = sc.nextLine();
                    PriceAnalyzer.analyzePrices(records, abnormalFruit);
                    PriceAnalyzer.displayAbnormal(records, abnormalFruit);
                    break;

                case 7:
                    System.out.println("Thank you for using Fruit Market Price Analyzer.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }

    public static void displayRecords(ArrayList<FruitRecord> records) {
        int limit = records.size();
        System.out.println("\nDATASET RECORDS");
        System.out.println("--------------------------------------");

        for (int i = 0; i < limit; i++) {
            FruitRecord r = records.get(i);
            System.out.println((i + 1) + ". " + r.commodity
                    + " | " + r.market
                    + " | ₹" + r.modalPrice);
        }
    }
}
