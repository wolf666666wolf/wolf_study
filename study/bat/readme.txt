�ο���ַ��http://blog.csdn.net/stpeace/article/details/9039685

1. echo @
   echo ������printf, ����echo on��ӡ��� echo off����ӡ����� ���Ƕ��߶�����ʾecho����� 
   echo��@ ��ϾͿ��Բ���ʾ�����б������� @ echo off, echo off ����Ͳ�����ʾ����
   echo. ֵ��ע������������е�"��"Ҫ������ECHO�����м䲻���пո�,����"��"����������ʾ��Ϣ�������Ļ.����"��"������,:;"[\]������һ�������.
   
2. start, pause��goto�Լ�rem���÷�
   start������˫�������Դ�word, ��Ŀ¼�� ִ��bat�ļ�, ���ļ�
   pause ��ͣ
   goto ��ת  �� :label j���ʹ��
   rem  ��remark����˼������ע�ͣ�����bat�ļ����˿���
   
3  set setlocal
   set name=zhangsan ��ֵ
   set name ��ѯ��name��ͷ�����б�����Ϣ
   set name=ɾ����������name
   set ��ѯ��ǰϵͳ���б���
   set /a sum=0 ���� /a�ǰ�sum��Ϊ����������
   setlocal enlocal����������ʱ����������֮��setlocal��endlocal֮����Ч
   
4  for :����for��ʱ��ǧ��Ҫע�⣺do��(֮������пո񣬷������
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
6   �ļ�����������
	@echo off  
	set /a total=0  
	set prefix=MY  
	  
	for %%m in (*) do (  
	if not "%%m" == "myBat.bat" (  
		ren %%m %prefix%%%m  
		set /a total=total+1  
		)  
	)  
	  
	echo ����%total%���ļ�������  
	set total=  
	set prefix= 