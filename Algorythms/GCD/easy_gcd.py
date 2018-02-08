def gcd(a, b):
    result = 1

    for i in range(1, min(a, b)):
        if a % i == 0 and b % i == 0:
            result = i

    return result


if __name__ == "__main__":
    print(gcd(102, 85))
