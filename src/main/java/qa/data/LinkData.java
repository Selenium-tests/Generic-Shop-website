package qa.data;


import lombok.Getter;

@Getter
public class LinkData {

    private final String link;
    private final String url;

    public LinkData(String link, String url) {

        this.link = link;
        this.url = url;
    }
}
