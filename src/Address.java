//TODO: Add comments (including the creator)

public class Address{

    /**
     * Address is a class to store full address in detail
     *
     *  @author Shu Yu
     * */

    /**
     *
     * */
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String postcode;
    private String country;

    /**
     *  Address constructor which
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    //TODO: Discuss if this is needed
    public void updateAddress(String address1, String address2, String address3, String city, String postcode, String country){
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }
    public String toString(){
        return address1+" "+address2+" "+address3+ " "+postcode+ " "+city + " " + country;
    }
}
