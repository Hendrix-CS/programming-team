
n = int(input())  # Read an int on a line by itself
for _ in range(n):             # Do something n times

    # Read all the ints on a line into a list
    xs = map(int, input().split())

    # Read a known number of ints into variables
    p, q, r, y = map(int, input().split())
