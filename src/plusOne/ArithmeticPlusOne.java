package plusOne;

public class ArithmeticPlusOne {

    public static void main(String[] args) {
        System.out.println("plusOne.Plus.run = 1 + 1 = " + Plus.run(1, 1));
        System.out.println("plusOne.Plus.run = 3 + 1 = " + Plus.run(3, 1));
        System.out.println("plusOne.Plus.run = 1 + 3 = " + Plus.run(1, 3));
        System.out.println("plusOne.Plus.run = --------------");
        System.out.println("plusOne.Plus.run = 1 + (-3) = " + Plus.run(1, -3));
        System.out.println("plusOne.Plus.run = (-1) + 3 = " + Plus.run(-1, 3));
        System.out.println("plusOne.Plus.run = --------------");
        System.out.println("plusOne.Plus.run = (-1) + (-1) = " + Plus.run(-1, -1));
        System.out.println("plusOne.Plus.run = (-3) + (-1) = " + Plus.run(-3, -1));
        System.out.println("plusOne.Plus.run = (-1) + (-3) = " + Plus.run(-1, -3));
        System.out.println("plusOne.Plus.run = --------------");

        System.out.println("plusOne.Minus.run = 1 - 1 = " + Minus.run(1, 1));
        System.out.println("plusOne.Minus.run = 3 - 1 = " + Minus.run(3, 1));
        System.out.println("plusOne.Minus.run = 1 - 3 = " + Minus.run(1, 3));
        System.out.println("plusOne.Minus.run = --------------");
        System.out.println("plusOne.Minus.run = 1 - (-3) = " + Minus.run(1, -3));
        System.out.println("plusOne.Minus.run = (-1) - 3 = " + Minus.run(-1, 3));
        System.out.println("plusOne.Minus.run = --------------");
        System.out.println("plusOne.Minus.run = (-1) - (-1) = " + Minus.run(-1, -1));
        System.out.println("plusOne.Minus.run = (-3) - (-1) = " + Minus.run(-3, -1));
        System.out.println("plusOne.Minus.run = (-1) - (-3) = " + Minus.run(-1, -3));
        System.out.println("plusOne.Plus.run = --------------");


        System.out.println("plusOne.Multiple.run = 1 * 1 = " + Multiple.run(1,1));
        System.out.println("plusOne.Multiple.run = 0 * 1 = " + Multiple.run(0,1));
        System.out.println("plusOne.Multiple.run = 2 * 3 = " + Multiple.run(2,3));
        System.out.println("plusOne.Multiple.run = 2 * (-3) = " + Multiple.run(2,-3));
        System.out.println("plusOne.Multiple.run = (-3) * 2 = " + Multiple.run(-3,2));
        System.out.println("plusOne.Multiple.run = (-3) * (-3) = " + Multiple.run(-3,-3));
        System.out.println("plusOne.Plus.run = --------------");

        System.out.println("plusOne.Divide.run = 1 / 0 = " + Divide.run(1,0));
        System.out.println("plusOne.Divide.run = 0 / 10 = " + Divide.run(0,10));
        System.out.println("plusOne.Divide.run = 3 / 1 = " + Divide.run(3,1));
        System.out.println("plusOne.Divide.run = 10 / 3 = " + Divide.run(10,3));
        System.out.println("plusOne.Divide.run = 3 / 10 = " + Divide.run(3,10));
        System.out.println("plusOne.Divide.run = -10 / 3 = " + Divide.run(-10,3));
        System.out.println("plusOne.Divide.run = 10 / -3 = " + Divide.run(10,-3));
        System.out.println("plusOne.Divide.run = -10 / -3 = " + Divide.run(-10,-3));

    }

}
