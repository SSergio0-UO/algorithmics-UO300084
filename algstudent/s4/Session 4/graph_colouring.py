import json

from helper import draw_coloured_map, generate_graph_map
       
def greedy(map):#for solving it correctly u first need to paint the nodes with the highest number of connections
    colours = ["red", "blue", "green", "yellow", 
"orange", "purple", "cyan", "magenta", "lime"]
    

    solution = create_sol_list(map.keys());


    count = 0
    number_of_colours = 0
    colours_used = {}

    nodes_sorted = sorted(map.keys(), key = lambda x: len(map[x]), reverse = True)
    for node in nodes_sorted:
        for colour in colours:
            if(check_colour_connections(map[node], colour, solution)):
                solution[node] = colour
                break

    # for i in range (8,-1,-1):#start in 8 and goes down to 0                       (not efficient)
    #     for node in map.keys():
    #         if(len(map[node]) == i):
    #             for colour in colours:
    #                 if(check_colour_connections(map[node],colour,solution)):
    #                     solution[node] = colour
    #                     break 
    return solution

def check_colour_connections(node, colour,solution):
    for connection in node:
        if(solution[str(connection)] == colour):
            return False
    return True

def create_sol_list(nodes):
    solution = {}
    for node in nodes:
        solution[str(node)] = None
    return solution

   

if __name__ == "__main__":
    #n = 128
    #map = generate_graph_map(n)
    with open('sols/g128.json') as f:
        map = json.load(f)
        f.close()
    solution = greedy(map["graph"])

    if solution:
        print("Solution found:", solution)
        draw_coloured_map(map, solution)
        with open('solution.json', 'w') as f:
            json.dump(solution, f)
            f.close()
    else:
        print("Solution not found.")
