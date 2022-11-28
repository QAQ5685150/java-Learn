## jar包部署linux服务器命令



#### 后台运行部署任务，日志重定向到.log文件(没有写权限的情况需要重定向)

nohup java -jar xxx-0.3.0-SNAPSHOT.jar > xxx.log 2>&1 &



#### 实时查看日志 

tail -200f sync-214.log  #实时查看后200行



#### java -jar命令 (参数必须在 xxx.jar之前)

//堆内存最小空间 最大空间
-Xms1024m -Xmx2048m 

//元空间大小
-XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m 

//使用Java自带的 ByteBuffer.allocateDirect(size) 或者直接 new DirectByteBuffer(capacity) , 这样受-XX:MaxDirectMemorySize 这个JVM参数的限制. 其实底层都是用的Unsafe#allocateMemory,区别是对大小做了限制. 如果超出限制直接OOM.
-XX:MaxDirectMemorySize=256m 

//日志文件路径
-Xloggc:/home/xxx/logs/gc_20220725.log 

//打印日志时间  垃圾收集信息
-XX:+PrintGCDateStamps -XX:+PrintGCDetails

-Xms1024m -Xmx2048m -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -XX:MaxDirectMemorySize=256m -Xloggc:/home/xxx/logs/gc_20220725.log -XX:+PrintGCDateStamps -XX:+PrintGCDetails

[e.g : nohup java -jar -Xms1024m -Xmx2048m -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -XX:MaxDirectMemorySize=256m -XX:+PrintGCDateStamps -XX:+PrintGCDetails yz-datasync-214-0.3.0-SNAPSHOT.jar > sync-214.log 2>&1 &] => [后台部署yz-datasync-214-0.3.0-SNAPSHOT.jar，最小堆1G 最大堆2G，元空间256M 直接内存256M(使用NIO包相关) 打印GC信息 日志重定向到sync-214.log文件(前面没有路径默认在当前文件夹下)]