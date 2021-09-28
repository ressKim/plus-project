public class ArithmeticPlusOne {

    public static void main(String[] args) {
        System.out.println("minus = 1 - 1 = " + minus(1, 1));
        System.out.println("minus = 3 - 1 = " + minus(3, 1));
        System.out.println("minus = 1 - 3 = " + minus(1, 3));
        System.out.println("minus = --------------");
        System.out.println("minus = 1 - (-3) = " + minus(1, -3));
        System.out.println("minus = (-1) - 3 = " + minus(-1, 3));
        System.out.println("minus = --------------");
        System.out.println("minus = (-1) - (-1) = " + minus(-1, -1));
        System.out.println("minus = (-3) - (-1) = " + minus(-3, -1));
        System.out.println("minus = (-1) - (-3) = " + minus(-1, -3));
    }



    protected static int minus(int first, int second) {

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
                // 이미 아닌거같은데...
                return -result;
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

            result = -second;
            return result;
        }

        if (first < 0 && second < 0) {
            if (first < second) {
                while (second != 0) {
                   first++;
                   second++;
                }
                result = -first;
                return result;
            }

            if (first > second) {
                while (first != 0) {
                    first++;
                    second++;
                }
                result = second;
                return result;
            }
        }

        return result;
    }

}
