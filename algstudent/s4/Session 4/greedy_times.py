import json
import time

from helper import draw_coloured_map, generate_graph_map
from graph_colouring import greedy

if __name__ == "__main__":
    n = 8
    for i in range(15):
        start = time.time()
        for i in range(10):
            with open('sols/g'+str(n)+'.json') as f:
                map = json.load(f)
                f.close()
            solution = greedy(map["graph"])

        if solution:
            with open('solution.json', 'w') as f:
                json.dump(solution, f)
                f.close()
        else:
            print("Solution not found.")

        end = time.time()
        elapsed_ms_round = round((end - start) * 1000)
        print(f"Time for {n} nodes : {elapsed_ms_round} milliseconds")
        n *= 2