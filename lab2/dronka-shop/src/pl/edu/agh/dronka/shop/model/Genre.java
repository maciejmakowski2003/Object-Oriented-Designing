package pl.edu.agh.dronka.shop.model;

public enum Genre {
    ROCK("Rock"), POP("Pop"), CLASSIC("Classic"), JAZZ("Jazz"), RAP("Rap"), METAL("Metal");

    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }

    Genre(String displayName) {
        this.displayName = displayName;
    }
    public static Genre getGenre(String genre) {
        return switch (genre) {
            case "Rock" -> Genre.ROCK;
            case "Pop" -> Genre.POP;
            case "Classic" -> Genre.CLASSIC;
            case "Jazz" -> Genre.JAZZ;
            case "Rap" -> Genre.RAP;
            case "Metal" -> Genre.METAL;
            default -> null;
        };
    }
}
