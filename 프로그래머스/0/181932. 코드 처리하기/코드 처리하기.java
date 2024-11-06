class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        String[] s = code.split("");
        boolean mode = false;
        
        for (int i = 0; i < s.length; i++) {
            if (!mode && s[i].equals("1")) {
                mode = true;
            } else if (mode && s[i].equals("1")) {
                mode = false;
            }
            
            if (!s[i].equals("1") && i % 2 == 0 && !mode) {
                sb.append(s[i]);
            } else if (!s[i].equals("1") && i % 2 != 0 && mode) {
                sb.append(s[i]);
            }
        }
        
        String answer = "";
        if (sb.toString().isEmpty()) {
            answer = "EMPTY";
        } else {
            answer = sb.toString();
        }
        return answer;
    }
}