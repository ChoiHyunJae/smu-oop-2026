import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args){
        int sum = 0;
        for( int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("정수를 입력하시오(%d/5): ",i+1);
            int num = sc.nextInt();
            sum += num;
            System.out.printf("현재까지 입력된 정수의 합은 %d입니다\n",sum);
        }
    }
}
