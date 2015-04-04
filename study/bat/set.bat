@echo off

set sum=0
echo sum is %sum%

set sum=sum+1
echo sum is %sum%

set sum=

rem 以下作为数字计算
set /a sum=0
echo sum is %sum%
set /a sum=sum+1
echo sum is %sum%

set sum=

