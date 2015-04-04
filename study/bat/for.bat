@echo off
set /a total=0
for %%x in (*.bat) do (
  echo %%x
rem  echo.
  set /a total=total+1
)
echo we have %total% bat files 