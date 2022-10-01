package backtracking;

public class PartitionK {

    static boolean isKPartitionPossibleRec(int arr[], int subsetSum[],
            boolean taken[], int subset, int K, int N, int curIdx, int limitIdx) {

        if (subsetSum[curIdx] == subset) {
            if (curIdx == K - 2)
                return true;

            return isKPartitionPossibleRec(arr, subsetSum, taken, subset,
                    K, N, curIdx + 1, N - 1);
        }

        // Start from limitIdx and include elements into current partition
        for (int i = limitIdx; i >= 0; i--) {

            if (taken[i])
                continue;

            int tmp = subsetSum[curIdx] + arr[i];

            // If temp is less than subset then only include the element
            // and call recursively
            if (tmp <= subset) {

                taken[i] = true;
                subsetSum[curIdx] += arr[i];
                boolean nxt = isKPartitionPossibleRec(arr, subsetSum, taken,
                        subset, K, N, curIdx, i - 1);

                // After recursive call unmark the element and remove from
                // subsetition sum
                taken[i] = false;
                subsetSum[curIdx] -= arr[i];
                if (nxt)
                    return true;
            }
        }
        return false;
    }

    static boolean isKPartitionPossible(int arr[], int N, int K) {

        if (K == 1)
            return true;

        if (N < K)
            return false;

        // If array sum is not divisible by K then not possible
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += arr[i];
        if (sum % K != 0)
            return false;

        // The sum of each subset should be subset = sum / K
        int subset = sum / K;
        int[] subsetSum = new int[K];
        boolean[] taken = new boolean[N];

        // Initialize sum of each subset from 0
        for (int i = 0; i < K; i++)
            subsetSum[i] = 0;

        // Mark all elements as not taken
        for (int i = 0; i < N; i++)
            taken[i] = false;

        // Initialize first subset sum as last element of
        // array and mark that as taken
        subsetSum[0] = arr[N - 1];
        taken[N - 1] = true;

        // Call recursive method to check K-substitution condition
        return isKPartitionPossibleRec(arr, subsetSum, taken,
                subset, K, N, 0, N - 1);
    }

    // Time Complexity - O(2^(N * K)), Auxillary Space - O(N)
    public static void main(String[] args) {

        int arr[] = { 2, 1, 4, 5, 3, 3 };
        int N = arr.length;
        int K = 3;

        if (isKPartitionPossible(arr, N, K))
            System.out.println("Partitions into equal sum is possible.");
        else
            System.out.println("Partitions into equal sum is not possible.");
    }
}
