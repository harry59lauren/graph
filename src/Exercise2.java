public class Exercise2 {

    public static int  minimumOperations(int start, int end){
        return Math.abs(minOperations(start,0, end));
    }

    public static int minOperations(int current, int n, int sum){
        if(current > sum) return 0;
        if(current == sum){
            System.out.println("made it");
            return -(n);
        }
        return Math.min(minOperations(current * 2, n + 1, sum),minOperations(current * 10 + 1, n + 1, sum));
    }
}
