class Delivery {

    int over;
    int ball;

    Delivery(int over, int ball) {
        this.over = over;
        this.ball = ball;
    }
}

public class RadixSort {

    static void countingSortBall(Delivery arr[]) {

        int n = arr.length;
        Delivery output[] = new Delivery[n];
        int count[] = new int[7];

        for (int i = 0; i < n; i++)
            count[arr[i].ball]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i].ball] - 1] = arr[i];
            count[arr[i].ball]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void countingSortOver(Delivery arr[]) {

        int n = arr.length;
        Delivery output[] = new Delivery[n];
        int count[] = new int[51];

        for (int i = 0; i < n; i++)
            count[arr[i].over]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i].over] - 1] = arr[i];
            count[arr[i].over]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void printArray(Delivery arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print("(" + arr[i].over + "," + arr[i].ball + ") ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Delivery arr[] = {
                new Delivery(2,4),
                new Delivery(1,1),
                new Delivery(3,6),
                new Delivery(1,5),
                new Delivery(2,2),
                new Delivery(3,1),
                new Delivery(1,3),
                new Delivery(2,4),
                new Delivery(3,4),
                new Delivery(1,2)
        };

        System.out.println("Original Array:");
        printArray(arr);

        countingSortBall(arr);

        System.out.println("\nAfter Sorting by Ball:");
        printArray(arr);

        countingSortOver(arr);

        System.out.println("\nFinal Sorted Array:");
        printArray(arr);
    }
}