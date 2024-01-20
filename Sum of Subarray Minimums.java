/**
 * TC : O(n)
 * SC : O(n)
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int res = 0;
        int mod = (int)1e9+7;

        precomputeLeftUsingMonotonicStack(stack, left, arr);
        stack.clear();
        precomputeRightUsingMonotonicStack(stack, right, arr);

        for(int i = 0; i < arr.length; i++) {
            res = (int)(res + (arr[i] * (long)(left[i] * right[i]) % mod) % mod) % mod;
        }
        return res;
    }

    // Precomputing left[] values.
    // left[] values is precomputed using monotonic stack.
    // left[] contains contribution of element in itself and in all elements to its left.
    private void precomputeLeftUsingMonotonicStack(ArrayDeque<Pair> stack, int[] left, int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int count = 1;
            while(!stack.isEmpty() && arr[i] < stack.peek().value) {
                count += stack.peek().count;
                stack.pop();
            }
            stack.push(new Pair(arr[i], count));
            left[i] = count;
        }
    }

    // Precomputing right[] values.
    // right[] values is precomputed using monotonic stack.
    // right[] contains contribution of element in itself and in all elements to its right.
    // In right[], we will consider elements with equal values too.
    private void precomputeRightUsingMonotonicStack(ArrayDeque<Pair> stack, int[] right, int[] arr) {
        for(int i = arr.length - 1; i >= 0; i--) {
            int count = 1;
            while(!stack.isEmpty() && arr[i] <= stack.peek().value) {
                count += stack.peek().count;
                stack.pop();
            }
            stack.push(new Pair(arr[i], count));
            right[i] = count;
        }
    }

    class Pair {
        int value;
        int count;

        Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}