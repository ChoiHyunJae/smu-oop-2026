import java.util.Scanner;

public class Homework4{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("두 수를 입력하시오 : ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = gcd(x,y);
        System.out.printf("두 수의 최대공약수는 %d입니다", z);
    }
    static int gcd(int a, int b){
        if(a==0 || a==b){ return b;}
        else if(b==0){return a;}
        else if(a<b){return gcd(a,b%a);}
        else{return gcd(b,a%b);}
    }
    static int gcd1(int a, int b){
        while(a!=0 && b!=0 && a!=b){
            if(a<b) { b %= a;}
            else {
                int d = a;
                a = b;
                b = d%b;
            }
        }
        if(a==0 || a==b) {return b;}
        else {return a;}
    }
}