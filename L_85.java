class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prefix = new int[n];
        Stack<Integer> s = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            s = new Stack<>();
            for(int j = 0; j <= n; j++){
                if(j < n){
                    if(matrix[i][j] == '0'){
                        prefix[j] = 0;
                    }else{
                        prefix[j]++;
                    }
                }
                int target = j < n ? prefix[j] : 0;
                while(!s.isEmpty() && prefix[s.peek()] >= target){
                    int cur = s.pop();
                    int height = prefix[cur];
                    int left = s.isEmpty() ? -1 : s.peek();
                    max = Math.max(max, height * (j - left - 1));
                }
                s.push(j);
            }
        }
        return max;
        
    }
}

