public class MaxValue {

    private static int max(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return 0;
        }
        int max = 0;
        int length = a.length;
        int index = 0;
        for (int i = 0; i < length; i++, index++) {
            int v = index < b.length ? b[index] : 0;
            int first = a[i] * v;
            int last = a[length - 1 - i] * v;
            if (last > first) {
                max += last;
                length = length - 1;
                i--;
            } else {
                max += first;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(new int[]{1, 100, 3, 5}, new int[]{2, 1, 2, 1}));
    }

}
