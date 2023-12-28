package qa.data;


import lombok.Getter;

@Getter
public class Newsletter {

    private final String username;
    private final String email;

    public Newsletter(String username, String email) {

        this.username = username;
        this.email = email;
    }
}
