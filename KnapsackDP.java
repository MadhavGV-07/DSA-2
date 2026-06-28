public class KnapsackDP {

    public static void main(String[] args) {

        // Item weights
        int[] weights = {5, 8, 3, 10, 4, 6, 7, 2};

        // Item values
        int[] values = {40, 60, 25, 75, 30, 40, 50, 20};

        // Item names
        String[] items = {"A", "B", "C", "D", "E", "F", "G", "H"};

        int capacity = 24;
        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP Table
        for (int i = 1; i <= n; i++) {

            for (int w = 1; w <= capacity; w++) {

                if (weights[i - 1] <= w) {

                    dp[i][w] = Math.max(
                            values[i - 1] + dp[i - 1][w - weights[i - 1]],
                            dp[i - 1][w]
                    );

                } else {

                    dp[i][w] = dp[i - 1][w];

                }
            }
        }

        System.out.println("Maximum Profit = ₹" + dp[n][capacity]);

        // Backtracking to find selected items
        System.out.println("\nSelected Items:");

        int w = capacity;

        for (int i = n; i > 0 && w > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                System.out.println(
                        items[i - 1] +
                        " (Weight = " + weights[i - 1] +
                        ", Value = ₹" + values[i - 1] + ")"
                );

                w -= weights[i - 1];
            }
        }
    }
}