int lengthOfLastWord(char* s) {
    int i = strlen(s)-1;
    int r = 0;

    while(i >= 0 && s[i] == ' ') {
        i--;
    }
    while(i >= 0 && s[i] != ' ') {
        i--;
        r++;
    }
    return r;
}