# SSM整合`Redis`
此项目为一个简单的SSM整合`Redis`测试项目,使用了`Redis`作为缓存.<br>
需要注意的是:<br>
* Redis是建立在本地上的,当然也能远程连接云服务器上的`Redis`
* 本次项目是在服务层的实现类中加入注解来加载缓存,不同于把`Redis`作为`Mybatis`的二级缓存这种方式,个人认为注解较为简单
