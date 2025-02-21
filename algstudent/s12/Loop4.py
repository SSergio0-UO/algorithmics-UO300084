import time
import sys

def loop4(n):
    """Counts the number of executions in a triple nested loop."""
    cont = 0
    for i in range(1, n + 1):
        for j in range(1, i + 1):
            for k in range(1, j + 1):
                cont += 1
    return cont

def main():

    n_times = 1

    print("n\ttime\trepetitions\tcounter")

    n = 100
    while n <= 6400:
        t1 = time.time() * 1000  # Start time in milliseconds

        c = 0
        for _ in range(n_times):
            c = loop4(n)

        t2 = time.time() * 1000  # End time in milliseconds

        print(f"{n}\t{int(t2 - t1)}\t{n_times}\t\t{c}")

        n *= 2  # Increase n exponentially

if __name__ == "__main__":
    main()