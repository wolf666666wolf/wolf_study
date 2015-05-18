
#globle variable
def base_method
  puts $x
end

$x=100
base_method


#2 Object variable
class Square
  def initialize(side_length)
    @side_length = side_length
  end
  def area
    @side_length * @side_length
  end
end

a = Square.new(10)
puts a.area

#3 class variable
class Square1
  def initialize
    if defined?(@@number_of_squares)
      @@number_of_squares += 1
    else
      @@number_of_squares = 1
    end
  end
  def Square1.count
    @@number_of_squares
  end
end
  
a = Square1.new
puts Square1.count
b = Square1.new
puts Square1.count
c = Square1.new
puts Square1.count