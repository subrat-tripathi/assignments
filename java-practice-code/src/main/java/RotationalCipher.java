import java.util.Arrays;

class RotationalCipher {

    private int shiftKey;

    RotationalCipher(int shiftKey) {
        if(shiftKey > 25){
            shiftKey = shiftKey % 26;
        }
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        if(data == null)
            return null;
        String cipher = "";
        for(char ch : data.toCharArray()){
            if(Character.isLetter(ch)){
                if((Character.isUpperCase(ch) && (ch + shiftKey) > 90) ||
                        (Character.isLowerCase(ch) && (ch + shiftKey) > 122)){
                    cipher = cipher + (char)(ch + shiftKey - 26) ;
                }
                else{
                    cipher = cipher + (char)(ch + shiftKey) ;
                }
            }
            else{
                cipher = cipher + ch;
            }


        }
        return cipher;
    }

}
