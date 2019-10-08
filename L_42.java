class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        
        int count=0, level=0;
        int i=0, j=height.length-1;
        
        while(i<j)
        {
            int lower= height[height[i]<height[j] ? i++ : j--];
            level = Math.max(lower,level);
            count+=level-lower;
        }
        return count;
    }
}