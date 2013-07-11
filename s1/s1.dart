void main() {
		print("banana".split("").where((c) => c == 'a').length); 
		print("banana".split("").fold(0, (p, e) => e=='a'? p+1 : p));
}
