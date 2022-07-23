package String.KMP;

class ImplementStrStr {
    public static void main(String[] args) {
          String s="hello",t="ll";
        System.out.println(strStr(s,t));
    }
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        if (len1 < len2) return -1;
        if (len2 == 0) return 0;
        int[] lps = new int[len2];
        computeLPS(needle, lps);
        int i = 0, j = 0;
        while (j < len2 && i < len1) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == len2)
                    return i - len2;
            } else {
                if (j > 0)
                    j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    private static void computeLPS(String str, int[] lps) {
        int len = lps.length;
        //lps[0] = 0;
        int i = 1, j = 0;
        while (i < len) {
            if (str.charAt(i) == str.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j > 0)
                    j = lps[j - 1];
                else
                    lps[i++] = 0;
    }
}
    }}