// Trapping Rain Water
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int LeftMax = 0;
        int RightMax = 0;
        int result = 0;
        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] >= LeftMax) {
                    LeftMax = height[left];
                }
                else {
                    result = result + LeftMax - height[left];
                }
                left++;
            }
            else {
                if(height[right] >= RightMax) {
                    RightMax = height[right];
                }
                else {
                    result = result + RightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }
}
               