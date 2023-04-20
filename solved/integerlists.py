from collections import deque

cases = int(input())
for case in range(cases):
    commands = input()
    original_count = int(input())
    nums = input()[1:-1].split(',')
    if nums == ['']:
        nums = []
    D = deque(nums)
    is_reversed = False
    for command in commands:
        if command == 'R':
            is_reversed = not is_reversed
        elif command == 'D':
            if len(D) == 0:
                print('error')
                break
            if is_reversed:
                D.pop()
            else:
                D.popleft()
    else:
        if is_reversed:
            D.reverse()
        print(f"[{','.join(D)}]")
