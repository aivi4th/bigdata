import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String text = "В белом плаще с кровавым подбоем, шаркающей кавалерийской походкой, ранним утром четырнадцатого числа весеннего месяца нисана в крытую колоннаду между двумя крыльями дворца Ирода Великого вышел прокуратор Иудеи Понтий Пилат. Более всего на свете прокуратор ненавидел запах розового масла, и все теперь предвещало нехороший день, так как запах этот начал преследовать прокуратора с рассвета. Прокуратору казалось, что розовый запах источают кипарисы и пальмы в саду, что к запаху кожаного снаряжения и пота от конвоя примешивается проклятая розовая струя. От флигелей в тылу дворца, где расположилась пришедшая с прокуратором в Ершалаим первая когорта Двенадцатого Молниеносного легиона, заносило дымком в колоннаду через верхнюю площадку сада, и к горьковатому дыму, свидетельствовавшему о том, что кашевары в кентуриях начали готовить обед, примешивался все тот же жирный розовый дух.";
        String[] words = text.split("[^а-яА-Я]+");
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Double.compare(getVowelFraction(s1), getVowelFraction(s2));
            }
            private double getVowelFraction(String word) {
                int vowelCount = (int) word.chars().mapToObj(c -> (char) c).filter(c -> Character.isLetter(c) && "аеёиоуыэюяАЕЁИОУЫЭЮЯ".indexOf(c) != -1).count();
                int letterCount = (int) word.chars().mapToObj(c -> (char) c).filter(Character::isLetter).count();
                return (double) vowelCount / (double) letterCount;
            }
        });
        System.out.println(Arrays.toString(words));
    }
}