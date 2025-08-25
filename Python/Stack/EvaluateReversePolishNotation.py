class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        
        for token in tokens:
            if token == "+":
                first = int(stack.pop())
                second = int(stack.pop())
                operand = first + second
                stack.append(str(operand))
            elif token == "-":
                first = int(stack.pop())
                second = int(stack.pop())
                operand = second - first
                stack.append(str(operand))
            elif token == "*":
                first = int(stack.pop())
                second = int(stack.pop())
                operand = first * second
                stack.append(str(operand))
            elif token == "/":
                first = int(stack.pop())
                second = int(stack.pop())
                operand =  int(second) / int(first)
                stack.append(str(math.floor(operand) if operand > 0 else math.ceil(operand)))
            else:
                stack.append(token)

        return int(stack.pop())