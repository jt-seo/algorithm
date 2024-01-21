// 224. Basic Calculator

// 1. string 의 앞에서 부터 iteration 하면서
// 2. number 와 sign 을 갖고 있다가 연산자를 만나면 result 에 저장하고 number 와 sign 을 연산자에 맞춰 바꿈.
// 3. ( 를 만나면 이전까지의 result 와 ( 앞의 sign 을 stack 에 push
// 4. ) 를 만날 때 까지 2 ~ 3 반복
// 5. ) 를 만나면 -> result 에는 () 구간의 값이 저장되어 있고 이 result 의 sign 은 stack 에서 pop 하면 된다.
// 6. sign 이 붙은 result 에 stack 에서 하나 pop 한 걸 더해준다. a +_+ ( result ) 형태의 결과값이 나옴.
// 7. number = 0, sign = 1 로 초기화 하고 2 부터 반복

// Hard
// Topics
// Companies
// Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

// Example 1:

// Input: s = "1 + 1"
// Output: 2
// Example 2:

// Input: s = " 2-1 + 2 "
// Output: 3
// Example 3:

// Input: s = "(1+(4+5+2)-3)+(6+8)"
// Output: 23
 

// Constraints:

// 1 <= s.length <= 3 * 105
// s consists of digits, '+', '-', '(', ')', and ' '.
// s represents a valid expression.
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
// There will be no two consecutive operators in the input.
// Every number and running calculation will fit in a signed 32-bit integer.
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // Push the result and the sign onto the stack
                stack.push(result);
                stack.push(sign);
                // Reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    // stack.pop() is the sign before the parenthesis
                result += stack.pop();    // stack.pop() now is the result calculated before the parenthesis
            }
        }
        
        if (number != 0) {
            result += sign * number;
        }
        
        return result;
    }
}
