public class UserSettings {

    private User user; // UserSetting "has-a" relationship
    private static String businessName = "not provided yet";
    private static String contactPerson = "not provided yet";
    private static String email = "not provided yet";
    private static String address = "not provided yet";
    private static int postalCode = 0;
    private static String city = "not provided yet";
    private static String country = "not provided yet";
    private static int CVRnr = 0;

    public UserSettings(User user) {
        this.user = user;
    }

    public static String getBusinessName(){
        return businessName;
    }

    public User getAccount() {
        return user;
    }

    public void setBusinessName(String business){
        this.businessName = business;
    }

    public static String getContactPerson(){
        return contactPerson;
    }

    public void setContactPerson(String contactPerson){
        this.contactPerson = contactPerson;
    }

    public static String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public static String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public static int getPostalCode(){
        return postalCode;
    }

    public void setPostalCode(int postalCode){
        this.postalCode = postalCode;
    }

    public static String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public static String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public static int getCVRnr(){
        return CVRnr;
    }

    public void setCVRnr(int CVRnr){
        this.CVRnr = CVRnr;
    }

    public String toString(){
        //Provides a readable string/int
        return String.format(" Username: %s\n Business:%s\n Contact Person: %s\n Email: %s\n Address: %s\n Postal Code: %d\n City: %s\n Country: %s\n CVR Number: %d");
    }
}
