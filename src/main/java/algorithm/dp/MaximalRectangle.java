package algorithm.dp;

public class MaximalRectangle {
    public static void main(String[] args){
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] a = new char[][]{
                //{1,1,1},{1,1,1},{1,1,0},{1,0,1}
                /*
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
                */
                {'1'}
        };
        System.out.println(maximalRectangle.maximalRectangle(a));
    }
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        if (matrix == null && matrix.length == 0) return ans;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dpr = new int[rows][cols];
        int[][] dpd = new int[rows][cols];
        int[][] dps = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dps[r][c]= Integer.parseInt(String.valueOf(matrix[r][c]));
            }
        }

        // search it by go right or down or slash
        int minEdge = Math.min( rows, cols );
        for(int i = 1; i <= minEdge+1; i++) {
            //right
            for (int r = 0; r < rows; r++) {
                dpr[r][cols-1] = dps[r][cols-1];
                ans = Math.max(dpr[r][cols-1], ans);
                for (int c = cols - 2 ; c>=0; c--) {
                    dpr[r][c] = (dps[r][c] == i*i? Math.max(dpr[r][c+1],dps[r][c+1]) + i : 0);
                    ans = Math.max(dpr[r][c], ans);
                }
            }
            //down
            for (int c = 0; c < cols; c++) {
                dpd[rows-1][c] = dps[rows-1][c];
                ans = Math.max(dpr[rows-1][c], ans);
                for (int r = rows - 2 ; r>=0; r--) {
                    dpd[r][c] = (dps[r][c] == i*i? Math.max(dpd[r+1][c],dps[r+1][c]) + i : 0);
                    ans = Math.max(dpd[r][c], ans);
                }
            }

            //slash
            if(i == minEdge+1) return ans;
            for (int r = 0; r < rows-1; r++) {
                for (int c = 0; c < cols-1; c++) {
                    if (dps[r][c] == i*i && dps[r+1][c] == i*i && dps[r][c+1] == i*i && dps[r+1][c+1] == i*i){
                        dps[r][c] = (i+1)*(i+1);
                        ans = Math.max(dps[r][c], ans);
                    }
                }
            }
        }
        return ans;

    }
}
