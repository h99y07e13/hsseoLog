class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int num = 0;

        for (int i : numbers) {
            answer += i; 
            num++;
        }
        
        answer = answer / num; 
        return answer;
    }
}