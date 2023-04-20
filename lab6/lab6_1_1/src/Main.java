import java.util.*;
public class Main {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet(Arrays.asList(1,2,3,4,5));
        IntegerSet set2 = new IntegerSet(Arrays.asList(2,3,5,7,11));
        System.out.println(IntegerSet.intersection(set1, set2));
        System.out.println(IntegerSet.union(set1, set2));
    }
}

class IntegerSet extends TreeSet<Integer> {
    public IntegerSet () {
        super();
    }
    public IntegerSet (Collection<Integer> set) {
        super(set);
    }
    public static IntegerSet intersection (IntegerSet a, IntegerSet b) {
        IntegerSet intersect = new IntegerSet(a);
        intersect.retainAll(b);
        return intersect;
    }
    public static IntegerSet union(IntegerSet a, IntegerSet b) {
        IntegerSet unify = new IntegerSet(a);
        unify.addAll(b);
        return unify;
    }
}