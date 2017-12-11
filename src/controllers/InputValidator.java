package controllers;

public class InputValidator {
    private static final String ALNUM_PATTERN = "^[a-zA-Z0-9]*$";
    private static final String ALPHA_PATTERN = "^[a-zA-Z]*$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String TEXT_PATTERN = "^[a-zA-Z0-9.,;?! ]*$";
    private static final String POSTCODE_PATTERN = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
    private static final String MOBILE_PATTERN = "^[0-9]*$";
    private static final int ARTWORK_TITLE_MAX_LENGTH = 20;
    private static final int ARTWORK_DESCRIPTION_MAX_LENGTH = 225;
    private static final int USERNAME_MIN_LENGTH = 3;
    private static final int USERNAME_MAX_LENGTH = 20;
    private static final int ADDRESS_MIN_LENGTH = 1;
    private static final int ADDRESS_MAX_LENGTH = 60;
    private static final int CITY_MIN_LENGTH = 1;
    private static final int CITY_MAX_LENGTH = 60;
    private static final int COUNTRY_MIN_LENGTH = 1;
    private static final int COUNTRY_MAX_LENGTH = 60;
    private static final int MOBILE_MIN_LENGTH = 8;
    private static final int MOBILE_MAX_LENGTH = 16;
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 20;

    public static boolean validAlnum(String s){
        return s.matches(ALNUM_PATTERN);
    }

    public static boolean validAlnum(String s, int minLength, int maxLength){
        if(s.matches(ALNUM_PATTERN) && s.length() >= minLength && s.length() <= maxLength){
            return true;
        }
        return false;
    }

    public static boolean validAlpha(String s){
        return s.matches(ALPHA_PATTERN);
    }

    public static boolean validAlpha(String s, int minLength, int maxLength){
        if(s.matches(ALPHA_PATTERN) && s.length() >= minLength && s.length() <= maxLength){
            return true;
        }
        return false;
    }

    public static boolean validEmail(String s){
        return s.matches(EMAIL_PATTERN);
    }

    public static boolean validPostcode(String postcode){
        return postcode.matches(POSTCODE_PATTERN);
    }

    public static boolean validInteger(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean validDouble(String s){
        try{
            Double.parseDouble(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean validText(String s){
        return s.matches(TEXT_PATTERN);
    }

    public static boolean validText(String s, int minLength, int maxLength){
        if(s.matches(TEXT_PATTERN) && s.length() >= minLength && s.length() <= maxLength){
            return true;
        }
        return false;
    }

    public static boolean validMobile(String s){
        if(s.matches(MOBILE_PATTERN) && s.length() >= MOBILE_MIN_LENGTH && s.length() <= MOBILE_MAX_LENGTH){
            return true;
        }
        return false;
    }

    public static boolean validAddress(String s){
        if(validText(s, ADDRESS_MIN_LENGTH, ADDRESS_MAX_LENGTH)){
            return true;
        }
        return false;
    }

    public static boolean validCity(String s){
        if(validText(s, CITY_MIN_LENGTH, CITY_MAX_LENGTH)){
            return true;
        }
        return false;
    }

    public static boolean validCountry(String s){
        if(validText(s, COUNTRY_MIN_LENGTH, COUNTRY_MAX_LENGTH)){
            return true;
        }
        return false;
    }

    public static boolean validName(String s){
        if(validText(s, NAME_MIN_LENGTH, NAME_MAX_LENGTH)){
            return true;
        }
        return false;
    }

    public static boolean validUsername(String s){
        if(validAlnum(s, USERNAME_MIN_LENGTH, USERNAME_MAX_LENGTH)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean validArtworkTitle(String s){
        if(validText(s) && s.length() <= ARTWORK_TITLE_MAX_LENGTH){
            return true;
        }else{
            return false;
        }
    }

    public static boolean validArtworkDescription(String s){
        if(validText(s) && s.length() <= ARTWORK_DESCRIPTION_MAX_LENGTH){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        String a = "";
        System.out.println(validArtworkDescription(a));
    }
}
