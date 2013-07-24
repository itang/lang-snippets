var sys = require('sys');

function ofuscatedPassword(pass) {
    var ret = "";
    var plen = pass.length;
    if (plen < 3) {
        ret = _repeatStar(plen);
    } else {
        ret = pass[0] + _repeatStar(plen-2) + pass[plen-1];
    }

    debug(ret);
    return ret;
}

function _repeatStar(times) {
    return _repeatStr("*", times)
}

function _repeatStr(str, times) {
    var arr = [];
    for(var i= 0; i < times; i++) {
        arr[i] = str
    }
    return arr.join("");
}

function debug(o) {
    sys.debug(o);
}

function assert(t) {
    if(!t) throw "AssertionError"
}

assert("" === ofuscatedPassword(""));
assert("*" === ofuscatedPassword("s"));
assert("**" === ofuscatedPassword("ss"));
assert("s*s" === ofuscatedPassword("sss"));
assert("s****s" === ofuscatedPassword("ssaass"));
