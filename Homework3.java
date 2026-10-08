import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개의 수를 입력할 예정인가요? ");
        int a = sc.nextInt();
        int[] arr = new int[a];

        System.out.print("수를 입력하세요: ");
        for (int i = 0; i < a; i++){
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < a; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        System.out.printf("최댓값:%d\n최솟값:%d", max, min);
    }

}
