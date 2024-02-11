package qa.data;


import lombok.Getter;

@Getter
public class Credentials {

    private final String emailOrUsername;
    private final String password;
    private final String message;

    public Credentials(String emailOrUsername, String password, String message) {

        this.emailOrUsername = emailOrUsername;
        this.password = password;
        this.message = message;
    }
}
