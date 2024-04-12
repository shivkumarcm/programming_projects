char* addBinary(char* a, char* b) {
    int i, j, k, sum, carry = 0;
    int n = strlen(a);
    int m = strlen(b);
    int p = m > n ? m : n;
    char *c = (char*)malloc(sizeof(*c)*(p+2)), *d;
    
    c[p+1] = '\0'; //put end of string character

    for(i=n-1, j=m-1; i>=0 && j>=0; i--, j--, p--) {
        sum = a[i] - '0' + b[j] - '0' + carry;
        if (sum == 2) {
            sum = 0;
            carry = 1;
        } else if (sum == 3) {
            sum = 1;
            carry = 1;
        } else {
            carry = 0;
        }
        c[p] = (char)('0' + sum);
    }

    // find the longer string and work through the carry
    d = n > m ? a: b;
    while(p>=1) {
        sum = d[p-1] - '0' + carry;
        if (sum == 2) {
            sum = 0;
            carry = 1;
        } else {
            carry = 0;
        }
        c[p] = (char)('0' + sum);
        p--;
    }

    // delete the first digit if necessary
    if(carry == 1) {
        c[0] = '1';
    } else {
        p = m > n ? m : n;
        d = malloc(sizeof(*d)*(p+1));
        strcpy(d, c+1);
        free(c);
        c = d;
    }
    return c;
}