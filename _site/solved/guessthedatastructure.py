from sys import stdin
from collections import deque
from heapq import heappush, heappop

while True:
    line = stdin.readline()
    if line == '': break

    stack = []
    queue = deque()
    pq = []
    is_stack = is_queue = is_pq = True
    num_ops = int(line)
    for op in range(num_ops):
        line = stdin.readline()
        op_type, val = map(int, line.split())
        if op_type == 1:
            stack.append(val)
            queue.appendleft(val)
            heappush(pq, -val)
        else:
            if len(stack) == 0:
                is_stack = is_queue = is_pq = False
            else:
                if stack.pop() != val:
                    is_stack = False
                if queue.pop() != val:
                    is_queue = False
                if heappop(pq) != -val:
                    is_pq = False
    if is_stack == is_queue == is_pq == False:
        print('impossible')
    elif is_stack and is_queue == is_pq == False:
        print('stack')
    elif is_queue and is_stack == is_pq == False:
        print('queue')
    elif is_pq and is_stack == is_queue == False:
        print('priority queue')
    else:
        print('not sure')
