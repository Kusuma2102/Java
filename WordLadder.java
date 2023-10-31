import java.util.*;

public class WordLadder {
    public static List<String> findLadder(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<String> ladder = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        ladder.add(beginWord);
        queue.add(ladder);
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> localVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<String> currentLadder = queue.poll();
                String lastWord = currentLadder.get(currentLadder.size() - 1);

                if (lastWord.equals(endWord)) {
                    return currentLadder;
                }

                char[] wordChars = lastWord.toCharArray();
                for (int j = 0; j < lastWord.length(); j++) {
                    char originalChar = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            List<String> newLadder = new ArrayList<>(currentLadder);
                            newLadder.add(newWord);
                            queue.add(newLadder);
                            localVisited.add(newWord);
                        }
                    }

                    wordChars[j] = originalChar;
                }
            }
            visited.addAll(localVisited);
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<String> ladder = findLadder(beginWord, endWord, wordList);

        if (ladder.isEmpty()) {
            System.out.println("No word ladder found.");
        } else {
            System.out.println("Word ladder: " + ladder);
        }
    }
}
