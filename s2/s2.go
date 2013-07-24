package main

import "fmt"

func OfuscatedPassword(pass string) (ret string) {
	plen := len(pass)
	if plen < 3 {
		ret = repeatStar(plen)
	} else {
		ret = fmt.Sprintf("%c%v%c", pass[0], repeatStar(plen-2), pass[plen-1])
	}

	debug(ret)
	return
}

func repeatStar(times int) string {
	return RepeatStr("*", times)
}

func RepeatStr(str string, times int) (ret string) {
	ret = ""
	for i := 0; i < times; i++ {
		ret = ret + str
	}
	return
}

func assert(t bool) {
	if !t {
		panic("Assert failure!")
	}
}

func debug(o interface{}) {
	fmt.Println(o)
}

func main() {
	assert("" == OfuscatedPassword(""))
	assert("*" == OfuscatedPassword("s"))
	assert("**" == OfuscatedPassword("ss"))
	assert("s*s" == OfuscatedPassword("sss"))
	assert("s****s" == OfuscatedPassword("ssaass"))
}
