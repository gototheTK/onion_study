import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {
        //TODO Auto-generated constructor stub
    }

    public int add(String text) {

        if(isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text==null || text.isEmpty();
    }

    private String[] split(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if(m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }

        return text.split(",|:");
    }

    private int[] toInts(String[] texts) {
        int[] numbers = new int[texts.length];

        for(int i=0; i<numbers.length; i++) {
            numbers[i] = toPositive(texts[i]);
        }

        return numbers;
    }

    private int toPositive(String text) {

        int number = Integer.parseInt(text);

        if(number<0){
            throw new RuntimeException();
        }

        return number;

    }

    private int sum(int[] numbers) {
        int sum = 0;

        for(int i=0; i<numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }
    
}
