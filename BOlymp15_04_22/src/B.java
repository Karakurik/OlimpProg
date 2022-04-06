import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    static char nextChar() {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = nextInt();
        }
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = gcd(arrA[i], arrB[j]);
            }
        }
        float[][] arrf = new float[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrf[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            float maxim = arrf[i][0];
            for (int j = 1; j < n; j++) {
                maxim = Math.max(maxim, arr[i][j]);
            }
            for (int j = 0; j < n; j++) {
                arrf[i][j] = maxim-arrf[i][j];
            }
        }

        Hungarian h = new Hungarian(arrf);
        int[][] answers = h.execute();
        int ans = 0;
        for (int j = 0; j < answers.length; j++) {
            ans += arr[answers[j][0]][answers[j][1]];
        }
        pw.println(ans);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static class Hungarian {

        private int numRows;
        private int numCols;

        private boolean[][] primes;
        private boolean[][] stars;
        private boolean[] rowsCovered;
        private boolean[] colsCovered;
        private float[][] costs;

        public Hungarian(float theCosts[][]) {
            costs = theCosts;
            numRows = costs.length;
            numCols = costs[0].length;

            primes = new boolean[numRows][numCols];
            stars = new boolean[numRows][numCols];

            // Инициализация массивов с покрытием строк/столбцов
            rowsCovered = new boolean[numRows];
            colsCovered = new boolean[numCols];
            for (int i = 0; i < numRows; i++) {
                rowsCovered[i] = false;
            }
            for (int j = 0; j < numCols; j++) {
                colsCovered[j] = false;
            }
            // Инициализация матриц
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    primes[i][j] = false;
                    stars[i][j] = false;
                }
            }
        }

        public int[][] execute() {
            subtractRowColMins();

            this.findStars(); // O(n^2)
            this.resetCovered(); // O(n);
            this.coverStarredZeroCols(); // O(n^2)

            while (!allColsCovered()) {
                int[] primedLocation = this.primeUncoveredZero(); // O(n^2)

                // It's possible that we couldn't find a zero to prime, so we have to induce some zeros so we can find one to prime
                if (primedLocation[0] == -1) {
                    this.minUncoveredRowsCols(); // O(n^2)
                    primedLocation = this.primeUncoveredZero(); // O(n^2)
                }

                // is there a starred 0 in the primed zeros row?
                int primedRow = primedLocation[0];
                int starCol = this.findStarColInRow(primedRow);
                if (starCol != -1) {
                    // cover ther row of the primedLocation and uncover the star column
                    rowsCovered[primedRow] = true;
                    colsCovered[starCol] = false;
                } else { // otherwise we need to find an augmenting path and start over.
                    this.augmentPathStartingAtPrime(primedLocation);
                    this.resetCovered();
                    this.resetPrimes();
                    this.coverStarredZeroCols();
                }
            }

            return this.starsToAssignments(); // O(n^2)

        }

        /*
         * the starred 0's in each column are the assignments.
         * O(n^2)
         */
        public int[][] starsToAssignments() {
            int[][] toRet = new int[numCols][];
            for (int j = 0; j < numCols; j++) {
                toRet[j] = new int[] {
                        this.findStarRowInCol(j), j
                }; // O(n)
            }
            return toRet;
        }

        /*
         * resets prime information
         */
        public void resetPrimes() {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    primes[i][j] = false;
                }
            }
        }


        /*
         * resets covered information, O(n)
         */
        public void resetCovered() {
            for (int i = 0; i < numRows; i++) {
                rowsCovered[i] = false;
            }
            for (int j = 0; j < numCols; j++) {
                colsCovered[j] = false;
            }
        }

        /*
         * get the first zero in each column, star it if there isn't already a star in that row
         * cover the row and column of the star made, and continue to the next column
         * O(n^2)
         */
        public void findStars() {
            boolean[] rowStars = new boolean[numRows];
            boolean[] colStars = new boolean[numCols];

            for (int i = 0; i < numRows; i++) {
                rowStars[i] = false;
            }
            for (int j = 0; j < numCols; j++) {
                colStars[j] = false;
            }

            for (int j = 0; j < numCols; j++) {
                for (int i = 0; i < numRows; i++) {
                    if (costs[i][j] == 0 && !rowStars[i] && !colStars[j]) {
                        stars[i][j] = true;
                        rowStars[i] = true;
                        colStars[j] = true;
                        break;
                    }
                }
            }
        }

        /*
         * Finds the minimum uncovered value, and adds it to all the covered rows then
         * subtracts it from all the uncovered columns. This results in a cost matrix with
         * at least one more zero.
         */
        private void minUncoveredRowsCols() {
            // find min uncovered value
            float minUncovered = Float.MAX_VALUE;
            for (int i = 0; i < numRows; i++) {
                if (!rowsCovered[i]) {
                    for (int j = 0; j < numCols; j++) {
                        if (!colsCovered[j]) {
                            if (costs[i][j] < minUncovered) {
                                minUncovered = costs[i][j];
                            }
                        }
                    }
                }
            }

            // add that value to all the COVERED rows.
            for (int i = 0; i < numRows; i++) {
                if (rowsCovered[i]) {
                    for (int j = 0; j < numCols; j++) {
                        costs[i][j] = costs[i][j] + minUncovered;

                    }
                }
            }

            // subtract that value from all the UNcovered columns
            for (int j = 0; j < numCols; j++) {
                if (!colsCovered[j]) {
                    for (int i = 0; i < numRows; i++) {
                        costs[i][j] = costs[i][j] - minUncovered;
                    }
                }
            }
        }

        /*
         * Finds an uncovered zero, primes it, and returns an array
         * describing the row and column of the newly primed zero.
         * If no uncovered zero could be found, returns -1 in the indices.
         * O(n^2)
         */
        private int[] primeUncoveredZero() {
            int[] location = new int[2];

            for (int i = 0; i < numRows; i++) {
                if (!rowsCovered[i]) {
                    for (int j = 0; j < numCols; j++) {
                        if (!colsCovered[j]) {
                            if (costs[i][j] == 0) {
                                primes[i][j] = true;
                                location[0] = i;
                                location[1] = j;
                                return location;
                            }
                        }
                    }
                }
            }

            location[0] = -1;
            location[1] = -1;
            return location;
        }

        /*
         * Starting at a given primed location[0=row,1=col], we find an augmenting path
         * consisting of a primed , starred , primed , ..., primed. (note that it begins and ends with a prime)
         * We do this by starting at the location, going to a starred zero in the same column, then going to a primed zero in
         * the same row, etc, until we get to a prime with no star in the column.
         * O(n^2)
         */
        private void augmentPathStartingAtPrime(int[] location) {
            // Make the arraylists sufficiently large to begin with
            ArrayList < int[] > primeLocations = new ArrayList < int[] > (numRows + numCols);
            ArrayList< int[] > starLocations = new ArrayList < int[] > (numRows + numCols);
            primeLocations.add(location);

            int currentRow = location[0];
            int currentCol = location[1];
            while (true) { // add stars and primes in pairs
                int starRow = findStarRowInCol(currentCol);
                // at some point we won't be able to find a star. if this is the case, break.
                if (starRow == -1) {
                    break;
                }
                int[] starLocation = new int[] {
                        starRow, currentCol
                };
                starLocations.add(starLocation);
                currentRow = starRow;

                int primeCol = findPrimeColInRow(currentRow);
                int[] primeLocation = new int[] {
                        currentRow, primeCol
                };
                primeLocations.add(primeLocation);
                currentCol = primeCol;
            }

            unStarLocations(starLocations);
            starLocations(primeLocations);
        }


        /*
         * Given an arraylist of  locations, star them
         */
        private void starLocations(ArrayList < int[] > locations) {
            for (int k = 0; k < locations.size(); k++) {
                int[] location = locations.get(k);
                int row = location[0];
                int col = location[1];
                stars[row][col] = true;
            }
        }

        /*
         * Given an arraylist of starred locations, unstar them
         */
        private void unStarLocations(ArrayList < int[] > starLocations) {
            for (int k = 0; k < starLocations.size(); k++) {
                int[] starLocation = starLocations.get(k);
                int row = starLocation[0];
                int col = starLocation[1];
                stars[row][col] = false;
            }
        }


        /*
         * Given a row index, finds a column with a prime. returns -1 if this isn't possible.
         */
        private int findPrimeColInRow(int theRow) {
            for (int j = 0; j < numCols; j++) {
                if (primes[theRow][j]) {
                    return j;
                }
            }
            return -1;
        }




        /*
         * Given a column index, finds a row with a star. returns -1 if this isn't possible.
         */
        public int findStarRowInCol(int theCol) {
            for (int i = 0; i < numRows; i++) {
                if (stars[i][theCol]) {
                    return i;
                }
            }
            return -1;
        }


        public int findStarColInRow(int theRow) {
            for (int j = 0; j < numCols; j++) {
                if (stars[theRow][j]) {
                    return j;
                }
            }
            return -1;
        }

        // looks at the colsCovered array, and returns true if all entries are true, false otherwise
        private boolean allColsCovered() {
            for (int j = 0; j < numCols; j++) {
                if (!colsCovered[j]) {
                    return false;
                }
            }
            return true;
        }

        /*
         * sets the columns covered if they contain starred zeros
         * O(n^2)
         */
        private void coverStarredZeroCols() {
            for (int j = 0; j < numCols; j++) {
                colsCovered[j] = false;
                for (int i = 0; i < numRows; i++) {
                    if (stars[i][j]) {
                        colsCovered[j] = true;
                        break; // break inner loop to save a bit of time
                    }
                }
            }
        }

        private void subtractRowColMins() {
            for (int i = 0; i < numRows; i++) { //for each row
                float rowMin = Float.MAX_VALUE;
                for (int j = 0; j < numCols; j++) { // grab the smallest element in that row
                    if (costs[i][j] < rowMin) {
                        rowMin = costs[i][j];
                    }
                }
                for (int j = 0; j < numCols; j++) { // subtract that from each element
                    costs[i][j] = costs[i][j] - rowMin;
                }
            }

            for (int j = 0; j < numCols; j++) { // for each col
                float colMin = Float.MAX_VALUE;
                for (int i = 0; i < numRows; i++) { // grab the smallest element in that column
                    if (costs[i][j] < colMin) {
                        colMin = costs[i][j];
                    }
                }
                for (int i = 0; i < numRows; i++) { // subtract that from each element
                    costs[i][j] = costs[i][j] - colMin;
                }
            }
        }

    }
}
