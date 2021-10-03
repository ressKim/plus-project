public class Multiple {

    public static int run(int first, int second) {
        int result = 0;

        if (first == 0 || second == 0) {
            return result;
        }

        //절대값 생성
        int firstTemp = makeAbsValue(first);
        int secondTemp = makeAbsValue(second);

        for (int i = 0; secondTemp >= i; i++) {
            for (int k = 0; firstTemp >= k; k++) {
                result++;
            }
        }

        /**
         * 한 부호가 마이너스일때 -1 을 곱해야 하는데 방법이 ...
         */
        if (first < 0 || second < 0) {
            if (first < 0 && second < 0) {
                return result;
            }
            return -result;
        }

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
