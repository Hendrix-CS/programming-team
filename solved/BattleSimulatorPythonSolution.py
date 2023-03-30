n = input()
final = []
ran = len(n)
i = 0
while i < ran:
    element = n[i]
    if 'R' in n[i : i+3] and 'B' in n[i : i+3] and 'L' in n[i : i+3]:
        final.append("C")
        i+=3
    else:
        if element == 'R':
            final.append("S")
        elif element == 'B':
            final.append("K")
        elif element == 'L':
            final.append("H")
        i+=1

print(''.join(final))