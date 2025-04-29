Some issues:

* First of all, you are not using the repository properly. You must upload the files of code, not Zips. Zips are a black box; not only you cannot see them, but you cannot keep track of the changes made on them. Same for the words.
* Inefficient approach in the greedy algorithm, using three loops to explore the nodes. Sort first with O(nlogn) and then you only need two, one for the sorted collection and another for the colours. Your solution escalates badly as the number of possible connections and colours increases.
* Pruning could improve backtracking by not exploring branches which we calculate won't mathematically provide a result.
