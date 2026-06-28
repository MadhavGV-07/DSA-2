public class FenwickTree {

    int[] bit;
    int n;

    FenwickTree(int n) {
        this.n = n;
        bit = new int[n + 1];
    }

    void update(int index,
                int value) {

        while(index <= n) {

            bit[index] += value;

            index +=
                    index & (-index);
        }
    }

    int prefixSum(int index) {

        int sum = 0;

        while(index > 0) {

            sum += bit[index];

            index -=
                    index & (-index);
        }

        return sum;
    }

    int rangeSum(int left,
                 int right) {

        return prefixSum(right)
                - prefixSum(left - 1);
    }

    public static void main(String[] args) {

        int spend[] =
        {0,1200,800,0,2400,1500,
         600,0,0,3500,0,1100,
         950,700,0};

        FenwickTree ft =
                new FenwickTree(14);

        for(int i=1;i<spend.length;i++) {

            ft.update(i, spend[i]);
        }

        System.out.println(
                "Prefix Sum(12) = "
                        + ft.prefixSum(12));

        System.out.println(
                "Prefix Sum(4) = "
                        + ft.prefixSum(4));

        System.out.println(
                "Range Sum(5-12) = "
                        + ft.rangeSum(5,12));
    }
}