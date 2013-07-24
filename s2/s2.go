package main

import (
	. "fmt"
	. "strings"
)

func OfuscatedPassword(pass string) string {
	plen := len(pass)
	if plen < 3 {
		return Repeat("*", plen)
	} else {
		return Sprintf("%c%v%c", pass[0], Repeat("*", plen-2), pass[plen-1])
	}
}

func assert(t bool) {
	if !t {
		panic("Assert failure!")
	}
}

func main() {
	assert("" == OfuscatedPassword(""))
	assert("*" == OfuscatedPassword("s"))
	assert("**" == OfuscatedPassword("ss"))
	assert("s*s" == OfuscatedPassword("sss"))
	assert("s****s" == OfuscatedPassword("ssaass"))
}
