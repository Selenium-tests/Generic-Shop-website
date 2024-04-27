package qa.models;


import lombok.Getter;

@Getter
public class NewsletterData {

    private String username;
    private String email;
    private String message;

    public NewsletterData() { }
}
