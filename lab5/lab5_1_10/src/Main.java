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
        try {
            this.matrix = other.getMatrix();
            this.width = other.getWidth();
            this.height = other.getHeight();
        } catch (Exception e) {
            System.err.println("An error occured while copying other BoolMatrix " + e.getMessage());
        }
    }
    public BoolMatrix(boolean [][] other) {
        if (Arrays.stream(other).anyMatch(row -> row.length != other[0].length)) {
            throw new IllegalArgumentException("Source matrix is not a matrix");
        }
        this.matrix = other;
        this.width = other[0].length;
        this.height = other.length;
    }
    public boolean [][] getMatrix() {
        try {
            return this.matrix;
        } catch (Exception e) {
            System.err.println("An error occurred while accessing BoolMatrix " + e.getMessage());
            return null;
        }
    }
    public int getWidth() {
        try {
            return this.width;
        } catch (Exception e) {
            System.err.println("An error occurred while accessing BoolMatrix " + e.getMessage());
            return 0;
        }
    }
    public int getHeight() {
        try {
            return this.height;
        } catch (Exception e) {
            System.err.println("An error occurred while accessing BoolMatrix " + e.getMessage());
            return 0;
        }
    }
    public static BoolMatrix disjunct(BoolMatrix a, BoolMatrix b) {
        try {
            boolean[][] res = new boolean[min(a.height, b.height)][min(a.width, b.width)];
            for (int i = 0; i < min(a.height, b.height); i++) {
                for (int j = 0; j < min(a.width, b.width); j++) {
                    res[i][j] = a.getMatrix()[i][j] && b.getMatrix()[i][j];
                }
            }
            return new BoolMatrix(res);
        } catch (Exception e) {
            System.err.println("An error occurred while disjunction " + e.getMessage());
            return null;
        }
    }
    public static BoolMatrix conjunct(BoolMatrix a, BoolMatrix b) {
        try {
            boolean[][] res = new boolean[min(a.height, b.height)][min(a.width, b.width)];
            for (int i = 0; i < min(a.height, b.height); i++) {
                for (int j = 0; j < min(a.width, b.width); j++) {
                    res[i][j] = a.getMatrix()[i][j] || b.getMatrix()[i][j];
                }
            }
            return new BoolMatrix(res);
        } catch (Exception e) {
            System.err.println("An error occurred while conjunction " + e.getMessage());
            return null;
        }
    }
    public static BoolMatrix inverse(BoolMatrix a) {
        try {
            boolean[][] res = new boolean[a.height][a.width];
            for (int i = 0; i < a.height; i++) {
                for (int j = 0; j < a.width; j++) {
                    res[i][j] = !a.getMatrix()[i][j];
                }
            }
            return new BoolMatrix(res);
        } catch (Exception e) {
            System.err.println("An error occurred while inversion " + e.getMessage());
            return null;
        }
    }
    public int trueCount() {
        try {
            int res = 0;
            for (boolean[] row : this.getMatrix()) for (boolean col : row) if (col) res++;
            return res;
        } catch (Exception e) {
            System.err.println("An error occurred while counting trues " + e.getMessage());
            return 0;
        }
    }
    public BoolMatrix sorted() {
        try {
            boolean[][] res = Arrays.copyOf(this.getMatrix(), this.height);
            Arrays.sort(res, Comparator.comparingInt(o -> {
                int a = 0;
                for (boolean d : o) {
                    a = (a << 1) | (d ? 1 : 0);
                }
                return a;
            }));
            return new BoolMatrix(res);
        } catch (Exception e) {
            System.err.println("An error occurred while sorting " + e.getMessage());
            return null;
        }
    }
}