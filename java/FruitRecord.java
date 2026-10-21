class FruitRecord {
    String state;
    String district;
    String market;
    String commodity;
    String variety;
    String grade;

    double minPrice;
    double maxPrice;
    double modalPrice;

    double deviation;
    String status;

    FruitRecord(String state, String district, String market,
                String commodity, String variety, String grade,
                double minPrice, double maxPrice, double modalPrice) {
        this.state = state;
        this.district = district;
        this.market = market;
        this.commodity = commodity;
        this.variety = variety;
        this.grade = grade;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.modalPrice = modalPrice;
        this.deviation = 0;
        this.status = "Not Analyzed";
    }
}
