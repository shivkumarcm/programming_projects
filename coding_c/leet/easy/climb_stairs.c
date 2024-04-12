/**
 * You are climbing a staircase. It takes n steps to reach the top. 
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
*/
int climbStairs(int n) {
    int *arr, i, retval;
    if (n <= 0) {
        return 0;
    }
    if (n == 1) {
        return 1;
    }
    if (n == 2) {
        return 2;
    }
    arr = (int*)malloc(sizeof(int)*(n+1));
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 2;
    for(i = 3; i <= n; i++) {
        arr[i] = arr[i-1] + arr[i-2];
    }
    retval = arr[n];
    free(arr);
    return retval;
}