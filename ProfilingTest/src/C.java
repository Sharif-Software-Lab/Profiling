import java.util.ArrayList;
import java.util.List;

public class C {

    private static C instance;

    public static C getInstance() {
        if (instance == null)
            instance = new C();
        return instance;
    }

    public void doJobC() {
        phi(2000);
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

}
