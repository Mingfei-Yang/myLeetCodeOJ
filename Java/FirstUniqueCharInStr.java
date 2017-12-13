// 387. First Unique Character in String
// HashMap method (Slow)
class Solution {
    public int firstUniqChar(String s) {
        
        if (s.length() == 0) {
            return -1;
        }
        
        // Hash Table for {char, int}
        // char is the currently unique character, int is its index
        Map<Character, Integer> table = new HashMap();
        
        // Duplicate character list
        List<Character> dupList = new ArrayList();
        
        for(int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);  // Current Character
            // If current character is already in duplicate char list, continue
            if (dupList.contains(curChar)) {
                continue;
            }
            // If current character is already in HashTable
            // Remove it from HashTable and Add it into duplicate list
            else if (table.containsKey(curChar)) {
                table.remove(curChar);
                dupList.add(curChar);
            }
            // If current char neither in dupList nor in HashTable
            // Put it in HashTable
            else {
                table.put(curChar, i);
            }
        }
        
        // If HashMap is empty, return -1
        if (table.isEmpty()) {
            return -1;
        }
        
        // Get all values and find the minimum
        Object[] values = table.values().toArray();
        Arrays.sort(values);
        
        return (int)values[0];
    }
}
