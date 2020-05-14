# FROM oracle/graalvm-ce:20.0.0-java8 as graalvm
# For JDK 11
FROM oracle/graalvm-ce:20.0.0-java11 as graalvm

# RUN gu install native-image
RUN curl -o native-image.jar http://dev.kinco.top/mirror/graalvm/native-image-installable-svm-java11-linux-amd64-20.0.0.jar
RUN gu install -L /home/native-image.jar

COPY . /home/app/hello-native
WORKDIR /home/app/hello-native
RUN native-image --no-server -cp target/hello-native-*.jar

FROM frolvlad/alpine-glibc
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.tuna.tsinghua.edu.cn/g' /etc/apk/repositories
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/hello-native/hello-native /app/hello-native
ENTRYPOINT ["/app/hello-native"]
