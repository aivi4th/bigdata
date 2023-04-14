import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Vector [] array = {new Vector(1.2, 2.3, 3.4, 5.6),
                new Vector(2.3, 4.5, 6.7, 8.9)};
        System.out.println(Vector.dotProduct(array[0], array[1]));
        System.out.println(array[0].magnitude());
        System.out.println(array[1].magnitude());
    }
}

class Vector {
    private double [] coords;
    public Vector(double... coords) {
        if (coords.length == 0) throw new IllegalArgumentException("Cannot create a 0-dimentional vector");
        this.coords = coords;
    }
    public double [] getCoords() {
        try {
            return this.coords;
        } catch (Exception e) {
            System.err.println("An error occurred while getting coords: " + e.getMessage());
            return null;
        }
    }
    public static Vector add(Vector a, Vector b) {
        try {
            double[] res = new double[min(a.getCoords().length, b.getCoords().length)];
            for (int i = 0; i < res.length; i++) {
                res[i] = ind(a, i) + ind(b, i);
            }
            return new Vector(res);
        } catch (Exception e) {
            System.err.println("An error occurred while adding the vectors: " + e.getMessage());
            return null;
        }
    }
    public static Vector substract(Vector a, Vector b) {
        try {
            double [] res = new double[min(a.getCoords().length, b.getCoords().length)];
            for (int i = 0; i < res.length; i++) {
                res[i] = ind(a, i) - ind(b, i);
            }
            return new Vector(res);
        } catch (Exception e) {
            System.err.println("An error occurred while subtracting the vectors: " + e.getMessage());
            return null;
        }
    }
    public static Vector multiply(Vector a, int n) {
        try {
            double [] res = new double[a.getCoords().length];
            for (int i = 0; i < res.length; i++) {
                res[i] = ind(a, i) * n;
            }
            return new Vector(res);
        } catch (Exception e) {
            System.err.println("An error occurred while multiplying the vectors: " + e.getMessage());
            return null;
        }
    }
    public Vector incr() {
        try {
            for (int i = 0; i < this.coords.length; i++) {
                this.coords[i]++;
            }
            return this;
        } catch (Exception e) {
            System.err.println("An error occurred while incrementing the vector: " + e.getMessage());
            return null;
        }
    }
    public Vector decr() {
        try {
            for (int i = 0; i < this.coords.length; i++) {
                this.coords[i]--;
            }
            return this;
        } catch (Exception e) {
            System.err.println("An error occurred while decrementing the vector: " + e.getMessage());
            return null;
        }
    }
    public static double ind(Vector a, int index) {
        try {
            return a.getCoords()[index];
        } catch (Exception e) {
            System.err.println("An error occurred while indexing the vector: " + e.getMessage());
            return 0;
        }
    }
    public static double dotProduct(Vector a, Vector b) {
        try {
            double res = 0;
            for (int i = 0; i < min(a.getCoords().length, b.getCoords().length); i++) {
                res += ind(a, i) * ind(b, i);
            }
            return res;
        } catch (Exception e) {
            System.err.println("An error occurred while calculating dot product: " + e.getMessage());
            return 0;
        }
    }
    public double magnitude() {
        try {
            double res = 0;
            for (double coord : this.coords) {
                res += pow(coord, 2);
            }
            return sqrt(res);
        } catch (Exception e) {
            System.err.println("An error occurred while calculating vector magnitude: " + e.getMessage());
            return 0;
        }
    }

    public static double angle(Vector a, Vector b) {
        try {
            return acos(dotProduct(a, b) / (a.magnitude() * b.magnitude()));
        } catch (Exception e) {
            System.err.println("An error occurred while calculating the angle: " + e.getMessage());
            return 0;
        }
    }
}