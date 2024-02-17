package qa.models;


import lombok.Getter;

@Getter
public class AddressData {

    private final String country;
    private final String firstName;
    private final String lastName;
    private final String companyName;
    private final String address;
    private final String addressLine2;
    private final String city;
    private final String postcode;
    private final String phone;
    private final String email;
    private final String errorMessage;

    public AddressData(String country, String firstName, String lastName, String companyName, String address, String addressLine2, String city, String postcode, String phone, String email, String errorMessage) {

        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postcode = postcode;
        this.phone = phone;
        this.email = email;
        this.errorMessage = errorMessage;
    }
}
