import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "В белом плаще с кровавым подбоем, шаркающей кавалерийской походкой, ранним утром четырнадцатого числа весеннего месяца нисана в крытую колоннаду между двумя крыльями дворца Ирода Великого вышел прокуратор Иудеи Понтий Пилат. Более всего на свете прокуратор ненавидел запах розового масла, и все теперь предвещало нехороший день, так как запах этот начал преследовать прокуратора с рассвета. Прокуратору казалось, что розовый запах источают кипарисы и пальмы в саду, что к запаху кожаного снаряжения и пота от конвоя примешивается проклятая розовая струя. От флигелей в тылу дворца, где расположилась пришедшая с прокуратором в Ершалаим первая когорта Двенадцатого Молниеносного легиона, заносило дымком в колоннаду через верхнюю площадку сада, и к горьковатому дыму, свидетельствовавшему о том, что кашевары в кентуриях начали готовить обед, примешивался все тот же жирный розовый дух.";
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split("[^а-яА-Я]+")));
        WordChain wordChain = new WordChain(words);
        List<String> longestChain = wordChain.getLongestChain();
        if (longestChain.isEmpty()) {
            System.out.println("No word chain found.");
        } else {
            System.out.println("Longest word chain:");
            for (String word : longestChain) {
                System.out.println(word);
            }
        }
    }
}
class WordChain {
    private Map<Character, List<String>> wordMap;
    public WordChain(List<String> words) {
        wordMap = new HashMap<>();
        for (String word : words) {
            char firstChar = word.charAt(0);
            if (!wordMap.containsKey(firstChar)) {
                wordMap.put(firstChar, new ArrayList<>());
            }
            wordMap.get(firstChar).add(word);
        }
    }
    public List<String> getLongestChain() {
        List<String> longestChain = new ArrayList<>();
        for (char c : wordMap.keySet()) {
            List<String> chain = dfs(c, new HashSet<>());
            if (chain.size() > longestChain.size()) {
                longestChain = chain;
            }
        }
        return longestChain;
    }
    private List<String> dfs(char c, Set<String> visited) {
        List<String> longestChain = new ArrayList<>();
        for (String word : wordMap.getOrDefault(c, Collections.emptyList())) {
            if (!visited.contains(word)) {
                visited.add(word);
                List<String> chain = dfs(word.charAt(word.length() - 1), visited);
                chain.add(0, word);
                if (chain.size() > longestChain.size()) {
                    longestChain = chain;
                }
                visited.remove(word);
            }
        }
        return longestChain;
    }
}