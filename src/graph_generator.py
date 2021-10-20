import networkx as nx
import numpy as np
n = 5
G = nx.path_graph(n)  # or MultiGraph, etc
for i in range(1, n):
    G.add_edge(n-1, n)
    graph_list = list(G.edges([0, n]))

print('\n'.join(map(str, graph_list)))

#G.edges([0, 3])
#[e for e in G.edges]
#.to_undirected
# ( -> [enter]
# , ) -> ''
# 10, 100, 1000 
# G.add_edge(n-1, n)
# graph_list = list(G.edges([0, n+1]))