puts "banana".split("").select {|x| x == 'a'}.count
puts "banana".each_char.select {|x| x == 'a'}.length
