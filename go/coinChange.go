package algorithm

func calcCoinGroupCount(coins []int, amount int) int {
	dp := make([]int, amount+1)
	dp[0] = 1

	for _, coin := range coins {
		for i := coin; i <= amount; i++ {
			dp[i] += dp[i-coin]
		}
	}

	// for idx, num := range dp {
	// 	fmt.Printf("dp[%d]: %d\n", idx, num)
	// }
	return dp[amount]
}
