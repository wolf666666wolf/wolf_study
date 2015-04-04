1.log4j have 7 levels: OFF FETAL ERROR WARN INFO DEBUG ALL, normally we just use ERROR WARN INFO and DEBUG
2.输出源
	Log4j允许日志请求被输出到多个输出源。用Log4j的话说，一个输出源被
	称做一个Appender 。
	一个logger可以设置超过一个的appender。
3.常见Appender
	org.apache.log4j.ConsoleAppender（控制台）
	org.apache.log4j.FileAppender（文件）
	org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件）
	org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）
	org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
	org.apache.log4j.jdbc.JDBCAppender（把日志用JDBC记录到数据库中）
4.布局  布局就是指输出信息的格式。在Log4j中称作Layout
	  常见Layout
	org.apache.log4j.HTMLLayout（以HTML表格形式布局），
	org.apache.log4j.PatternLayout（可以灵活地指定布局模式），
	org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），
	org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）

	最常用的PatternLayout
		%m 输出代码中指定的消息
		%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL
		%r 输出自应用启动到输出该log信息耗费的毫秒数
		%c 输出所属的类目，通常就是所在类的全名
		%t 输出产生该日志事件的线程名
		%n 输出一个回车换行符，Windows平台为“\r\n”，Unix平台为“\n”
		%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日22：10：28，921
		%l 输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。
5.配置
	Log4j有两种配置方式，一种是xml格式，一种是properties格式。都是放置到classpath下面。默认名称分别是：log4j.xml和log4j.properties
	properties配置示例如下：
		log4j.rootLogger=error,javass.Console,javass.File
		log4j.appender.javass.Console=org.apache.log4j.ConsoleAppender
		log4j.appender.javass.Console.layout=org.apache.log4j.PatternLayout
		log4j.appender.javass.Console.layout.ConversionPattern=%d{HH:mm:ss,SSS}%5p (%C{1}:%M) - %m%n
		
		log4j.appender.javass.File=org.apache.log4j.DailyRollingFileAppender
		log4j.appender.javass.File.file=javass.log
		log4j.appender.javass.File.DatePattern=.yyyy-MM-dd
		log4j.appender.javass.File.layout=org.apache.log4j.PatternLayout
		log4j.appender.javass.File.layout.ConversionPattern=%d{HH:mm:ss,SSS} %5p(%C{1}:%M) - %m%n
		log4j.logger.cn.javass=debug			
	xml配置：
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
	<log4j:configuration xmlns:log4j='http://jakarta.apache.org/log4j/'>
		<appender name="test" class="org.apache.log4j.ConsoleAppender">
			<layout class="org.apache.log4j.PatternLayout">
				<param name="ConversionPattern"
				value="[%d{dd HH:mm:ss,SSS\} %-5p] [%t] %c{2\} - %m%n" />
			</layout>
		</appender>
		<appender name="file"
			class="org.apache.log4j.DailyRollingFileAppender">
			<param name="File" value="E:/test.log" />
			<param name="DatePattern" value="'.'yyyy-MM-dd'.log'" />
			<layout class="org.apache.log4j.PatternLayout">
				<param name="ConversionPattern"
				value="[%d{MMdd HH:mm:ss SSS\} %-5p] [%t] %c{3\} - %m%n" />
			</layout>
		</appender>
		<logger name="cn.javass" additivity="true">
			<level value="debug" />
			<appender-ref ref="file" />
		</logger>
		<root>
			<level value="error"/>
			<appender-ref ref="test" />
			<appender-ref ref="file" />
		</root>
	</log4j:configuration>	
	
6. 首先要注意，log4j.xml优先于log4j.properties，如果同时存在log4j.xml和
	log4j.properites，以log4j.xml为准。
         在log4j.properties里，控制级别的时候，只能打印出大于指定级别的所有信
	息；但是在log4j.xml中可以通过filter来完成过滤：典型的引用是只打印出某
	种级别的信息。
	<appender name="log.file" class="org.apache.log4j.DailyRollingFileAppender">
		<filter class="org.apache.log4j.varia.LevelRangeFilter">
			<param name="levelMin" value="info" />
			<param name="levelMax" value="info" />
			<param name="AcceptOnMatch" value="true" />
		</filter>
	</appender>		