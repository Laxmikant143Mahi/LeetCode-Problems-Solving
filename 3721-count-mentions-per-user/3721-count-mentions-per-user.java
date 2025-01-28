import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // Sort events by timestamp, with OFFLINE events processed before MESSAGE at the same time
        List<List<String>> sortedEvents = new ArrayList<>(events);
        Collections.sort(sortedEvents, new Comparator<List<String>>() {
            public int compare(List<String> a, List<String> b) {
                int t1 = Integer.parseInt(a.get(1));
                int t2 = Integer.parseInt(b.get(1));
                if (t1 != t2) {
                    return Integer.compare(t1, t2);
                } else {
                    String typeA = a.get(0);
                    String typeB = b.get(0);
                    if (typeA.equals("OFFLINE") && typeB.equals("MESSAGE")) {
                        return -1;
                    } else if (typeA.equals("MESSAGE") && typeB.equals("OFFLINE")) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers]; // Initially all zeros

        for (List<String> event : sortedEvents) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            if (type.equals("OFFLINE")) {
                int userId = Integer.parseInt(event.get(2));
                offlineUntil[userId] = timestamp + 60;
            } else {
                String mentionStr = event.get(2);
                String[] tokens = mentionStr.split(" ");
                for (String token : tokens) {
                    if (token.equals("ALL")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            mentions[i]++;
                        }
                    } else if (token.equals("HERE")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            if (offlineUntil[i] <= timestamp) {
                                mentions[i]++;
                            }
                        }
                    } else if (token.startsWith("id")) {
                        String numStr = token.substring(2);
                        int userId = Integer.parseInt(numStr);
                        if (userId >= 0 && userId < numberOfUsers) {
                            mentions[userId]++;
                        }
                    }
                }
            }
        }

        return mentions;
    }
}