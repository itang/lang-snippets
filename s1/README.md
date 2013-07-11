## -一行代码统计字符串字母a出现的次数

### Clojure

    (reduce (fn [p e] (if (= e \a) (inc p) p)) 0 "banana")

    (->> "banana" (filter (partial = \a)) count)

### Scala

    "banana".foldLeft(0){ (p, e) => if(e=='a') p+1 else p }

    "banana".filter(_ == 'a').length

    "banana".count{ case 'a' => true; case _ => false }
    "banana".count{ _ == 'a'}

### Dart

    "banana".split("").fold(0, (p, e) => e=='a'? p+1 : p);

    "banana".split("").where((c) => c == 'a').length);

### Elixir

    "banana" |> String.codepoints |> Enum.filter(&1 == "a") |> length

### Ruby
    "banana".each_char.reduce(0){|p, e| e=='a'? p+1 : p}

    "banana".split("").select {|x| x == 'a'}.count
    "banana".each_char.select {|x| x == 'a'}.length
