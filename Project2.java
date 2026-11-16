public class Project2 {
    public static void main(String[] args) {
        System.out.println("=== CPU 가상 프로그램 가동 ===");

        CPU myCpu = new CPU();

        System.out.println(new CPUComponent("Control Unit"));
        System.out.println(new CPUComponent("ALU"));
        System.out.println(new Register("R1"));
        System.out.println(new Register("R2"));

        String[] program = {
                "MOV  R1 25",
                "MOV  R2 10",
                "ADD  R1 R2",
                "SUB  R1 R2"
        };

        myCpu.runProgram(program);
        System.out.println("=== 프로그램 가동 종료 ===");
    }
}

// 모든 CPU 유닛의 부모 클래스
class CPUComponent {
    protected String name;

    public CPUComponent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "] 가동 준비 완료.";
    }
}

// 레지스터: 값을 저장하는 유닛
class Register extends CPUComponent {
    private int value;

    public Register(String name) {
        super(name);
        this.value = 0;
    }

    public void write(int data) {
        value = data;
    }

    public int read() {
        return value;
    }

    @Override
    public String toString() {
        return name + "=" + value;
    }
}

// 제어 장치: 명령어를 해독하는 유닛
class ControlUnit extends CPUComponent {
    public ControlUnit() {
        super("Control Unit");
    }

    public String[] fetch_and_decode(String instruction) {
        System.out.println("[" + name + "] 명령어 해독: " + instruction);

        // 공백이 하나 이상 연속된 부분을 기준으로 자른다
        return instruction.split("\\s+");
    }
}

// 산술 논리 장치: 연산을 수행하는 유닛
class ALU extends CPUComponent {
    public ALU() {
        super("ALU");
    }

    public int execute(String op, int val1, int val2) {
        if (op.equals("ADD")) {
            System.out.println(" [" + name + "] 연산 수행: " + val1 + " + " + val2);
            return val1 + val2;
        } else if (op.equals("SUB")) {
            System.out.println(" [" + name + "] 연산 수행: " + val1 + " - " + val2);
            return val1 - val2;
        }
        return 0;
    }
}

// CPU: 각 유닛을 조립하고 프로그램을 실행
class CPU {
    private ControlUnit cu;
    private ALU alu;
    private Register r1;
    private Register r2;

    public CPU() {
        cu = new ControlUnit();
        alu = new ALU();
        r1 = new Register("R1");
        r2 = new Register("R2");
    }

    public void runProgram(String[] program) {
        String line = "----------------------------------------";
        System.out.println(line);

        for (int i = 0; i < program.length; i++) {
            String[] tokens = cu.fetch_and_decode(program[i]);
            String op = tokens[0];

            if (op.equals("MOV")) {
                // MOV 레지스터 값 : 레지스터에 값을 저장
                Register dest = getRegister(tokens[1]);
                if (dest != null) {
                    dest.write(Integer.parseInt(tokens[2]));
                }
            } else if (op.equals("ADD") || op.equals("SUB")) {
                // ADD/SUB 레지스터1 레지스터2 : 연산 결과를 레지스터1에 저장
                Register dest = getRegister(tokens[1]);
                Register src = getRegister(tokens[2]);
                if (dest != null && src != null) {
                    int result = alu.execute(op, dest.read(), src.read());
                    dest.write(result);
                }
            }

            System.out.println("[현재 레지스터 상태] " + r1 + " | " + r2);
            System.out.println(line);
        }
    }

    // 레지스터 이름에 맞는 객체를 반환, 없으면 null
    private Register getRegister(String regName) {
        if (regName.equals("R1")) {
            return r1;
        } else if (regName.equals("R2")) {
            return r2;
        }
        return null;
    }
}
