
@ echo off
if exist 1.txt (echo yes)
echo 程序员 >1.txt

if exist 1.txt  echo yes
echo 程序员1 >1.txt

if exist 1.txt (
	echo 1
	echo 2
	echo 3
	echo 4
)