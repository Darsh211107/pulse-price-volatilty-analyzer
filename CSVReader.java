import java.io.*;
import java.util.*;

class CSVReader {
    public static ArrayList<FruitRecord> readCSV(String fileName) {
        ArrayList<FruitRecord> records = new ArrayList<FruitRecord>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (line.trim().length() == 0) continue;
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] data = line.split(",", -1);

                // The supplied dataset has 9 columns. Some Market names
                // contain commas, so join the extra fields back into Market.
                if (data.length < 9) continue;

                String state = data[0].trim();
                String district = data[1].trim();
                String market;
                String commodity;
                String variety;
                String grade;
                String minPriceText;
                String maxPriceText;
                String modalPriceText;

                if (data.length == 9) {
                    market = data[2].trim();
                    commodity = data[3].trim();
                    variety = data[4].trim();
                    grade = data[5].trim();
                    minPriceText = data[6].trim();
                    maxPriceText = data[7].trim();
                    modalPriceText = data[8].trim();
                } else {
                    market = data[2].trim();
                    for (int i = 3; i <= data.length - 7; i++) {
                        market = market + "," + data[i].trim();
                    }
                    commodity = data[data.length - 6].trim();
                    variety = data[data.length - 5].trim();
                    grade = data[data.length - 4].trim();
                    minPriceText = data[data.length - 3].trim();
                    maxPriceText = data[data.length - 2].trim();
                    modalPriceText = data[data.length - 1].trim();
                }

                try {
                    double minPrice = Double.parseDouble(minPriceText);
                    double maxPrice = Double.parseDouble(maxPriceText);
                    double modalPrice = Double.parseDouble(modalPriceText);

                    if (isSelectedFruit(commodity)) {
                        records.add(new FruitRecord(state, district, market,
                                commodity, variety, grade,
                                minPrice, maxPrice, modalPrice));
                    }
                } catch (NumberFormatException e) {
                    // Ignore invalid data rows.
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return records;
    }

    private static boolean isSelectedFruit(String commodity) {
        String[] fruits = {
            "Apple", "Banana", "Banana - Green", "Mango",
            "Mango (Raw-Ripe)", "Orange", "Grapes", "Pomegranate",
            "Lemon", "Mousambi(Sweet Lime)", "Papaya", "Papaya (Raw)",
            "Guava", "Pineapple", "Water Melon", "Musk Melon",
            "Chikoos(Sapota)"
        };

        for (int i = 0; i < fruits.length; i++) {
            if (commodity.equalsIgnoreCase(fruits[i])) {
                return true;
            }
        }
        return false;
    }
}
