/*public class SettingManager {

    public static void displaySettings(UserSettings userSettings){
        System.out.println("==Settings==");
        System.out.println(userSettings.toString());
        System.out.println("============");
    }

    public static void onboarding(UserSettings details){
        System.out.println("Welcome, " + details.getAccount().getUsername() + "Let´s complete your profile");

        if(details.getBusinessName().equals("not provided yet")){
            details.setBusinessName(TextUI.promptText("Enter your Business name: "));
        }
        if(details.getContactPerson().equals("not provided yet")){
            details.setContactPerson(TextUI.promptText("Enter your Contact Person: "));
        }
        if(details.getEmail().equals("not provided yet")){
            details.setEmail(TextUI.promptText("Enter your Email: "));
        }
        if(details.getAddress().equals("not provided yet")){
            details.setAddress(TextUI.promptText("Enter your Address name: "));
        }
        if(details.getPostalCode() ==0){
            details.setPostalCode(TextUI.promptNumeric("Enter your postal code: "));
        }
        if(details.getCity().equals("not provided yet")){
            details.setCity(TextUI.promptText("Enter your City: "));
        }
        if(details.getCountry().equals("not provided yet")){
            details.setCountry(TextUI.promptText("Enter your Country: "));
        }
        if(details.getCVRnr() ==0){
            details.setCVRnr(TextUI.promptNumeric("Enter your CVR Number: "));
        }
        System.out.println("The profile setup is complete");
    }

} */

