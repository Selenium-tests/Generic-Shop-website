package qa.data;


import lombok.Getter;

@Getter
public class Newsletter {

    private final String username;
    private final String email;
    private final String message;
    private final String alertMessage;

    public Newsletter(String username, String email, String message, String alertMessage) {

        this.username = username;
        this.email = email;
        this.message = message;
        this.alertMessage = alertMessage;
    }
}
