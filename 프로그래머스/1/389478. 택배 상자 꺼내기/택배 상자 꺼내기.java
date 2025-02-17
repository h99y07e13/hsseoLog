class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        // w == 1인 경우 예외 처리
        if (w == 1) {
            return n - num + 1;
        }

        num -= 1;  // 0-based 인덱스를 사용하기 위해 1을 빼기
        n -= 1;

        // x, y는 num이 속한 층과 열
        int[] xy = divmod(num, w);
        int x = xy[0];
        int y = xy[1];

        // 짝수층(왼쪽 → 오른쪽)과 홀수층(오른쪽 → 왼쪽) 처리
        if (x % 2 == 1) {
            y = w - y - 1;
        }

        // ex, ey는 마지막 상자의 위치
        int[] exy = divmod(n, w);
        int ex = exy[0];
        int ey = exy[1];

        answer += ex - x;

        // 홀수층의 경우 열에 대한 추가 조건 처리
        if (ex % 2 == 1) {
            ey = w - ey - 1;
            answer += (ey <= y && y < w) ? 1 : 0;
        } else {
            answer += (0 <= y && y <= ey) ? 1 : 0;
        }

        return answer;
    }

    // divmod: 몫과 나머지를 구하는 함수
    private int[] divmod(int num, int w) {
        int[] result = new int[2];
        result[0] = num / w;  // 몫
        result[1] = num % w;  // 나머지
        return result;
    }
}
