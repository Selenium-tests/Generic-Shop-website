package qa.records;


import lombok.Getter;

@Getter
public class Link {

    private final String linkText;
    private final String pageURL;

    public Link(String linkText, String pageURL) {

        this.linkText = linkText;
        this.pageURL = pageURL;
    }
}
