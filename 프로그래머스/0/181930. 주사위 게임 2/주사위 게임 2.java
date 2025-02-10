class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        if (a == b && b == c) { // 세 숫자가 모두 같을 경우
        answer = (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
    } else if (a != b && b != c && c != a) { // 세 숫자가 모두 다를 경우
        answer = a + b + c;
    } else { // 두 개의 숫자만 같을 경우
        answer = (a + b + c) * (a * a + b * b + c * c);
    }

    return answer;
    }
}