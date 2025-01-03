import java.util.HashMap;

class Solution {
    public int numFriendRequests(int[] ages) {
        // Map to keep count of each age
        HashMap<Integer, Integer> ageCount = new HashMap<>();
        for (int age : ages) {
            ageCount.put(age, ageCount.getOrDefault(age, 0) + 1);
        }

        // Variable to hold the total friend requests
        int friendRequests = 0;

        // Iterate through all sender ages in the map
        for (int senderAge : ageCount.keySet()) {
            int senderCount = ageCount.get(senderAge);

            // Iterate through all receiver ages in the map
            for (int receiverAge : ageCount.keySet()) {
                int receiverCount = ageCount.get(receiverAge);

                // Check if the friend request conditions are satisfied
                if (!(receiverAge <= 0.5 * senderAge + 7 || receiverAge > senderAge || (receiverAge > 100 && senderAge < 100))) {
                    // Add the product of the counts of sender and receiver
                    friendRequests += senderCount * receiverCount;

                    // If sender and receiver are the same, subtract self-requests
                    if (senderAge == receiverAge) {
                        friendRequests -= senderCount;
                    }
                }
            }
        }

        return friendRequests;
    }
}
