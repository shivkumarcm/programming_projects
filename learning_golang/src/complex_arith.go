// simple_arith.go
package main

import (
	"fmt"
)

func formatComplex(c complex64) string {
	sign := "+"
	im := imag(c)
	if im < 0.0 {
		sign = "-"
		im *= -1
	}
	return fmt.Sprintf("(%.2f %s %.2fi)", real(c), sign, im)
}

// A function that asks the user to input two complex numbers,
// performs a user selected arithmetic operation on it
// and prints the result
func main() {
	var re1, re2, im1, im2, op int32
	var c1, c2, result complex64
	var op_sign string = "?"

	fmt.Print("Enter a complex number: ")
	fmt.Scanf("%d %d", &re1, &im1)
	fmt.Print("Enter another complex number: ")
	fmt.Scanf("%d  %d", &re2, &im2)
	fmt.Print("Choose an operation: 1: ADD, 2: SUBTRACT, 3: MULTIPLY, 4: DIVIDE  ::  ")
	fmt.Scan(&op)

	c1 = complex(float32(re1), float32(im1))
	c2 = complex(float32(re2), float32(im2))

	switch op {
	case 1:
		result = c1 + c2
		op_sign = "+"
	case 2:
		result = c1 - c2
		op_sign = "-"
	case 3:
		result = c1 * c2
		op_sign = "*"
	case 4:
		result = c1 / c2
		op_sign = "/"
	default:
		fmt.Println("Invalid operation!")
		return
	}

	fmt.Printf("%s %s %s = %s\n", formatComplex(c1), op_sign, formatComplex(c2), formatComplex(result))

}
