# RatpackHttp
## Spring Boot + Ratpack + Mybatis + Redis + kafka

```
clean package -Dmaven.compile.fork=true -Dmaven.test.skip -Dautoconfig.userProperties=../config/dev.properties
```

#### start application

```
java -jar RatpackWeb-1.0-SNAPSHOT.jar
```

#### Does not have the interface start application
```
exec nohup java -jar *.jar > out.log 2>&1&

```
```
exec nohup java -jar *.jar -port=9595 > out.log 2>&1&
```
#### Does not have the interface stop application

```
kill `lsof -t -i:9595`
```


* Howell (<th15817161961@gmail.com>)
