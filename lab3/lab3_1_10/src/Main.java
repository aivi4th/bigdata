import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        boolean [][] test = {{true, false, true, true}, {false, false, true, false}, {true, false, false, false}};
        BoolMatrix bm1 = new BoolMatrix(test);
        BoolMatrix bm2 = BoolMatrix.inverse(bm1);

        System.out.println(Arrays.deepToString(BoolMatrix.conjunct(bm1, bm2).getMatrix()));
        System.out.println(Arrays.deepToString(BoolMatrix.disjunct(bm1, bm2).getMatrix()));
        System.out.println(bm1.trueCount());
        System.out.println(bm2.trueCount());
        System.out.println(Arrays.deepToString(bm1.sorted().getMatrix()));
        System.out.println(Arrays.deepToString(bm2.sorted().getMatrix()));
    }
}

class BoolMatrix {
    private boolean [][] matrix;
    private int width;
    private int height;
    public BoolMatrix(BoolMatrix other) {
        this.matrix = other.getMatrix();
        this.width = other.getWidth();
        this.height = other.getHeight();
    }
    public BoolMatrix(boolean [][] other) {
        this.matrix = other;
        this.width = other[0].length;
        this.height = other.length;
    }
    public boolean [][] getMatrix() {
        return this.matrix;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public static BoolMatrix disjunct(BoolMatrix a, BoolMatrix b) {
        boolean [][] res = new boolean [min(a.height,b.height)][min(a.width, b.width)];
        for (int i = 0; i < min(a.height, b.height); i++) {
            for (int j = 0; j < min(a.width, b.width); j++) {
                res[i][j] = a.getMatrix()[i][j] && b.getMatrix()[i][j];
            }
        }
        return new BoolMatrix(res);
    }
    public static BoolMatrix conjunct(BoolMatrix a, BoolMatrix b) {
        boolean [][] res = new boolean [min(a.height,b.height)][min(a.width, b.width)];
        for (int i = 0; i < min(a.height, b.height); i++) {
            for (int j = 0; j < min(a.width, b.width); j++) {
                res[i][j] = a.getMatrix()[i][j] || b.getMatrix()[i][j];
            }
        }
        return new BoolMatrix(res);
    }
    public static BoolMatrix inverse(BoolMatrix a) {
        boolean [][] res = new boolean [a.height][a.width];
        for (int i = 0; i < a.height; i++) {
            for (int j = 0; j < a.width; j++) {
                res[i][j] = !a.getMatrix()[i][j];
            }
        }
        return new BoolMatrix(res);
    }
    public int trueCount() {
        int res = 0;
        for (boolean[] row : this.getMatrix()) for (boolean col : row) if (col) res++;
        return res;
    }
    public BoolMatrix sorted() {
        boolean [][] res = Arrays.copyOf(this.getMatrix(), this.height);
        Arrays.sort(res, Comparator.comparingInt(o -> {
            int a = 0;
            for (boolean d : o) {
                a = (a << 1) | (d ? 1 : 0);
            }
            return a;
        }));
        return new BoolMatrix(res);
    }
}