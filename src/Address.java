class Address{
  String address1, address2, address3, city, postcode, country;
  
  public Address(String address1, String address2, String address3, String city, String state, String postcode, String country){
    this.address1 = address1;
    this.address2 = address2;
    this.address3 = address3;
    this.city = city;
    this.postcode = postcode;
    this.country = country;
  }
  
  public void updateAddress(String address1, String address2, String address3, String city, String state, String postcode, String country){
    this.address1 = address1;
    this.address2 = address2;
    this.address3 = address3;
    this.city = city;
    this.postcode = postcode;
    this.country = country;
  }
  
  public Address getAddress(){
    return new Address(address1, address2, address3, city, postcode, country);
  }
}
