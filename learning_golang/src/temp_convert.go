// temp_convert
package main

import (
	"fmt"
)

type Fahrenheit float32
type Celsius float32

func toFahrenheit(temp Celsius) Fahrenheit {
	return Fahrenheit((temp * 9 / 5) + 32)
}

func toCelsius(temp Fahrenheit) Celsius {
	return Celsius((temp - 32) * 5 / 9)
}

// Asks the user to enter temperature in either degree F
// or degree C and converts it from one to the other
func main() {

	var temp float32
	var scale byte

	fmt.Print("Enter temperature value: ")
	fmt.Scanf("%f", &temp)
	fmt.Print("Enter F/C: ")
	fmt.Scanf("%c", &scale)

	switch scale {
	case 'F':
		fmt.Printf("%.0f\u00B0F = %.0f\u00B0C\n", temp, toCelsius(Fahrenheit(temp)))
	case 'C':
		fmt.Printf("%.0f\u00B0C = %.0f\u00B0F\n", temp, toFahrenheit(Celsius(temp)))
	default:
		fmt.Println("Invalid temperature scale!")
	}
}
