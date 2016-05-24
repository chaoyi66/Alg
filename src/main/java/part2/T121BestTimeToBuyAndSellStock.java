package part2;

public class T121BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 1, 2, 3, 2, 8 }));
	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int min = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				if (prices[i] - min > profit) {
					profit = prices[i] - min;
				}
			}
		}

		return profit;

	}
	
	public int maxProfit1(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

}
