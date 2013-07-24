##  Obfuscated Password 混淆密码

Returns the password in obfuscated fashion which means everthing except the first and last character replaced by * stars. If the password is one or two characters long we'll obfuscate it entirely.

### Java version:

    org.springframework.data.authentication.UserCredentials#getObfuscatedPassword

### Clojure:

	(require '[clojure.string :refer [join]])

	(def r* #(->> "*" (repeat %) join))

	(defn obfuscated-password1 [pass]
	  (let [len (count pass)]
		(if (< len 3)
		  (r* len)
		  (str (first pass) (r* (- len 2)) (last pass)))))

	(defn obfuscated-password2 [pass]
	  (let [r (re-seq #"(.)(.+)(.)" pass)]
		(if r
		  (let [[p x n] (rest (first r))]
			(str p (r* (count x)) n))
		  (r* (count pass)))))

### Scala

	def obfuscatedPassword1(pass: String) = {
	  if (pass.length < 3)
		"*" * pass.length
	  else {
		pass.head + "*" * (pass.length - 2) + pass.last
	  }
	}

	def obfuscatedPassword2(pass: String) = {
	  val re1 = "(.)(.+)(.)".r
	  pass match {
		case re1(p, x, n) => p + ("*" * x.length) + n
		case _ => "*" * pass.length
	  }
	}

### Go

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
