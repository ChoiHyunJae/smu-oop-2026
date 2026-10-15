import java.util.Scanner;

public class Project1 {

    static boolean run = true;
    static String[] his = new String[10];
    static int i = 0;

    static void command(String com){
        switch (com) {
            case "/exit":
                exit();
                break;
            case "/help":
                help();
                break;
            case "/list":
                list();
                break;
            case "/history":
                history();
                break;
            case "/!":
                again();
                break;
            default:
                System.out.printf("Invalid command: %s\n",com);
                System.out.println("Type /help for help.");
        }
    }

    static void exit(){
        System.out.println("Goodbye.");
        run = false;
    }

    static void help(){
        System.out.println("Type a Java language expression, statement, or declaration.");
        System.out.println("Or type one of the following commands:");
        System.out.println("/list: list the source you have typed.");
        System.out.println("/exit: exit the jshell tool");
        System.out.println("/history: history of what you have typed.");
        System.out.println("/!: rerun last snippet.");
    }

    static void list(){
        int y = 1;
        for(int x = 0; x < i; x++){
            String[] his1 = his[x].split("");
            if(!his1[0].equals("/")) {
                System.out.printf("%d : %s\n", y, his[x]);
                y++;
            }
        }
    }


    static void history(){
        for(int x = 0; x < i; x++){
            System.out.println(his[x]);
        }
    }

    static void again(){
        int x = i-1;
        while (x >= 0) {
            String[] his2 = his[x].split("");
            if (!his2[0].equals("/")) {
                System.out.printf("Re-running '%s'.\n", his[x]);
                break;
            } else x--;
        }

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (run) {
            System.out.print("jshell> ");
            String com = sc.nextLine();
            String[] com1 = com.split("");

            if (!com1[0].equals("/")) {
                System.out.printf("Running '%s'.\n", com);
            } else {
                command(com);
            }

            his[i] = com;
            i++;
            if(i == 10) {
                System.out.println("The history buffer is cleared.");
                his = new String[10];
                i = 0;
            }
        }
    }
}
