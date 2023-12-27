package qa.records;


import lombok.Getter;

@Getter
public class AddressFormData {

    private final String country;
    private final String firstName;
    private final String lastName;
    private final String companyName;
    private final String address1;
    private final String address2;
    private final String city;
    private final String postcode;
    private final String phone;
    private final String email;
    private final String errorMessage;

    public AddressFormData(String country, String firstName, String lastName, String companyName, String address1, String address2, String city, String postcode, String phone, String email, String errorMessage) {

        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.phone = phone;
        this.email = email;
        this.errorMessage = errorMessage;
    }
}
