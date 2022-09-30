## 创建mysql**数据**目录文件夹
```shell
MYSQL_PATH=/your/own/path
mkdir $MYSQL_PATH
```

## docker启动mysql
```
docker run --name rent-manage -p 33306:3306 -e MYSQL_ROOT_PASSWORD=ohsecret -e MYSQL_DATABASE=rent-manage -v $(pwd)/deployment/mysql:/docker-entrypoint-initdb.d -v $MYSQL_PATH:/var/lib/mysql -d mysql:8.0.30 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci 
```

## 查看数据库是否初始化成功，客户端是否可以成功连接

## notice
- 镜像启动时自动运行目录下initdb.sql