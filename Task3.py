def compute(n):
    if n < 10:
        out = n ** 2
    elif n < 20:
        out = 1
        for i in range(1, n-9):  # Change1 => n-10 to n-9
            out *= i
    else:
        lim = n - 20
        out = lim * lim
        out = out - lim
        out = out // 2  # Change2 => / to // for integer division
    print(out)


n = int(input("Enter an integer: "))
compute(n)

