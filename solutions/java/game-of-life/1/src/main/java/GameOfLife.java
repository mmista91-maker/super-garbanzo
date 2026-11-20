class GameOfLife {
    public int[][] tick(int[][] matrix){

        if (matrix.length == 0 || matrix[0].length == 0){
            return new int[0][0];
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] next = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int liveNeighbors = countLiveNeighbors(matrix, r, c);
                next[r][c] = nextState(matrix[r][c], liveNeighbors);
            }
        }
        return next;
    }

    private int nextState(int current, int liveNeighbors) {
        if (current == 1) {
            return (liveNeighbors == 2 || liveNeighbors == 3) ? 1 : 0;
        }
        return (liveNeighbors == 3) ? 1 : 0;
    }


    int countLiveNeighbors(int[][] matrix, int row, int col) {
        int live = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) {
                    continue;
                }
                int nr = row + dr;
                int nc = col + dc;
                if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[nr].length) {
                    live += matrix[nr][nc];
                }
            }
        }
        return live;
    }
}
