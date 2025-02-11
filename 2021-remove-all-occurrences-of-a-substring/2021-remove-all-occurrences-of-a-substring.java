class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);

        while (sb.indexOf(part) != -1) { // Keep removing while "part" exists
            int index = sb.indexOf(part);
            sb.delete(index, index + part.length());
        }

        return sb.toString();
    }
}
