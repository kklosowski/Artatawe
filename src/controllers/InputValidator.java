package controllers;

public class InputValidator {
    private static final String ALNUM_PATTERN = "^[a-zA-Z0-9]*$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String TEXT_PATTERN = "^[a-zA-Z0-9.,;?!]*$";
    private static final int ARTWORK_TITLE_MAX_LENGTH = 20;
    private static final int ARTWORK_DESCRIPTION_MAX_LENGTH = 225;
    private static final int USERNAME_MAX_LENGTH = 20;

    public static boolean validAlnum(String s){
        return s.matches(ALNUM_PATTERN);
    }

    public static boolean validEmail(String s){
        return s.matches(EMAIL_PATTERN);
    }

    public static boolean validNumber(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean validText(String s){
        return s.matches(TEXT_PATTERN);
    }

    public static boolean validUsername(String s){
        if(validAlnum(s) && s.length() <= USERNAME_MAX_LENGTH){
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
        String a = "aaaaaaaaaaaaaaaaaaaaaaaa...aa?!;aaaaaaaaaaaaaaaaaaaa";
        System.out.println(validArtworkDescription(a));
    }
}
