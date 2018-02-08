def fib(n):
    if n <= 1 and n >= 0:
        return 1
    return fib(n - 1) + fib(n - 2)

if __name__ == "__main__":
    print(fib(30))
