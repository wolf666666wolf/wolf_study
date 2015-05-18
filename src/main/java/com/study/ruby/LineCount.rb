# read file
#eg1
text = ''
line_count=0
File.open("readme.txt").each do |line|
  line_count += 1
  text << line
end

puts line_count
puts text

#eg2
lines = File.readlines("readme.txt")
line_count = lines.size
text = lines.join
puts line_count
puts text