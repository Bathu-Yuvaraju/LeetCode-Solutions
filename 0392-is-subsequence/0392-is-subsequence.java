class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int l=0,r=0;
        while(l<len1 && r<len2)
        {
            if(s.charAt(l)==t.charAt(r))
                l++;
            r++;
        }
        return l==len1;
    }
}