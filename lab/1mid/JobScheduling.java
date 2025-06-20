import java.util.Scanner;

public class JobScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] slot = new int[11]; // Array size increased by 1 to match C indexing
        int profit = 0;
        int[] p = new int[11];
        int[] d = new int[11];
        int n, i, j, k = 0, t;
        int[] seq = new int[11]; // Array size increased by 1 to match C indexing

        System.out.print("Enter the number of jobs: ");
        n = scanner.nextInt();

        for (i = 1; i <= n; i++) {
            System.out.printf("\nEnter the profit and deadline of job #%d: ", i);
            p[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }

        for (i = 1; i <= n; i++) {
            for (j = i + 1; j <= n; j++) {
                if (p[i] < p[j]) {
                    t = p[i];
                    p[i] = p[j];
                    p[j] = t;
                    t = d[i];
                    d[i] = d[j];
                    d[j] = t;
                }
            }
        }

        for (i = 1; i <= n; i++) {
            for (j = d[i]; j >= 1; j--) {
                if (slot[j] == 0) {
                    slot[j] = i;
                    profit += p[i];
                    break;
                }
            }
        }

        System.out.println("\nSlot assignment Array");
        for (i = 1; i < n; i++)
            System.out.print(slot[i] + " ");

        System.out.println("\nJobs and deadlines Array");
        for (i = 1; i <= n; i++)
            System.out.println(p[i] + " " + d[i]);

        System.out.println("\n\nJOB No   PROFIT  DEADLINE  SLOT ALLOTTED");
        for (i = 1; i <= n; i++) {
            if (slot[i] > 0)
                System.out.printf("\n\n   %d       %d        %d        [%d - %d]", slot[i], p[slot[i]], d[slot[i]], i - 1, i);
        }

        System.out.println("\nTotal Profit=" + profit);
    }
}
