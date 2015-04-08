puts 3<=>4
puts 3<=>3
puts 4<=>3

score=80
if score>60
  puts "pass"
else
  puts "not pass"
  
end

def say_hello(name)
  puts "I love #{name}"
end
say_hello("beijing")

def add_all(*num)
  sum=0
  num.each{|x| sum+=x}
  return sum
end
puts add_all(1,2,3)