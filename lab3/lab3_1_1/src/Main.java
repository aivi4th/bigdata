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
        this.coords = coords;
    }
    public double [] getCoords() {
        return this.coords;
    }
    public static Vector add(Vector a, Vector b) {
        double [] res = new double[min(a.getCoords().length, b.getCoords().length)];
        for (int i = 0; i < res.length; i++) {
            res[i] = ind(a, i) + ind(b, i);
        }
        return new Vector(res);
    }
    public static Vector substract(Vector a, Vector b) {
        double [] res = new double[min(a.getCoords().length, b.getCoords().length)];
        for (int i = 0; i < res.length; i++) {
            res[i] = ind(a, i) - ind(b, i);
        }
        return new Vector(res);
    }
    public static Vector multiply(Vector a, int n) {
        double [] res = new double[a.getCoords().length];
        for (int i = 0; i < res.length; i++) {
            res[i] = ind(a, i) * n;
        }
        return new Vector(res);
    }
    public Vector incr() {
        for (int i = 0; i < this.coords.length; i++) {
            this.coords[i]++;
        }
        return this;
    }
    public Vector decr() {
        for (int i = 0; i < this.coords.length; i++) {
            this.coords[i]--;
        }
        return this;
    }
    public static double ind(Vector a, int index) {
        return a.getCoords()[index];
    }
    public static double dotProduct(Vector a, Vector b) {
        double res = 0;
        for (int i = 0; i < min(a.getCoords().length, b.getCoords().length); i++) {
            res += ind(a, i) * ind(b, i);
        }
        return res;
    }
    public double magnitude() {
        double res = 0;
        for (double coord : this.coords) {
            res += pow(coord, 2);
        }
        return sqrt(res);
    }

    public static double angle(Vector a, Vector b) {
        return acos(dotProduct(a, b)/(a.magnitude()*b.magnitude()));
    }
}