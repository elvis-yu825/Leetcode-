class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int namePointer = 0;
        int typedPointer = 0;
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();
        while (namePointer<nameChar.length && typedPointer<typedChar.length) {
            if (nameChar[namePointer] == typedChar[typedPointer]) {
                namePointer++;
                typedPointer++;
            } else if (typedPointer>=1 && typedChar[typedPointer] == typedChar[typedPointer-1]) {
                typedPointer++;
            } else {
                return false;
            }
        }
        
        //if there is still some characters left unmatched in the origin string, then no match
        if (namePointer != nameChar.length) {
            return false;
        } else {
            //if there are still character left in the typed string
            while (typedPointer<typedChar.length) {
                if (typedChar[typedPointer] != typedChar[typedPointer-1]) {
                    return false;
                }
                typedPointer++;
            }
        }
        return true;
        
    }
}
