class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;

        // Count the frequency of each card
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Find the GCD of all frequencies
        int gcd = -1;
        for (int count : map.values()) {
            if (gcd == -1) {
                gcd = count; // Initialize GCD
            } else {
                gcd = findGCD(gcd, count);
            }
        }

        // The GCD must be greater than 1
        return gcd > 1;
    }

    // Helper method to find the GCD of two numbers
    private int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }
}
