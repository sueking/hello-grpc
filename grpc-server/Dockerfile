FROM maven:3.5.2 as builder


WORKDIR /app

COPY src/ ./src
COPY pom.xml .


# 编译打包 (jar包生成路径：/app/target)
RUN mvn package -Dmaven.test.skip=true


FROM openjdk:8-jre-alpine


WORKDIR /app

COPY --from=builder /app/target/grpc-server-1.0-SNAPSHOT.jar .
EXPOSE 50051
# 运行main类
CMD java -cp grpc-server-1.0-SNAPSHOT.jar cn.sueking.grpc.HelloWorldServer