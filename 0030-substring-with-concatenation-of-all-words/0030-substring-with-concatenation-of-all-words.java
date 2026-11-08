import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        if (s.length() < totalLen) {
            return result;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> seenMap = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(sub)) {
                    seenMap.put(sub, seenMap.getOrDefault(sub, 0) + 1);
                    count++;

                    while (seenMap.get(sub) > wordMap.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        seenMap.put(leftSub, seenMap.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    seenMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}