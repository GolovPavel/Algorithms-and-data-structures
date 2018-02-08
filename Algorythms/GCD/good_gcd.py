'''
We will use lemma: if a >= b > 0, r = a mod b,
then gcd(a, b) = gcd(a mod b, b)
'''

def gcd(a, b):
    if a == 0:
        return b
    elif b == 0:
        return a
    else:
        if a >= b:
            return gcd(a % b, b)
        else:
            return gcd(a, b % a)


if __name__ == "__main__":
    a, b = [int(x) for x in input().split()]
    print(gcd(a, b))
