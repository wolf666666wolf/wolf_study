参考网址：http://blog.csdn.net/stpeace/article/details/9039685

1. echo @
   echo 类似于printf, 其中echo on打印结果 echo off不打印结果， 但是二者都会显示echo命令本身， 
   echo和@ 结合就可以不显示命令行本身，比如 @ echo off, echo off 本身就不会显示出来
   echo. 值得注意的是命令行中的"．"要紧跟在ECHO后面中间不能有空格,否则"．"将被当作提示信息输出到屏幕.另外"．"可以用,:;"[\]＋等任一符号替代.
   
2. start, pause，goto以及rem的用法
   start类似于双击，可以打开word, 打开目录， 执行bat文件, 打开文件
   pause 暂停
   goto 跳转  和 :label j结合使用
   rem  是remark的意思，就是注释，给先bat文件的人看的
   
3  set setlocal
   set name=zhangsan 赋值
   set name 查询以name开头的所有变量信息
   set name=删除变量定义name
   set 查询当前系统素有变量
   set /a sum=0 这里 /a是把sum作为数字来看待
   setlocal enlocal用来定义临时变量，变量之间setlocal和endlocal之间有效
   
4  for :在用for的时候，千万要注意：do和(之间必须有空格，否则错误
   @echo off
	set /a total=0
	for %%x in (*.bat) do (
	echo %%x
	echo.
	set /a total=total+1
	)
	echo we have %total% bat files    
	
5   if
	@echo off  
	if exist 1.txt (  
		echo yes  
		echo 1  
		echo 2  
		echo 3) else (  
		echo no  
	) 	
6   文件批量重命名
	@echo off  
	set /a total=0  
	set prefix=MY  
	  
	for %%m in (*) do (  
	if not "%%m" == "myBat.bat" (  
		ren %%m %prefix%%%m  
		set /a total=total+1  
		)  
	)  
	  
	echo 共有%total%个文件被改名  
	set total=  
	set prefix= 