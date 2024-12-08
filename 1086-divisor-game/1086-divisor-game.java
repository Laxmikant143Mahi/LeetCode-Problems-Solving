class Solution {
    public boolean divisorGame(int n) {
        // In the divisor game, the player who starts with an even number wins.
        // This is because they can always subtract 1 (an optimal move),
        // giving the other player an odd number. Odd numbers always have odd divisors (except 1),
        // so the other player can only return an even number back.
        // The starting player can continue this strategy until they reach the number 2 and win the game.
        // If the starting number is odd, the starting player loses because they can only make
        // the number even for the other player, who will then start using the winning strategy.
        return n % 2 == 0;
    }
}