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

def obfuscatedPassword3(pass: String) = pass.length match{
  case len if len < 3 => "*" * len
  case len @ _ => pass.head + "*" * (len - 2) + pass.last
}

// test
for(f <- List(obfuscatedPassword1 _, obfuscatedPassword2 _, obfuscatedPassword3 _ )){
  assert("" == f(""))
  assert ("*" == f("s"))
  assert("**" == f("ss"))
  assert("s*s" == f("sss"))
  assert("s**s" == f("saas"))
}
