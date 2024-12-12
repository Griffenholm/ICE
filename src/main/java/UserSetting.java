public class UserSetting {

    private User user; // UserSetting "has-a" relationship
    private String businessName = "not provided yet";
    private String contactPerson = "not provided yet";
    private String email = "not provided yet";
    private String address = "not provided yet";
    private int postalCode = 0;
    private String city = "not provided yet";
    private String country = "not provided yet";
    private int CVRnr = 0;

    public UserSetting(User user) {
        this.user = user;
    }

    public String getBusinessName(){
        return businessName;
    }

    public void setBusinessName(String business){
        this.businessName = business;
    }

    public String getContactPerson(){
        return contactPerson;
    }

    public void setContactPerson(String contactPerson){
        this.contactPerson = contactPerson;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getPostalCode(){
        return postalCode;
    }

    public void setPostalCode(int postalCode){
        this.postalCode = postalCode;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public int getCVRnr(){
        return CVRnr;
    }

    public void setCVRnr(int CVRnr){
        this.CVRnr = CVRnr;
    }

    @Override
    public String toString(){
        //
        return String.format(" Username: %s\n Business:%s\n Contact Person: %s\n Email: %s\n Address: %s\n Postal Code: %d\n City: %s\n Country: %s\n CVR Number: %d")
    }
}
