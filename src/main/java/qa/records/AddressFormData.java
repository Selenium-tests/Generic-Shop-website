package qa.records;

public record AddressFormData(String country, String firstName, String lastName, String companyName, String address1,
                              String address2, String city, String postcode, String phone, String email,
                              String errorMessage) {

}
