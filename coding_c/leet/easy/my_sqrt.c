int mySqrt(int x) {
    if(x == 1) {
        return 1;
    }
    long y = x / 2;
    while (y * y > x) {
        y /= 2;
    }
    while(y * y < x) {
        y += 1;
    }
    return y * y == x ? (int) y : (int)y - 1;
}