class Solution {
    public boolean isPalindrome(String s) {
        int index1 = 0;
        int index2 = s.length() - 1;
        char[] arr = s.toCharArray();
        while (index1 < index2) {
            while (index1 < index2 && !Character.isLetterOrDigit(arr[index1])) {
                index1++;
            }
            while (index1 < index2 && !Character.isLetterOrDigit(arr[index2])) {
                index2--;
            }
            if (index1 > index2) return false;
            if (Character.toLowerCase(arr[index1]) != Character.toLowerCase(arr[index2])) return false;
          index1++;
          index2--;
        }

        return true;
    }
}