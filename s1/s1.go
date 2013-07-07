package main

import "fmt"

func Occurrence(str string, c rune) (count int) {
	count = 0
	for _, v := range str {
		if v == c {
			count += 1
		}
	}
	return
}

func main() {
	fmt.Println(Occurrence("banana", 'a'))
}
