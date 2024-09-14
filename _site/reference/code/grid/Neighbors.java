int dr = 1, dc = 0;  // starting offset of (1,0); nothing special about this choice
for (int k = 0; k < 4; k++) {
    int nr = r + dr, nc = c + dc;
    // process neighbor (nr, nc)

    int tmp = dr; dr = -dc; dc = tmp;  // rotate offset ccw
    // to get cw instead, switch the negative sign
}
