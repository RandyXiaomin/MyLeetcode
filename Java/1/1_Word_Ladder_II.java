public class Solution {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        HashMap<String, ArrayList<String>> preSet = new HashMap<String, ArrayList<String>>();
        dict.remove(start);
        dict.remove(end);
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        boolean isFound = false;
        while (!queue.isEmpty() && !isFound) {
            Queue<String> temp = new LinkedList<String>();
            while (!queue.isEmpty()) {
                String str = queue.poll();
                char[] charAry = str.toCharArray();
                for (int i = 0; i < str.length(); i++) {
                    char originalChar = charAry[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charAry[i] = c;
                        String newStr = new String(charAry);
                        if (newStr.equals(end)) {
                            isFound = true;
                            ArrayList<ArrayList<String>> sol = getAllPath(str, preSet);
                            for (ArrayList<String> list : sol) {
                                list.add(newStr);
                                ret.add(list);
                            }
                        }
                        if (dict.contains(newStr)) {
                            if (!temp.contains(newStr))
                                temp.add(newStr);
                            if (preSet.containsKey(newStr)) {
                                preSet.get(newStr).add(str);
                            } else {
                                preSet.put(newStr, new ArrayList<String>(Arrays.asList(str)));
                            }
                        }
                    }
                    charAry[i] = originalChar;
                }   
            }
            dict.removeAll(temp);
            queue = temp;
        }
        return ret;
    }
    
    public static ArrayList<ArrayList<String>> getAllPath(String str, HashMap<String, ArrayList<String>> preSet) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if (!preSet.containsKey(str)) {
            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(str));
            ret.add(temp);
            return ret;
        }
        for (String pre : preSet.get(str)) {
            ArrayList<ArrayList<String>> sol = getAllPath(pre, preSet);
            for (ArrayList<String> list : sol) {
                list.add(str);
                ret.add(list);
            }
        }
        return ret;
    }
}