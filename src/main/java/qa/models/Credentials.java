package qa.models;


import lombok.Getter;

@Getter
public class Credentials {

    private String emailOrUsername;
    private String password;
    private String message;

    public Credentials() { }
}
