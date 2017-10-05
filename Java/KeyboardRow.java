// 500. Keyboard Row
// Using HashMap
class Solution {
    public String[] findWords(String[] words) {
        int len = words.length;
        
        if (len < 1) {
            return words;
        }
        
        Map<Character, Integer> rowMap = new HashMap<>();
        initialMap(rowMap);
        
        // Result list
        List<String> result = new ArrayList<>();
        
        for(String word : words) {
            
            // Char array for each word
            char[] w = word.toCharArray();
            // Its mapping
            int r = rowMap.get( Character.toUpperCase(w[0]) );
            // Flag for the word
            boolean flag = true;
            
            for(char c : w) {
                if (rowMap.get( Character.toUpperCase(c) ) != r) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    // Create HashMap for Characters with Row Number
    private void initialMap(Map<Character, Integer> map) {
        // Row 1
        map.put('Q', 1);
        map.put('W', 1);
        map.put('E', 1);
        map.put('R', 1);
        map.put('T', 1);
        map.put('Y', 1);
        map.put('U', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('P', 1);
        
        // Row 2
        map.put('A', 2);
        map.put('S', 2);
        map.put('D', 2);
        map.put('F', 2);
        map.put('G', 2);
        map.put('H', 2);
        map.put('J', 2);
        map.put('K', 2);
        map.put('L', 2);
        
        // Row 3
        map.put('Z', 3);
        map.put('X', 3);
        map.put('C', 3);
        map.put('V', 3);
        map.put('B', 3);
        map.put('N', 3);
        map.put('M', 3);    
    }
}
