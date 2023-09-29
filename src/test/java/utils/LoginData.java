package utils;

public class LoginData {

    private final String username;
    private final String password;

    public LoginData() {

        this.username = null;
        this.password = null;
    }

    public LoginData(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }
}
