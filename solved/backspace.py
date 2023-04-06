s = input()
word = []
for char in s:
    if char == "<":
        word.pop()
    else:
        word.append(char)
print("".join(word))