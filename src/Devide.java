import java.util.HashMap;
import java.util.Map;

public class Devide {

    public static Map<String, Integer> run(int first, int second) {
        int quotient = 0;
        int reminder = 0;

        if (second == 0) {
            throw new ArithmeticException("나누는 수는 0 이 불가");
        }
        if (first == 0) {
        }

        //일단 절대값 - (음수 부분의 나머지 처리 방식 때문에 바뀔 수 있음)
        int firstTemp = makeAbsValue(first);
        int secondTemp = makeAbsValue(second);


        for (int temp = 0; firstTemp >= temp; temp++) {
            if (secondTemp == reminder) {
               reminder =0;
               quotient++;
            }
            reminder++;
            temp++;
        }

        /**
         * 음수...
         */



        Map<String, Integer> result = new HashMap<>();
        result.put("몫", quotient);
        result.put("나머지", reminder);

        return result;
    }

    private static int makeAbsValue(int num) {
        int numTemp = 0;
        if (num > 0) {
            for (int i = 0; num >= i; i++) {
                numTemp++;
            }
        }
        if (num < 0) {
            for (int i = 0; num <= i; i++) {
                numTemp++;
            }
        }
        return numTemp;
    }


}
