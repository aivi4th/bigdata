import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static final String REFERENCE_CHARS = "u";
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sed ex vitae justo rhoncus feugiat sit amet et nulla. Sed finibus justo vitae massa accumsan dapibus. In vel sem vel risus volutpat scelerisque non quis nunc. Praesent id turpis vitae lacus rutrum porta. Cras ut imperdiet arcu, a posuere est.";
        String[] words = text.split("[^a-zA-Z]+");
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int comp1 = getReferenceCharAmount(s1);
                int comp2 = getReferenceCharAmount(s2);
                return comp1 != comp2 ? Integer.compare(comp1, comp2) : s1.toLowerCase().compareTo(s2.toLowerCase());
            }
            private int getReferenceCharAmount(String word) {
                return (int) word.toLowerCase().chars().mapToObj(c -> (char) c).filter(c -> Character.isLetter(c) && REFERENCE_CHARS.indexOf(c) != -1).count();
            }
        });
        System.out.println(Arrays.toString(words));    }
}