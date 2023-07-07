
public class Practice5 {
    public static int solution(int[] height) {
        //내코드
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                int width= j-i;
//                int hei= height[i]>height[j] ? height[j]:height[i];
//                if(max < hei*width)
//                    max = hei*width;
//            }
//        }
//        return max;
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while(left <right){
            int x = right-left;
            int y = height[left] < height[right] ? height[left] : height[right];
            int curArea = x * y;
            max= max < curArea?curArea:max;

            if(height[left] < height[right])
                left++;
            else right--;
        }
        return max;
    }

    public static void main(String[] args) {
        // Test code
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));

        height = new int[]{5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));

    }
}
