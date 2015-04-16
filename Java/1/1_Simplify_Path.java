public class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        List<String> list = new ArrayList<>();
        for (String s : parts) {
            if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                list.add(s);
            } else if (s.equals("..") && !list.isEmpty()) {
                list.remove(list.size() - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/").append(s);
        }
        return list.isEmpty() ? "/" : sb.toString();
    }
}