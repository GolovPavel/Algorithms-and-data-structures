'''
Speed - if numbers is big - O(n^2) (very complex addition opperation),
else - O(n)
'''
def fib(n):
    if n <= 1:
        return n

    f1, f2 = 0, 1

    for i in range(2, n + 1):
        f1, f2 = f2, f1 + f2

    return f2

if __name__ == "__main__":
    print(fib(121222))
