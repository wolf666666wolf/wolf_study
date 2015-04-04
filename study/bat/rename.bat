@echo off
set /a total=0
set prefix=hello
set filedir=./test
cd filedir
for %%n in (*.txt) do (
  if not "%%n"=="1.txt" (
    echo %%n
	echo %prefix%%%n
	ren %%n %prefix%%%n
	set /a total=total+1
  )
)
echo %total% files have been renamed
set tatal=
set prefix=