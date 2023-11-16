package qa.utils;

public class Credentials {

    private final String email;
    private final String password;

    public Credentials() {

        this.email = null;
        this.password = null;
    }

    public Credentials(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }
}
