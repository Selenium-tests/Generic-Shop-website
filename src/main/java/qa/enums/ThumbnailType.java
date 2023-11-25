package qa.enums;

public enum ThumbnailType {

    PRODUCT("product"),
    BLOG("blog");

    private final String name;

    ThumbnailType(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
