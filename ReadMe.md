#转账模拟小程序

##代码结构
* src/main/java下是我写的程序主体，模拟了一个转账的接口
* src/main/resources下是相关配置文件
* src/main/webapp下是web资源
* src/main/test下，我写了一个多线程的测试：
```
最初：zhangsan:10000000元， lisi:0
同时起100个线程，每个线程每次转10元，转10000次。
```
##依赖环境
* gradle
* jdk 8

##项目导入Eclipse
1. 在项目根目录下运行gradle eclipse
2. 从Eclipse中，按照普通项目导入流程导入该项目

##运行步骤
1. 在项目根目录下执行gradle jettyRun
2. 页面访问地址：http://localhost:8080/transferCenter/index.html
