import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {

    private static C instance;

    public static C getInstance() {
        if (instance == null)
            instance = new C();
        return instance;
    }

    public void doJobC() {
        phi_more_efficient(2000);
        sleepMethodC();
    }

    private void sleepMethodC() {
        for (int i = 0; i < 100; i++) {
            Utils.sleepUninterrruptable(0.01);
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int naive_phi(int n){
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (gcd(i, n) == 1) count++;
        }
        return count;
    }

    private void phi(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(naive_phi(i));
        }
        System.out.println(list);
    }

    private void phi_more_efficient(int n){
        int [] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (dp[i] == i) {
                for (int j = i; j <= n; j += i) {
                    dp[j] = (dp[j] * (i - 1)) / i;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }

}
