class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0; // Count of $5 bills
        int ten = 0;  // Count of $10 bills

        // Iterate through each bill in the bills array
        for (int bill : bills) {
            if (bill == 5) {
                five++; // Customer pays with $5, increase $5 count
            } else if (bill == 10) {
                if (five == 0) {
                    return false; // No $5 bill to give as change
                }
                five--; // Give one $5 as change
                ten++;  // Increase $10 count
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--; // Use one $10 bill for change
                    five--; // Use one $5 bill for change
                } else if (five >= 3) {
                    five -= 3; // Use three $5 bills for change
                } else {
                    return false; // Not enough change available
                }
            }
        }
        return true; // Successfully provided change for all customers
    }
}
