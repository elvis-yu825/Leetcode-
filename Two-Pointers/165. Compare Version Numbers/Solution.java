class Solution {
    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int n1 = version1.length(), n2 = version2.length();
        
        //Compare versions
        int i1,i2;
        Pair<Integer,Integer> pair;
        while (p1<n1 || p2<n2) {
            pair = getNextChunk(version1,n1,p1);
            i1 = pair.getKey();
            p1 = pair.getValue();
            
            pair = getNextChunk(version2,n2,p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if (i1 != i2) {
                return i1>i2 ? 1:-1;
            }
        }
        return 0;
        
    }
    public Pair<Integer,Integer> getNextChunk(String version, int n, int p) {
        if (p >n-1)  {
            return new Pair(0,p);
        }
        int i, pEnd = p;
        while (pEnd<n && version.charAt(pEnd) != '.') {
            pEnd++;
        }
        if (pEnd != n-1) {
            i = Integer.parseInt(version.substring(p,pEnd));
        } else {
            i = Integer.parseInt(version.substring(p,n));
        }
        p = pEnd+1;
        return new Pair(i,p);
    }
}
