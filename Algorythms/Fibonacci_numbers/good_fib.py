def fib(n):
    if n >= 0 and n <= 1:
        return 1

    numbers = []
    numbers.append(1)
    numbers.append(1)

    for i in range(2, n + 1):
        numbers.append(numbers[i - 1] + numbers[i - 2])

    return numbers[n]

if __name__ == "__main__":
    print(fib(30))
