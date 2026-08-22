class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices

        for (int currIdx = 0; currIdx < n; currIdx++) {
            // Check if the current temperature is warmer than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[currIdx] > temperatures[stack.peek()]) {
                int prevIdx = stack.pop();
                answer[prevIdx] = currIdx - prevIdx;
            }
            stack.push(currIdx);
        }
        return answer;
    }
}