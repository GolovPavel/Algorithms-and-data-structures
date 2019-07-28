br = {
    "(": ")",
    "{": "}",
    "[": "]"
}


def isBalanced(s):
    stack = []

    for l in s:
        if l in br:
            stack.append(l)
        else:
            if len(stack) == 0:
                return False
            
            top = stack.pop()

            for op, cl in br.items():
                if top == op and l != cl:
                    return False
    return len(stack) == 0

print(isBalanced(r"({})"))
print(isBalanced(r"({)}"))
print(isBalanced(r"[({])]"))
print(isBalanced(r"({[]})"))
