//time complexity- O(target)
//space complexity- O(1)
public class CalculateUsingBrokenCalculator {
    static int brokenCalc(int startValue, int target) {
        int steps = 0;
        int num = target;
        while(num > startValue) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num += 1;
            }
            steps++;
        }
        return steps + startValue - num;
    }
    public static void main(String[] args) {
        int startValue = 1;
        int target = 1024;
        System.out.println("Minimum steps to make "+ startValue + " to "+ target + " is: " + brokenCalc(startValue, target));

    }
}
