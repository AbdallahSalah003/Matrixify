public class Matrix {
    protected  int N;
    protected int[][] matrix;
    Matrix(int dim) {
        this.N = dim;
        this.matrix = new int[N][N];
    }
    public boolean SetNumbers(int[] input) {
        if(input.length < this.N*this.N) {
            return false;
        }
        int ind = 0;
        for(int i=0; i< this.N; ++i) {
            for(int j=0; j< this.N; ++j) {
                matrix[i][j] = input[ind++];
            }
        }
        return true;
    }
    public void Transpose() {
        int[][] tmp=this.matrix;
        this.matrix=new int[N][N];
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                matrix[i][j]=tmp[j][i];
            }
        }
    }
    public String[] formatMatrix() {
        String[] ret = new String[this.N];
        for(int i=0; i<this.N; ++i) {
            StringBuilder ss = new StringBuilder();
            for(int j=0; j<this.N; ++j) {
                ss.append(matrix[i][j]+" ");
            }
            ret[i]=ss.toString();
        }
        return ret;
    }
}
