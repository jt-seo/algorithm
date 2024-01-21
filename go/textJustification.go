func packString(words []string, strWidth, maxWidth int) string {
	spaceCount := maxWidth - strWidth
	wordCount := len(words)

	var spaceCountPerWord int
	var remainSpaces int
	if wordCount <= 1 {
		spaceCountPerWord = 0
		remainSpaces = spaceCount
	} else {
		spaceCountPerWord = spaceCount / (wordCount - 1)
		remainSpaces = spaceCount % (wordCount - 1)
	}

	result := ""
	for idx, word := range words {
		result += word

		if idx < wordCount-1 {
			for i := 0; i < spaceCountPerWord; i++ {
				result += " "
			}
			if remainSpaces > 0 {
				result += " "
				remainSpaces -= 1
			}
		}
	}
	if remainSpaces > 0 {
		for j := 0; j < remainSpaces; j++ {
			result += " "
		}
	}
	fmt.Printf("in: %v, inLen: %d, out: %s, outLen: %d\n", words, strWidth, result, len(result))
	return result
}

func leftPackString(words []string, strWidth, maxWidth int) string {
	wordCount := len(words)
	remainSpaces := maxWidth - strWidth - (wordCount - 1)

	result := ""
	for idx, word := range words {
		result += word

		if idx < wordCount-1 {
			result += " "
		}
	}
	if remainSpaces > 0 {
		for j := 0; j < remainSpaces; j++ {
			result += " "
		}
	}
	fmt.Printf("lpack: in: %v, inLen: %d, out: %s, outLen: %d\n", words, strWidth, result, len(result))
	return result
}

func fullJustify(words []string, maxWidth int) []string {
	strWidth := 0
	strToPack := make([]string, 0)
	result := make([]string, 0)
	for i := 0; i < len(words); i++ {
		w := len(words[i])
		if strWidth+w+len(strToPack) <= maxWidth {
			strWidth += w // pack at next stage
			strToPack = append(strToPack, words[i])
		} else {
			result = append(result, packString(strToPack, strWidth, maxWidth))
			strToPack = strToPack[:0] // clear slice
			strToPack = append(strToPack, words[i])
			strWidth = w
		}
	}
	if len(strToPack) > 0 {
		result = append(result, leftPackString(strToPack, strWidth, maxWidth))
	}

	return result
}