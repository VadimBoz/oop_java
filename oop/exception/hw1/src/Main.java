import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 0, 3};

        System.out.println(Arrays.toString(subArrays(a, b)));

    }



    public static int[] subArrays(int[] a, int[] b){
        // Введите свое решение ниже
        if (a.length != b.length) return new int[]{0};
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0) throw new RuntimeException();
            c[i] = a[i] / b[i];
        }
        return c;
    }
}