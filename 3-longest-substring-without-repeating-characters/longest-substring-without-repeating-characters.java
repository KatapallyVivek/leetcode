class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int n = s.length();
        int maxLen = 0;

        for(int right = 0; right< n; right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            set.add(s.charAt(right));
        }
        return maxLen;
    }
}