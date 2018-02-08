def fib(n):
    if n == 0:
        return 0
    if n == 1:
        return 1

    f1, f2 = 0, 1

    for i in range(2, n + 1):
        f1, f2 = f2, f1 + f2

    return f2

if __name__ == "__main__":
    print(fib(121222))
