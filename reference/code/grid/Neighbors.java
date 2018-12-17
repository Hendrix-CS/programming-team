int dr = 1, dc = 0;
for (int k = 0; k < 4; k++) {
    int nr = r + dr, nc = c + dc;
    // process neighbor (nr, nc)

    int tmp = dr; dr = -dc; dc = tmp;  // rotate offset
}
