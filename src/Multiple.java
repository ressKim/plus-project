public class Multiple {

    public static int run(int first, int second){
        int result = 0;
        int temp = 0;

        if (first == 0 || second == 0) {
            return result;
        }

        if (first > 0 && second > 0) {
            for (int i = 0; second >= i; i++) {
                for (int k = 0; first >= k; k++) {
                    result++;
                }
            }
        }


        return result;
    }
}
