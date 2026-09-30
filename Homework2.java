import java.util.Scanner;

class Student{
    private long num;
    private String name;
    private String major;
    private long phone;

    public void setNum(long num) {this.num = num; }
    public void setName(String name) {this.name = name; }
    public void setMajor(String major) {this.major = major; }
    public void setPhone(long phone) {this.phone = phone; }

    public long getNum() {return num; }
    public String getName() {return name; }
    public String getMajor() {return major; }
    public long getPhone() {return phone; }
}

public class Homework2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3];

        for (int i = 0; i < students.length; i++) {
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");
            String[] s = sc.nextLine().split(" ");

            Student o = new Student();
            o.setNum(Long.parseLong(s[0]));
            o.setName(s[1]);
            o.setMajor(s[2]);
            o.setPhone(Long.parseLong(s[3]));
            students[i] = o;

        }

        System.out.println();
        System.out.println("입력된 학생들의 정보는 다음과 같습니다.");

        for (int i = 0; i < students.length; i++) {
            Student o = students[i];
            System.out.printf("%d번째 학생: %d %s %s %s\n", i + 1, o.getNum(), o.getName(), o.getMajor(), hyphen(o.getPhone()));
        }


    }

    public static String hyphen(long phone) {
        String p = "0" + Long.toString(phone);
        p = p.substring(0, 3) + "-" + p.substring(3, 7) + "-" + p.substring(7);
        return p;
    }

}
