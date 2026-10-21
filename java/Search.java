import java.util.*;

class Search {
    public static int linearSearch(ArrayList<FruitRecord> records,
                                   String commodity) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).commodity.equalsIgnoreCase(commodity)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(ArrayList<FruitRecord> records,
                                   String commodity) {
        int low = 0;
        int high = records.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = records.get(mid).commodity
                    .compareToIgnoreCase(commodity);

            if (result == 0) return mid;
            if (result < 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void displayAllMatches(ArrayList<FruitRecord> records,
                                         String commodity, int index) {
        if (index == -1) {
            System.out.println("Fruit not found.");
            return;
        }

        System.out.println("\nSEARCH RESULTS FOR: " + commodity);
        System.out.println("--------------------------------------");

        int count = 0;
        for (int i = 0; i < records.size(); i++) {
            FruitRecord r = records.get(i);
            if (r.commodity.equalsIgnoreCase(commodity)) {
                count++;
                System.out.println("Market: " + r.market);
                System.out.println("State: " + r.state);
                System.out.println("Modal Price: ₹" + r.modalPrice);
                System.out.println("--------------------------------------");
            }
        }
        System.out.println("Total matches: " + count);
    }
}
