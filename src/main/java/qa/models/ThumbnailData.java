package qa.models;

import lombok.Getter;

@Getter
public class ThumbnailData {

    private final String tycheProduct;
    private final String link;

    public ThumbnailData(String tycheProduct, String link) {

        this.tycheProduct = tycheProduct;
        this.link = link;
    }
}
