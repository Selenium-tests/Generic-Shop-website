package qa.enums;

public enum TycheProduct {

    ALL_BLACK_TOPS("1"),
    HIGH_HEEL_SHOES("2"),
    MOST_WANTED("3"),
    SCARFS("4"),
    ON_SALE("5"),
    FEATURED("6"),
    TRENDS("7"),
    RECENT_1("1"),
    RECENT_2("2");

    private final String name;

    TycheProduct(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

}
