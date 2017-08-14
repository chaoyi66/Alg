package playground;

/**
 * Created by chaoyi on 2017/5/28.
 */
public class TestGC {
    public static void main(String[] args) {
        int[] a = new int[]{8, 5, 2, 6, 9, 3, 1, 4, 0, 7};
        wsort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void wsort(int[] a) {
        int minPosition = 0;
        for (int i = 0; i < a.length - 1; i++) {
            minPosition = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minPosition] > a[j])
                    minPosition = j;
            }
            exch(a, minPosition, i);
        }

    }

    private static void exch(int[] a, int minPosition, int i) {
        int tmp = a[i];
        a[i] = a[minPosition];
        a[minPosition] = tmp;
    }
}
