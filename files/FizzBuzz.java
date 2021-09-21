
public class FizzBuzz {

    public static String fizzbuzz(int number) {
        String result = "";
        if (number % 3 == 0) {
            result = "Fizz";
        }
        if (number % 5 == 0) {
            result = "Buzz";
        }
        else result = Integer.toString(number);
        
        return result;
    }
}
