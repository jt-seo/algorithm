// 30. Substring with Concatenation of All Words

// HashMap + Sliding Window
// word 의 length 가 모두 같으므로 0 ~ wordLen -1 의 각각의 index 에서 시작해서 string 끝까지 탐색하면서 
// words 에 있는 단어가 i 인덱스에서 시작하는 문자열에 모두 나오는 지 체크한다.
// map.containsKey(subStr))
// word 가 연속적으로 나와야 하므로 만약 없는 단어나 답 이상의 갯수로 중복된 단어가 나오면 즉시 조건에 맞게 l 을 삭제한다.
// 만약 비연속적으로 나와도 되면서 minimum length 를 찾는 경우면 
// -> window 를 먼저 구성한 후 minimum 이 될 때 까지 l 점프해서 min window length 를 구하는 방법 적용.

// Solved
// Hard
// Topics
// Companies

// You are given a string s and an array of strings words. 
// All the strings of words are of the same length.
// A concatenated substring in s is a substring that contains all the strings of 
// any permutation of words concatenated.

// For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", 
// and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring 
// because it is not the concatenation of any permutation of words.
// Return the starting indices of all the concatenated substrings in s. 
// You can return the answer in any order.

 

// Example 1:

// Input: s = "barfoothefoobarman", words = ["foo","bar"]
// Output: [0,9]
// Explanation: Since words.length == 2 and words[i].length == 3, 
// the concatenated substring has to be of length 6.
// The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
// The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
// The output order does not matter. Returning [9,0] is fine too.
// Example 2:

// Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
// Output: []
// Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
// There is no substring of length 16 in s that is equal to the concatenation of any permutation of words.
// We return an empty array.
// Example 3:

// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
// Output: [6,9,12]
// Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
// The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
// The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
// The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 

// Constraints:

// 1 <= s.length <= 104
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 30
// s and words[i] consist of lowercase English letters.
import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int totalLen = s.length();
        List<Integer> list = new ArrayList<Integer>();

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i=0; i<wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> foundWordMap = new HashMap<>();
            for (int j = i; j <= totalLen - wordLen; j += wordLen) {
                String subWord = s.substring(j, j+wordLen);
                if (wordMap.containsKey(subWord)) {
                    foundWordMap.put(subWord, foundWordMap.getOrDefault(subWord, 0) + 1);
                    count++;

                    while (foundWordMap.get(subWord) > wordMap.get(subWord)) {
                        // remove left word until the count of subWord become the same with input.
                        String leftWord = s.substring(left, left+wordLen);
                        foundWordMap.put(leftWord, foundWordMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // if the count of input word is the same with the count of word => we found.
                    if (count == words.length) {
                        list.add(left);

                        // remove left word and go on.
                        String leftWord = s.substring(left, left+wordLen);
                        foundWordMap.put(leftWord, foundWordMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    foundWordMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return list;
    }
}