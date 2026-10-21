import java.io.*;
import java.util.*;

public class FruitPriceAnalyzer {
    record Price(String date, String state, String fruit, double min, double max, double modal, int records, boolean elNino) {
        public String toString() {
            return String.format("%s | %-16s | %-12s | min %6.1f | max %6.1f | modal %6.1f | %s",
                date, state, fruit, min, max, modal, elNino ? "El Nino" : "Neutral");
        }
    }

    // ---------- Sorting ----------
    static Price[] mergeSort(Price[] a, Comparator<Price> c) {
        if (a.length < 2) return a;
        int m = a.length / 2;
        Price[] l = mergeSort(Arrays.copyOfRange(a, 0, m), c), r = mergeSort(Arrays.copyOfRange(a, m, a.length), c);
        Price[] o = new Price[a.length];
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) o[k++] = c.compare(l[i], r[j]) <= 0 ? l[i++] : r[j++];
        while (i < l.length) o[k++] = l[i++];
        while (j < r.length) o[k++] = r[j++];
        return o;
    }

    static void quickSort(Price[] a, int lo, int hi, Comparator<Price> c) {
        while (lo < hi) {
            Price p = a[(lo + hi) >>> 1];
            int i = lo, j = hi;
            while (i <= j) {
                while (c.compare(a[i], p) < 0) i++;
                while (c.compare(a[j], p) > 0) j--;
                if (i <= j) { Price t = a[i]; a[i++] = a[j]; a[j--] = t; }
            }
            if (j - lo < hi - i) { quickSort(a, lo, j, c); lo = i; } else { quickSort(a, i, hi, c); hi = j; }
        }
    }

    // ---------- Searching ----------
    static int lowerBound(Price[] a, String d) {          // first index with date >= d
        int lo = 0, hi = a.length;
        while (lo < hi) { int m = (lo + hi) >>> 1; if (a[m].date().compareTo(d) < 0) lo = m + 1; else hi = m; }
        return lo;
    }
    static int upperBound(Price[] a, String d) {          // first index with date > d
        int lo = 0, hi = a.length;
        while (lo < hi) { int m = (lo + hi) >>> 1; if (a[m].date().compareTo(d) <= 0) lo = m + 1; else hi = m; }
        return lo;
    }
    static List<Price> linearSearch(Price[] a, String fruit, String state) {
        List<Price> out = new ArrayList<>();
        for (Price p : a)
            if ((fruit.isEmpty() || p.fruit().equalsIgnoreCase(fruit)) && (state.isEmpty() || p.state().equalsIgnoreCase(state))) out.add(p);
        return out;
    }

    // ---------- Analysis ----------
    static void summary(List<Price> l) {
        if (l.isEmpty()) { System.out.println("No records."); return; }
        Price lo = l.get(0), hi = l.get(0);
        double sum = 0, sn = 0, sd = 0; int nn = 0, nd = 0;
        for (Price p : l) {
            if (p.modal() < lo.modal()) lo = p;
            if (p.modal() > hi.modal()) hi = p;
            sum += p.modal();
            if (p.elNino()) { sn += p.modal(); nn++; } else { sd += p.modal(); nd++; }
        }
        System.out.printf("Records: %d | Avg modal: %.2f Rs/kg%n", l.size(), sum / l.size());
        System.out.println("Lowest : " + lo);
        System.out.println("Highest: " + hi);
        System.out.printf("El Nino avg: %s | Neutral avg: %s%n", nn > 0 ? String.format("%.2f", sn / nn) : "-", nd > 0 ? String.format("%.2f", sd / nd) : "-");
    }

    static Price[] load(String file) throws IOException {
        List<Price> l = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            for (String s; (s = br.readLine()) != null; ) {
                String[] c = s.split(",");
                l.add(new Price(c[0], c[1], c[2], Double.parseDouble(c[3]), Double.parseDouble(c[4]),
                    Double.parseDouble(c[5]), Integer.parseInt(c[6]), c[8].equals("El_Nino")));
            }
        }
        return l.toArray(new Price[0]);
    }

    static void show(List<Price> l, int n) {
        for (int i = 0; i < Math.min(n, l.size()); i++) System.out.println(l.get(i));
        if (l.size() > n) System.out.println("... " + (l.size() - n) + " more");
    }

    public static void main(String[] args) throws IOException {
        Price[] data = load(args.length > 0 ? args[0] : "fruit_prices_clean.csv");
        Comparator<Price> byDate = Comparator.comparing(Price::date), byModal = Comparator.comparingDouble(Price::modal);
        System.out.println("Loaded " + data.length + " records.");

        long t = System.nanoTime();
        Price[] sorted = mergeSort(data, byDate);                       // date-sorted copy used for binary search
        System.out.printf("Merge sort by date: %.1f ms%n", (System.nanoTime() - t) / 1e6);
        t = System.nanoTime();
        Price[] q = data.clone(); quickSort(q, 0, q.length - 1, byDate);
        System.out.printf("Quick sort by date: %.1f ms%n", (System.nanoTime() - t) / 1e6);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1) Prices on a date  2) Prices in a date range  3) Search fruit/state  4) Sort by modal price  5) Sort by date  0) Exit");
            System.out.print("Choice: ");
            String ch = sc.nextLine().trim();
            if (ch.equals("0")) break;
            switch (ch) {
                case "1" -> {
                    System.out.print("Date (yyyy-MM-dd): "); String d = sc.nextLine().trim();
                    long s = System.nanoTime(); int a = lowerBound(sorted, d), b = upperBound(sorted, d);
                    System.out.printf("Binary search: %d records in %.3f ms%n", b - a, (System.nanoTime() - s) / 1e6);
                    show(Arrays.asList(sorted).subList(a, b), 20);
                }
                case "2" -> {
                    System.out.print("From: "); String d1 = sc.nextLine().trim(); System.out.print("To: "); String d2 = sc.nextLine().trim();
                    List<Price> r = Arrays.asList(sorted).subList(lowerBound(sorted, d1), upperBound(sorted, d2));
                    summary(r);
                }
                case "3" -> {
                    System.out.print("Fruit (blank = all): "); String f = sc.nextLine().trim();
                    System.out.print("State (blank = all): "); String st = sc.nextLine().trim();
                    long s = System.nanoTime(); List<Price> r = linearSearch(sorted, f, st);
                    System.out.printf("Linear search: %d records in %.1f ms%n", r.size(), (System.nanoTime() - s) / 1e6);
                    summary(r);
                }
                case "4", "5" -> {
                    System.out.print("Fruit (blank = all): "); String f = sc.nextLine().trim();
                    Price[] sub = linearSearch(sorted, f, "").toArray(new Price[0]);
                    Price[] r = mergeSort(sub, ch.equals("4") ? byModal : byDate);
                    System.out.println("Lowest 10:"); show(Arrays.asList(r), 10);
                    System.out.println("Highest 10:"); List<Price> rl = new ArrayList<>(Arrays.asList(r)); Collections.reverse(rl); show(rl, 10);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
