class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        
        java.util.HashMap<Character, Integer> charIndexMap = new java.util.HashMap<>();
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            if (charIndexMap.containsKey(c)) {
                left = Math.max(left, charIndexMap.get(c) + 1);
            }
            
            charIndexMap.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}