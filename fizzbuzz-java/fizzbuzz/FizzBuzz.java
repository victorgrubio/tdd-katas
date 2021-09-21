
public class FizzBuzz {

    public static String fizzbuzz(int number) {
        String result = "";
        if (number % 3 == 0) {
            result = "Fizz";
        }
        if (number % 5 == 0) {
            result += "Buzz";
        }
        if (result.equals("")) {
            result = Integer.toString(number);
        }
        
        return result;
    }
}
