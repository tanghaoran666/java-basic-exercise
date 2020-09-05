import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrammarExercise {
    private static Object Exception;
    private static Object RuntimeException;

    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> first = new ArrayList<>(Arrays.asList(firstWordList.split(",")));
        List<String> second = new ArrayList<>(Arrays.asList(secondWordList.split(",")));
        ArrayList<String> firstAfterUpper;
        ArrayList<String> secondAfterUpper;
        firstAfterUpper = getUpperSpace(first);
        secondAfterUpper = getUpperSpace(second);
        firstAfterUpper.retainAll(secondAfterUpper);
        List<String> expected = firstAfterUpper.stream().distinct().sorted().collect(Collectors.toList());
        return expected;
    }

    private static ArrayList<String> getUpperSpace(List<String> first) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : first) {
            if ( s.length() == 0) throw new RuntimeException("input not valid");
            s = s.toUpperCase();
            String resultFirst = new String();
            for(int i=0;i<s.length();i++){
                char ch =s.charAt(i);
                if(!Character.isUpperCase(ch)) throw new RuntimeException("input not valid");
                if (i > 0) {
                    resultFirst = resultFirst + " ";
                }
                resultFirst += ch;
            }
            result.add(resultFirst);
        }
        return  result;
    }
}
