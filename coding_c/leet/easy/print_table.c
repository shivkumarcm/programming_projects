#include <stdio.h>

int main(int argc, char* argv[]) {

  int num, i;

  printf("Enter a number to print the multiplication table: ");
  scanf("%d", &num);

  for(i = 1; i <= 10; i++) {
    printf("%d X %d = %d\n", num, i, num*i);
  }

  return 0;
}
