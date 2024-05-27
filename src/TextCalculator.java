import java.util.regex.Pattern;

public class TextCalculator {
 
    int add(String text) {

        String delimeter = Pattern.compile("//.\\n.+").matcher(text).find() ? replaceRegexWithGroup(text, "(//)(.)(\\n.+)", "$2") : "";
        String str = Pattern.compile("//.\\n.+").matcher(text).find() ? replaceRegexWithGroup(text, "(//)(.\\n)(.+)", "$3") : text;

        int sum = sumStringNumbers(str, delimeter);

        return sum;
    }

    public String replaceRegexWithGroup(String text, String regex, String group) {
        return text.replaceAll(regex, group);
    }

    public int sumStringNumbers(String str, String delimeter) {

        int sum = 0;

        for(String number : str.split("[,:" + delimeter +"]")) {

            System.out.print(number + "/");

            if(Pattern.compile("-\\d+").matcher(number).find()) {
                throw new RuntimeException();
            }

            if(Pattern.compile("[+-]?\\d+").matcher(number).find()) {
                sum += Integer.parseInt(number);
            }

        }

        return sum;

    }

}
