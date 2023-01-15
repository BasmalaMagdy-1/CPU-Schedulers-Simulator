import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("__ Preemptive Priority Scheduling __");
        System.out.print("Enter Number of Process: ");
        Scanner sc = new Scanner(System.in);
        int numberOfProcess = sc.nextInt();
        String process[] = new String[numberOfProcess];
        int p = 1;
        for (int i = 0; i < numberOfProcess; i++) {
            process[i] = "P" + p;
            p++;
        }
        System.out.println(Arrays.toString(process));
        System.out.print("Enter Burst Time for " + numberOfProcess + " process: ");
        int burstTime[] = new int[numberOfProcess];
        for (int i = 0; i < numberOfProcess; i++) {
            burstTime[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(burstTime));
        System.out.print("Enter Priority for " + numberOfProcess + " process: ");
        int priority[] = new int[numberOfProcess + 1];
        for (int i = 0; i < numberOfProcess; i++) {
            priority[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(priority));
        System.out.print("Enter Arrival Time for " + numberOfProcess + " process: ");
        int arrivalt[] = new int[numberOfProcess];
        for (int i = 0; i < numberOfProcess; i++) {
            arrivalt[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arrivalt));

        int time, end, smallest, x, count = 0, max = 0;
        int endA[] = new int[numberOfProcess];
        int TAT[] = new int[numberOfProcess];
        int waitingTime[] = new int[numberOfProcess];

        for (x = 0; x < numberOfProcess; x++) {
            endA[x] = burstTime[x];
        }

        priority[numberOfProcess] = 999;
        System.out.println("Process in Order");

        for (time = 0; count != numberOfProcess; time++) {
            smallest = numberOfProcess;

            for (x = 0; x < numberOfProcess; x++) {
                if (arrivalt[x] <= time && priority[x] < priority[smallest] && burstTime[x] > 0) {
                    smallest = x;
                }

            }
            burstTime[smallest]--;
            if (burstTime[smallest] == 0) {
                count++;
                end = time + 1;
                waitingTime[smallest] = end - arrivalt[smallest] - endA[smallest];
                TAT[smallest] = end - arrivalt[smallest];
            }
            System.out.print(process[smallest] + " ");

            // starvation problem
            for (int i = 0; i < numberOfProcess; i++) {
                if (max < priority[i]) {
                    max = priority[i];
                }
            }
            priority[max]--;
        }

        int totalWT = 0;
        int totalTAT = 0;
        double avgWT;
        double avgTAT;
        System.out.println("\nProcess      WaitTime        TurnAroundTime");
        for (int k = 0; k < numberOfProcess; k++) {
            System.out.println(
                    process[k] + "             " + waitingTime[k] + "              " + (TAT[k]));
            totalTAT += (waitingTime[k] + burstTime[k]);
            totalWT += waitingTime[k];
        }
        avgWT = totalWT / (double) numberOfProcess;
        avgTAT = totalTAT / (double) numberOfProcess;
        System.out.println("\n Average Wating Time: " + avgWT);
        System.out.println(" Average Turn Around Time: " + avgTAT);
    }
}
