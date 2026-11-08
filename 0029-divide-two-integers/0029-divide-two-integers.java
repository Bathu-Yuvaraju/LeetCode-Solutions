class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to long and make them positive to avoid overflow during absolute conversion
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {
            long tempDvs = dvs;
            long multiple = 1;

            while (dvd >= (tempDvs << 1)) {
                tempDvs <<= 1;
                multiple <<= 1;
            }

            dvd -= tempDvs;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}