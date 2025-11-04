import java.util.Scanner;

public class NFASimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a string (or type 'exit' to quit): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            int[] current = {0, -1, -1};
            int next0, next1, next2;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                next0 = next1 = next2 = -1;

                for (int state : current) {
                    if (state == -1) continue;

                    if (state == 0) {
                        if (c == 'a') {
                            next0 = 0;
                            next1 = 1;
                        } else if (c == 'b') {
                            next0 = 0;
                        }
                    } else if (state == 1) {
                        if (c == 'b') {
                            next2 = 2;
                        }
                    }
                }

                int[] newStates = {-1, -1, -1};
                int index = 0;
                if (next0 != -1) newStates[index++] = next0;
                if (next1 != -1) newStates[index++] = next1;
                if (next2 != -1) newStates[index++] = next2;
                current = newStates;
            }

            boolean accepted = false;
            for (int state : current) {
                if (state == 2) {
                    accepted = true;
                    break;
                }
            }

            if (accepted)
                System.out.println("Accepted");
            else
                System.out.println("Rejected");
        }
    }
}
