class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[] arr = new int[m*n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                int sum=0;
                if ((i+1)<m) {
                    sum+=board[i+1][j];
                    if ((j+1)<n) sum+=board[i+1][j+1];
                    if ((j-1)>=0) sum+=board[i+1][j-1];
                }
                if ((i-1)>=0) {
                    sum+=board[i-1][j];
                    if ((j+1)<n) sum+=board[i-1][j+1];
                    if ((j-1)>=0) sum+=board[i-1][j-1];
                }
                if ((j-1)>=0) sum+=board[i][j-1];
                if ((j+1)<n) sum+=board[i][j+1];
                //System.out.println(n*i+j);
                if ((board[i][j]==1) && (sum<2 ||sum>3)) arr[n*i+j]=-1;
                else if ((board[i][j]==0) && (sum==3)) arr[n*i+j]=1;
            }
        }
        for (int k=0;k<arr.length;k++) {
            if (arr[k]==-1 || arr[k]==1) {
                board[k/n][k%n]+=arr[k];
            }
        }
    }
}
