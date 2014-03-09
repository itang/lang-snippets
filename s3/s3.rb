max = if ARGV.length > 0 then ARGV[0].to_i else 10 end
max.times { |x| puts x + 1; sleep 1 }