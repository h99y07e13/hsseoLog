import java.util.Scanner;
public class Main { // 클래스 이름을 대문자로 시작
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Scanner 객체 생성
        int num1 = in.nextInt(); // 첫 번째 정수 입력
        int num2 = in.nextInt(); // 두 번째 정수 입력
 
        System.out.println(num1 + num2); // 두 수의 합 출력
    }
}