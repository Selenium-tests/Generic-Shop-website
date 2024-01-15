package qa.data;


import lombok.Getter;

@Getter
public class Credentials {

    private final String email;
    private final String password;
    private final String errorMessage;

    public Credentials(String email, String password, String errorMessage) {

        this.email = email;
        this.password = password;
        this.errorMessage = errorMessage;
    }
}
