public class ArithmeticPlusOne {

    public static void main(String[] args) {
        System.out.println("Minus.run = 1 - 1 = " + Minus.run(1, 1));
        System.out.println("Minus.run = 3 - 1 = " + Minus.run(3, 1));
        System.out.println("Minus.run = 1 - 3 = " + Minus.run(1, 3));
        System.out.println("Minus.run = --------------");
        System.out.println("Minus.run = 1 - (-3) = " + Minus.run(1, -3));
        System.out.println("Minus.run = (-1) - 3 = " + Minus.run(-1, 3));
        System.out.println("Minus.run = --------------");
        System.out.println("Minus.run = (-1) - (-1) = " + Minus.run(-1, -1));
        System.out.println("Minus.run = (-3) - (-1) = " + Minus.run(-3, -1));
        System.out.println("Minus.run = (-1) - (-3) = " + Minus.run(-1, -3));


        System.out.println("Multiple.run = 1 * 1 = " + Multiple.run(1,1));
        System.out.println("Multiple.run = 0 * 1 = " + Multiple.run(0,1));
        System.out.println("Multiple.run = 2 * 3 = " + Multiple.run(2,3));
        System.out.println("Multiple.run = 2 * (-3) = " + Multiple.run(2,-3));
        System.out.println("Multiple.run = (-3) * 2 = " + Multiple.run(-3,2));
        System.out.println("Multiple.run = (-3) * (-3) = " + Multiple.run(-3,-3));

        System.out.println("Divide.run = 1 / 0 = " + Divide.run(1,0));
        System.out.println("Divide.run = 0 / 10 = " + Divide.run(0,10));
        System.out.println("Divide.run = 3 / 1 = " + Divide.run(3,1));
        System.out.println("Divide.run = 10 / 3 = " + Divide.run(10,3));
        System.out.println("Divide.run = 3 / 10 = " + Divide.run(3,10));
        System.out.println("Divide.run = -10 / 3 = " + Divide.run(-10,3));
        System.out.println("Divide.run = 10 / -3 = " + Divide.run(10,-3));
        System.out.println("Divide.run = -10 / -3 = " + Divide.run(-10,-3));

    }

}
