package qa.models;


import lombok.Getter;

@Getter
public class AddressData {

    private String country;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String addressLine2;
    private String city;
    private String postcode;
    private String phone;
    private String email;
    private String message;

    public AddressData() { }
}
