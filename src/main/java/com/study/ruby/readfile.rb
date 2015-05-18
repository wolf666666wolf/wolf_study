 #获取当前的文件名称
puts   __FILE__  
#获取当前文件的目录名称
puts File.dirname(__FILE__)
#获取当前文件的完整名称
#当要获取完整的路径时需要require 'pathname',代码如下：
require 'pathname'
puts Pathname.new(__FILE__).realpath    
#获取当前文件的完整目录
require 'pathname'
puts Pathname.new(File.dirname(__FILE__)).realpath  