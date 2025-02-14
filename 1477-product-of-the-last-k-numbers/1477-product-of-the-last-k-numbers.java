class ProductOfNumbers {
    private List<Integer> prefixProducts;  // List to store the prefix products.

    // Constructor initializes the data structure with a single '1'.
    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }

    // Adds a number to the list, handling multiplication and the case when zero is added.
    public void add(int num) {
        if (num == 0) {
            // If the number is zero, the product of all numbers will be zero.
            // Clear the list and start anew with a single '1'.
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            // Multiply the last element by 'num' to get the new product and add it to the list.
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }

    // Returns the product of the last 'k' numbers added to the list.
    public int getProduct(int k) {
        int n = prefixProducts.size();
        // If 'k' is greater than or equal to the size, all the elements include a zero, return 0.
        if (n <= k) {
            return 0;
        } else {
            // The product of the last 'k' numbers is the last element divided by the (n - k -1)th element.
            return prefixProducts.get(n - 1) / prefixProducts.get(n - k - 1);
        }
    }
}