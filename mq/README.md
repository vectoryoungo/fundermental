

### Compare All Kinds of MQ performances

#### 测试机器 

型号:MacBook Pro (15-inch, 2019)

CPU:2.6 GHz Intel Core i7

内存:16 GB 2400 MHz DDR4

图形卡:Radeon Pro 555X 4 GB/Intel UHD Graphics 630 1536 MB

硬盘: 256GB SSD 

测试基于Jmeter 5.2.1 GUI 模式下，数据如下：

ActiveMQ Artemis 在1000个线程循环10次的并发情况下的吞吐量在126.8359503817762/sec 异常0%

ActiveMQ Artemis 在1000个线程循环100次的并发情况下的吞吐量在474.2955525306039/sec 异常0%

RocketMQ 在1000个线程循环100次的并发情况下的吞吐量在694.9265502207659/sec 异常12.30%

Kafka 在1000个线程循环100次的并发情况下的吞吐量在861.2225915910227/sec 异常14.51%

RabbitMQ 在1000个线程循环100次的并发情况下的吞吐量在977.8134136444083/sec 异常14.08%

测试环境一开始Kafka吞吐量很高几乎到万级别，再就是Rocket和Rabbit也是几乎万级(没错，你没看错，虽然测试下来最终看起来不到千级别)，可能是因为本机器限制，加上也没有做任何的参数优化，以及配置都是几乎默认的配置，仅供参考。

即使如此可以看书kafka以及RabbitMq是不错的选择，RabbitMQ作为开源的MQ资料和官网demo齐全生态也较好，性能也不差，值得选择。