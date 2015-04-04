修改MySQL默认最大连接数
MYSQL数据库安装完成后，默认
最大连接数是100，一般流量稍微大一点的论坛或网站
这个连接数是远远不够的，增加默认MYSQL连接数的方法有两个
方法一：进入MYSQL安装目录 打开MYSQL配置文件 my.ini 或 my.cnf查找 max_connections=100   修改为 max_connections=1000 服务里重起MYSQL即可