public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Square head = new Square(0, 0);
        Square pre = head;
        for (int i = 0; i < height.length; i++) {
            Square s = new Square(height[i], 1);
            s.left = pre;
            pre.right = s;
            pre = s;
        }
        pre.right = new Square(0, 0);
        pre.right.left = pre;
        
        int ret = 0;
        for (pre = head.right; pre.right != null; ) {
            if (pre.left != null && pre.height >= pre.right.height && pre.height >= pre.left.height) {
                ret = Math.max(pre.height * pre.width, ret);
                if (pre.right.height > pre.left.height) {
                    ret = Math.max(pre.right.height * (pre.width + pre.right.width), ret);
                    pre = Square.combine(pre, pre.right);
                } else if (pre.right.height < pre.left.height) {
                	ret = Math.max(pre.left.height * (pre.width + pre.left.width), ret);
                    pre = Square.combine(pre.left, pre);
                } else {
                	pre = Square.combine(Square.combine(pre.left, pre), pre.right);
                }
            } else {
                pre = pre.right;
            }
        }
        return ret;
    }
}

class Square {
    int height;
    int width;
    Square left;
    Square right;
    
    Square(int h, int w) {
        height = h;
        width = w;
    }
    
    public static Square combine(Square s1, Square s2) {
        Square s = new Square(Math.min(s1.height, s2.height), s1.width + s2.width);
        if (s1.left != null) {
            s1.left.right = s;
        }
        s.left = s1.left;
        if (s2.right != null) {
            s2.right.left = s;       
        }
        s.right = s2.right;
        return s;
    }
}