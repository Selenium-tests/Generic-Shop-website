package qa.utils;

public class Newsletter {

    private final String username;
    private final String email;


    public Newsletter() {

        this.username = null;
        this.email = null;
    }

    public Newsletter(String username, String email) {

        this.username = username;
        this.email = email;
    }

    public String getUsername() {

        return username;
    }

    public String getEmail() {

        return email;
    }
}
