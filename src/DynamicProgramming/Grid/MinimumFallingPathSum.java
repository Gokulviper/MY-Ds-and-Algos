package DynamicProgramming.Grid;

class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][]nums={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(nums));
    }

        public static int minFallingPathSum(int[][] matrix) {

            int row = matrix.length, col = matrix[0].length;
            int result = Integer.MAX_VALUE;

            for(int i = 0; i < col; i++)
                result = Math.min(result, solve(row - 1, i, matrix));

            return result;
        }

        private static int solve(int row, int col, int[][] matrix){

            if(col < 0 || col >= matrix[row].length) return Integer.MAX_VALUE;

            if(row == 0) return matrix[0][col];

            int up = solve(row - 1, col, matrix);
            int left = solve(row - 1, col - 1, matrix);
            int right = solve(row - 1, col + 1, matrix);

            return Math.min(Math.min(left, right), up) + matrix[row][col];

        }
    }