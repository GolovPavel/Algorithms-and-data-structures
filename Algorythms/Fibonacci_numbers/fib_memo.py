'''
Memoization fibonacci numbers algorythm
'''

fib_array = [0, 1]

def fib(n):
    current_size = len(fib_array)

    if current_size < n + 1:
        for i in range(current_size, n + 1):
            fib_array.append(fib_array[i - 1] + fib_array[i - 2])

    return fib_array[n]
        
if __name__ == "__main__":
    print(fib(121222))