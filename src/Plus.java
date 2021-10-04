public class Plus {

    public static int run(int first, int second) {
        int result = 0;

        int firstTemp = makeAbsValue(first);
        int secondTemp = makeAbsValue(second);

        if (first > 0 && second > 0) {
            for (int i = 0; secondTemp > i; i++) {
                firstTemp++;
            }
            result = firstTemp;
            return result;
        }

        if (first < 0 && second < 0) {
            for (int i = 0; secondTemp > i; i++) {
                firstTemp++;
            }
            result = ~firstTemp + 1;
            return result;
        }

        if (first < 0 && second > 0) {
            if (firstTemp == secondTemp) {
                return 0;
            }
            for (int i = 0; second > i; i++) {
                first++;
            }
            result = first;
            return result;
        }

        if (second < 0 && first > 0) {
            if (firstTemp == secondTemp) {
                return 0;
            }
            for (int i = 0; first > i; i++) {
                second++;
            }
            result = second;
            return result;
        }

        return result;
    }

    private static int makeAbsValue(int num) {
        int numTemp = 0;
        if (num > 0) {
            for (int i = 0; num > i; i++) {
                numTemp++;
            }
        }
        if (num < 0) {
            for (; num < 0; num++) {
                numTemp++;
            }
        }
        return numTemp;
    }
}
