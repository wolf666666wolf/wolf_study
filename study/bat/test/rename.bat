@echo off
set /a total=0
set prefix=MY
for %%m in (*) do (
if not "%%m" == "rename.bat" (
	ren %%m %prefix%%%m  
	set /a total=total+1
	)
)
echo 共有%total%个文件被改名
set total=  
set prefix=  