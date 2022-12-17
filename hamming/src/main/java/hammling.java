import java.lang.invoke.WrongMethodTypeException;

public class hammling {
    public int distance(String first, String second) {

        if(first.length() != second.length()){
            throw new IllegalArgumentException("Different lengths");
        }

        if(first.length() == 0 & second.length() == 0){
            return 0;
        }

        if (first.length() == 1 & second.length() == 1) {
            if (first.equals(second)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        int result = 0;

        for(int i =0;i < first.length();i++){
            if(first.charAt(i) != second.charAt(i)){
                result = result + 1;
            }
        }

        return result;
    }
}
