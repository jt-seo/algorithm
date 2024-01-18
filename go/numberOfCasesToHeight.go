package algorithm

import "fmt"

func climb(curStep, totalCase, height int, cache map[int]int) int {
	if curStep == height {
		return totalCase + 1
	} else if curStep > height {
		return totalCase
	}

	step1 := cache[curStep+1]
	if step1 == 0 {
		step1 = climb(curStep+1, totalCase, height, cache)
	}
	step2 := cache[curStep+2]
	if step2 == 0 {
		step2 = climb(curStep+2, totalCase, height, cache)
	}

	cache[curStep] = step1 + step2

	return step1 + step2
}

func climbStairs(n int) int {
	cache := make(map[int]int)
	stepsFrom1 := climb(1, 0, n, cache)
	stepsFrom2 := climb(2, 0, n, cache)
	fmt.Printf("1: %d, 2: %d\n", stepsFrom1, stepsFrom2)
	return stepsFrom1 + stepsFrom2

}
