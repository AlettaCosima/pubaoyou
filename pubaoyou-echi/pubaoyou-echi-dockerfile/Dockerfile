#初始化镜像
FROM circleci/jdk8:0.1.1
#导入项目中代码到镜像内
ADD ./target/pubaoyou-echi-dockerfile-0.0.1-SNAPSHOT.jar /home/springboot/pubaoyou-echi-dockerfile-0.0.1-SNAPSHOT.jar
#指定端口
EXPOSE 8080
#执行命令
CMD ["java","-jar","/home/springboot/pubaoyou-echi-dockerfile-0.0.1-SNAPSHOT.jar"]
#指定维护者名称
MAINTAINER eric chentao0310@126.com