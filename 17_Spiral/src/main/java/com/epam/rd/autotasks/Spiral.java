package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int m, int n) {
        int[][] a = new int[m][n];
        // Initialize value to be filled in matrix
        int val = 1;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index */
        int k = 0, l = 0;
        while (k < m && l < n) {
            /* Print the first row from the remaining
          rows */
            for (int i = l; i < n; ++i) {
                a[k][i] = val++;
            }

            k++;

            /* Print the last column from the remaining
          columns */
            for (int i = k; i < m; ++i) {
                a[i][n - 1] = val++;
            }
            n--;

            /* Print the last row from the remaining
           rows */
            if (k < m) {
                for (int i = n - 1; i >= l; --i) {
                    a[m - 1][i] = val++;
                }
                m--;
            }

            /* Print the first column from the remaining
           columns */
            if (l < n) {
                for (int i = m - 1; i >= k; --i) {
                    a[i][l] = val++;
                }
                l++;
            }
        }
        return a;
    }
}
