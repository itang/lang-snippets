package main

import (
	"fmt"
	"os"
	"strconv"
	"time"
)

func main() {
	var max int = 10
	if len(os.Args) > 1 {
		v, err := strconv.Atoi(os.Args[1])
		if err != nil {
			panic(err)
		}
		max = v
	}

	for i := 1; i <= max; i++ {
		fmt.Println(i)
		time.Sleep(time.Second * 1)
	}
}
