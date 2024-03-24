// simple_arith.go
package main

import (
	"fmt"
)

// A simple function that asks the user two input to integers,
// performs a user selected arithmetic operation on it
// and prints the result
func main() {
	var v1, v2, op, result int
	var op_sign string = "?"

	fmt.Print("Enter a number: ")
	fmt.Scan(&v1)
	fmt.Print("Enter another number: ")
	fmt.Scan(&v2)
	fmt.Print("Choose an operation: 1: ADD, 2: SUBTRACT, 3: MULTIPLY, 4: DIVIDE  ::  ")
	fmt.Scan(&op)

	switch op {
	case 1:
		result = v1 + v2
		op_sign = "+"
	case 2:
		result = v1 - v2
		op_sign = "-"
	case 3:
		result = v1 * v2
		op_sign = "*"
	case 4:
		if v2 == 0 {
			println("Divide by 0 not allowed!")
			return
		}
		result = v1 / v2
		op_sign = "/"
	default:
		fmt.Println("Invalid operation!")
		return
	}

	fmt.Printf("%d %s %d = %d\n", v1, op_sign, v2, result)

}
