package algorithm

import (
	"testing"
)

func TestCoin(t *testing.T) {
	t.Run("test coin", func(t *testing.T) {
		coins := []int{2, 3, 5, 10, 500, 1000}
		amount := 20
		count := calcCoinGroupCount(coins, amount)
		t.Logf("count: %d\n", count)
	})
}
