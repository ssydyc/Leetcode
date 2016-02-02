public class Solution {
    
    private boolean isValid(String str) {
        if(str.length() > 1 && str.charAt(0) == '0') return false;
        return true;
    }
    
    private boolean isAddition(String num1, String num2, String num3) {
        if(!isValid(num3)) return false;
        int len1 = num1.length(), len2 = num2.length(), len3 = num3.length();
        int carry = 0;
        for(int i = len3 - 1; i >= 0; i--) {
            int temp1 = len3 - i <= len1 ? num1.charAt(- len3 + i + len1) - '0' : 0;
            int temp2 = len3 - i <= len2 ? num2.charAt(- len3 + i + len2) - '0' : 0;
            int temp = temp1 + temp2 + carry;
            if(temp >= 10) {
                temp -= 10;
                carry = 1;
            }
            else carry = 0;
            if(temp != num3.charAt(i) - '0') return false;
        }
        if(carry == 1) return false;
        return true;
    }
    
    private boolean additiveNumber(int start, int mid, int end, String num) {
        if(end == num.length()) return true;
        int len1 = mid - start, len2 = end - mid;
        int len3 = Math.max(len1, len2);
        if(end + len3 > num.length()) return false;
        String str1 = num.substring(start, mid);
        String str2 = num.substring(mid, end);
        if(!isValid(str1) || !isValid(str2)) return false;
        String str3 = num.substring(end, end + len3);
        if(isAddition(str1, str2, str3)){
            if(additiveNumber(mid, end, end + len3, num)) return true;
        }
        if(end + len3 + 1> num.length()) return false;
        str3 = num.substring(end, end + len3 + 1);
        if(isAddition(str1, str2, str3)) return additiveNumber(mid, end, end + len3 + 1, num);
        else return false;
    }
    
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if(n < 3) return false;
        for(int i = 1; i <= n - 2; i++)
            for(int j = i + 1; j < n; j++)
                if(additiveNumber(0, i, j, num)) return true;
        return false;
    }
}
