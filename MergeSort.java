import java.util.*;

class MergeSort {
    public static void sortByPrice(ArrayList<FruitRecord> records) {
        if (records.size() <= 1) return;
        mergeSortPrice(records, 0, records.size() - 1);
    }

    private static void mergeSortPrice(ArrayList<FruitRecord> records,
                                       int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSortPrice(records, low, mid);
        mergeSortPrice(records, mid + 1, high);
        mergePrice(records, low, mid, high);
    }

    private static void mergePrice(ArrayList<FruitRecord> records,
                                   int low, int mid, int high) {
        ArrayList<FruitRecord> temp = new ArrayList<FruitRecord>();
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (records.get(i).modalPrice <= records.get(j).modalPrice) {
                temp.add(records.get(i));
                i++;
            } else {
                temp.add(records.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(records.get(i));
            i++;
        }

        while (j <= high) {
            temp.add(records.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            records.set(low + k, temp.get(k));
        }
    }

    public static void sortByCommodity(ArrayList<FruitRecord> records) {
        if (records.size() <= 1) return;
        mergeSortCommodity(records, 0, records.size() - 1);
    }

    private static void mergeSortCommodity(ArrayList<FruitRecord> records,
                                           int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSortCommodity(records, low, mid);
        mergeSortCommodity(records, mid + 1, high);
        mergeCommodity(records, low, mid, high);
    }

    private static void mergeCommodity(ArrayList<FruitRecord> records,
                                       int low, int mid, int high) {
        ArrayList<FruitRecord> temp = new ArrayList<FruitRecord>();
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (records.get(i).commodity.compareToIgnoreCase(
                    records.get(j).commodity) <= 0) {
                temp.add(records.get(i));
                i++;
            } else {
                temp.add(records.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(records.get(i));
            i++;
        }

        while (j <= high) {
            temp.add(records.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            records.set(low + k, temp.get(k));
        }
    }

    public static void displaySortedByPrice(ArrayList<FruitRecord> records) {
        System.out.println("\nRECORDS SORTED BY MODAL PRICE");
        System.out.println("--------------------------------------");

        for (int i = 0; i < records.size(); i++) {
            FruitRecord r = records.get(i);
            System.out.println((i + 1) + ". " + r.commodity
                    + " | " + r.market
                    + " | ₹" + r.modalPrice);
        }
    }
}
