## -一行代码统计字符串字母a出现的次数

### s1.exs

    "banana" |> String.codepoints |> Enum.filter(&1 == "a") |> length |> IO.puts

### s1.scala

    println("banana".filter(_ == 'a').length)

### s1.dart

    void main() { print("banana".split("").where((c) => c == 'a').length); }

### s1.clj

    (->> "banana" (filter (partial = \a)) count println)

### s1.rb

    puts "banana".split("").select {|x| x == 'a'}.count
    puts "banana".each_char.select {|x| x == 'a'}.length
