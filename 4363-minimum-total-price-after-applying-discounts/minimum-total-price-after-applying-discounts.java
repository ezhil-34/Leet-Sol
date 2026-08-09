class Solution {
    public double minPrice(int[] prices, int[] discounts) {
            Arrays.sort(prices);
            Arrays.sort(discounts);

            double total = 0;

            int i = prices.length - 1 ;
            int j = discounts.length-1;

            while(i>=0 && j>=0){
                double price = (double) prices[i] * (100 - discounts[j]) /100;

                total +=price;

                i--;

                j--;
            }

            while(i>=0){
                total +=prices[i];
                i--;
            }

        return total;
    }
}