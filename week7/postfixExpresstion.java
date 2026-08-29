import java.util.Stack;

class postfixExpresstion {
    public static int evaluatePostfix(String exp) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If operand
            if (Character.isDigit(ch)) {
                st.push(ch - '0');
            }

            // If operator
            else {
                int b = st.pop();
                int a = st.pop();

                switch (ch) {
                    case '+':
                        st.push(a + b);
                        break;

                    case '-':
                        st.push(a - b);
                        break;

                    case '*':
                        st.push(a * b);
                        break;

                    case '/':
                        st.push(a / b);
                        break;

                    case '^':
                        st.push((int)Math.pow(a, b));
                        break;
                }
            }
        }

        return st.peek();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";

        System.out.println(evaluatePostfix(exp));
    }
} 
    
