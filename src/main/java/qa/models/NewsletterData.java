package qa.models;


import lombok.Getter;

@Getter
public class NewsletterData {

    private final String username;
    private final String email;
    private final String message;

    public NewsletterData(String username, String email, String message) {

        this.username = username;
        this.email = email;
        this.message = message;
    }
}
