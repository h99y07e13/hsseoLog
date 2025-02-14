public class Solution {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length; // 직원 수
        int count = 0; // 지각하지 않은 직원 수
        
        // 1부터 7까지 요일을 저장하는 배열 (1: 월요일, 2: 화요일, ..., 7: 일요일)
        for (int i = 0; i < n; i++) {
            // 출근 인정 시각을 계산
            int scheduleHour = schedules[i] / 100;  // 시 부분 (예: 855는 8)
            int scheduleMinute = schedules[i] % 100; // 분 부분 (예: 855는 55)
            int targetHour = scheduleHour;  // 출근 인정 시각의 시
            int targetMinute = scheduleMinute + 10;  // 출근 인정 시각의 분 (10분 더하기)
            
            // 10분을 더했을 때, 분이 60을 넘을 경우 시간도 1시간 증가
            if (targetMinute >= 60) {
                targetMinute -= 60;
                targetHour += 1;
            }

            boolean onTime = true; // 지각하지 않았는지 여부
            
            for (int j = 0; j < 7; j++) {
                // 요일 계산: startday는 시작 요일 (1: 월요일, ..., 7: 일요일)
                // 요일을 1부터 7까지 순차적으로 계산 (0부터 6까지 배열 인덱스에 맞게)
                int day = (startday + j - 1) % 7 + 1;
                
                // 주말(토요일, 일요일)은 출근 체크를 하지 않음
                if (day == 6 || day == 7) { // 토요일(6)과 일요일(7)은 출근 체크에서 제외
                    continue;
                }
                
                // timelogs[i][j]는 i번째 직원의 j번째 날 출근 시간 (시와 분 단위로 계산)
                int logHour = timelogs[i][j] / 100;  // 출근 시간의 시
                int logMinute = timelogs[i][j] % 100; // 출근 시간의 분
                
                // 출근 시간이 인정 시각을 넘으면 지각
                if (logHour > targetHour || (logHour == targetHour && logMinute > targetMinute)) {
                    onTime = false;
                    break; // 한 번이라도 지각하면 더 이상 체크할 필요 없음
                }
            }
            
            // 만약 지각하지 않으면 카운트 증가
            if (onTime) {
                count++;
            }
        }
        
        return count; // 지각하지 않은 직원 수 반환
    }
}
