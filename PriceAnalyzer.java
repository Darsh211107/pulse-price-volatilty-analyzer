import java.util.*;

class PriceAnalyzer {
    public static double calculateAverage(ArrayList<FruitRecord> records,
                                          String commodity) {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < records.size(); i++) {
            FruitRecord record = records.get(i);
            if (record.commodity.equalsIgnoreCase(commodity)) {
                sum = sum + record.modalPrice;
                count++;
            }
        }

        if (count == 0) return 0;
        return sum / count;
    }

    public static int analyzePrices(ArrayList<FruitRecord> records,
                                    String commodity) {
        double average = calculateAverage(records, commodity);
        int abnormalCount = 0;

        if (average == 0) {
            System.out.println("Fruit not found.");
            return 0;
        }

        for (int i = 0; i < records.size(); i++) {
            FruitRecord record = records.get(i);

            if (record.commodity.equalsIgnoreCase(commodity)) {
                record.deviation = Math.abs(record.modalPrice - average)
                                   / average * 100;

                if (record.deviation <= 20) {
                    record.status = "NORMAL";
                } else if (record.deviation <= 40) {
                    record.status = "MODERATE";
                } else {
                    record.status = "ABNORMAL";
                    abnormalCount++;
                }
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("Fruit: " + commodity);
        System.out.printf("Average Modal Price: %.2f%n", average);
        System.out.println("Abnormal Records: " + abnormalCount);
        System.out.println("--------------------------------------");

        return abnormalCount;
    }

    public static void displayAbnormal(ArrayList<FruitRecord> records,
                                       String commodity) {
        System.out.println("\nABNORMAL PRICE RECORDS");
        System.out.println("--------------------------------------");

        boolean found = false;
        for (int i = 0; i < records.size(); i++) {
            FruitRecord record = records.get(i);

            if (record.commodity.equalsIgnoreCase(commodity)
                    && record.status.equals("ABNORMAL")) {
                found = true;
                System.out.println("Market: " + record.market);
                System.out.println("Modal Price: ₹" + record.modalPrice);
                System.out.printf("Deviation: %.2f%%%n", record.deviation);
                System.out.println("Status: " + record.status);
                System.out.println("--------------------------------------");
            }
        }

        if (!found) {
            System.out.println("No abnormal records found.");
        }
    }
}
