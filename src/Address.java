/**
 * Address is a class to store full address in detail.
 *
 *  @author Shu Yu
 * */
public class Address{

    /**
     * First address line
     * */
    private String address1;
    /**
     * Second address line
     * */
    private String address2;
    /**
     * Third address line
     * */
    private String address3;
    /**
     * City of the address
     * */
    private String city;
    /**
     * Postcode of the address
     * */
    private String postcode;
    /**
     * Country of the address
     * */
    private String country;

    /**
     *  Address constructor with specifying all of user information
     *  @param address1 first line of the address
     *  @param address2 second line of the address, it is optional
     *  @param address3 third line of the address, it is optional
     *  @param city     city of the address
     *  @param country  country of the address
     *  @param postcode postcode of the address
     * */
    public Address(String address1, String address2, String address3, String city, String postcode, String country){
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

    /**
     * Get address1.
     * @return Return address1
     * */
    public String getAddress1() {
        return address1;
    }

    /**
     * Method to update value of address1.
     * @param address1 New value for address1.
     * */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Get address2.
     * @return Return address2
     * */
    public String getAddress2() {
        return address2;
    }
    /**
     * Method to update value of address2.
     * @param address2 New value for address2.
     * */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Get address3.
     * @return Return address3
     * */
    public String getAddress3() {
        return address3;
    }

    /**
     * Method to update value of address3.
     * @param address3 New value for address3.
     * */
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    /**
     * Get city.
     * @return Return value of city.
     * */
    public String getCity() {
        return city;
    }

    /**
     * Method to update value of city.
     * @param city New value for city.
     * */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * Get postcode.
     * @return Return postcode.
     * */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Method used to update postcode.
     * @param postcode New value for postcode.
     * */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Method to get value of country
     * @return Return country.
     * */
    public String getCountry() {
        return country;
    }

    /**
     * Method to update country.
     * @param country New country value.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get full address.
     * @return Return full address in string type.
     * */
    public String toString(){
        return address1+" "+address2+" "+address3+ " "+postcode+ " "+city + " " + country;
    }
}
