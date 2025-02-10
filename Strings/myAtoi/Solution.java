class Solution {
    public static void main(String[] args) {
        String s="  -034";
        int ans=myAtoi(s);
        System.out.println(ans);
    }
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sb.append(s.charAt(i));
            i++;
        }
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                break;
            }
        }
        if (sb.length() == 0 || (sb.length() == 1 && (sb.charAt(0) == '-' || sb.charAt(0) == '+'))) {
            return 0;
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return sb.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
