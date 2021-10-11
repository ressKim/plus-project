package plusOne;

public class Minus {

    public static int run(int first, int second) {
        if (first == second) {
            return 0;
        }

        int result = 0;

        if (first > 0 && second > 0) {
            if (first > second) {
                while (first != second) {
                    result++;
                    second++;
                }
            }
            if (first < second) {
                while (first != second) {
                    result++;
                    first++;
                }

                return ~result +1;
            }
            return result;
        }

        if (first > 0 && second < 0) {
            while (second != 0) {
                first++;
                second++;
            }

            result = first;
            return result;

        }

        if (first < 0 && second > 0) {
            while (first != 0) {
                first++;
                second++;
            }

            result = ~second+1;
            return result;
        }

        if (first < 0 && second < 0) {
            if (first < second) {
                while (second != 0) {
                    first++;
                    second++;
                }
                /**
                 * 삑!! 마이너스 해결하고 수정 필요
                 */
                result = first;
                return result;
            }

            if (first > second) {
                while (first != 0) {
                    first++;
                    second++;
                }
                result = ~second +1;
                return result;
            }
        }
        return result;
    }


}
