#include <stdio.h>

int main(int argc, char* argv[]) {

  int a, b;

  printf("Enter a number: ");
  scanf("%d", &a);

  printf("Enter another number: ");
  scanf("%d", &b);

  printf("Total: %d\n", a+b);

  return 0;
}
