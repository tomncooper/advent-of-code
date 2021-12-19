with open("input.txt") as inputs:
    depths = [int(depth) for depth in inputs]

total = 0
last_depth = depths[0]
for depth in depths[1:]:
    if depth > last_depth:
        total += 1
    last_depth = depth

print(total)