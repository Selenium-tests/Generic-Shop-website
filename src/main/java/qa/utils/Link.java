package qa.utils;

public class Link {

    private final String linkText;
    private final String pageURL;


    public Link() {

        this.linkText = null;
        this.pageURL = null;
    }

    public Link(String linkText, String pageURL) {

        this.linkText = linkText;
        this.pageURL = pageURL;
    }

    public String getLinkText() {

        return linkText;
    }

    public String getPageURL() {

        return pageURL;
    }
}
