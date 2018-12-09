import sys

if __name__ == '__main__':

    n = int(sys.stdin.readline())  # Read an int on a line by itself
    for _ in range(n):             # Do something n times

        # Read all the ints on a line into a list
        xs = map(int, sys.stdin.readline().split())

        # Read a known number of ints into variables
        p, q, r, y = map(int, sys.stdin.readline().split())
