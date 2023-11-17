package qa.utils;

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

    public String getCountry() { return country; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getErrorMessage() { return errorMessage; }
}
