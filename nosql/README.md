# nosql performance test

### redis


redis在 Running in standalone mode version5.0.5版本 64bit环境下，1000Thread循环100次的情况下，存的吞吐是828.5347363188201/sec

redis在Running in standalone mode version5.0.5版本 64bit环境下，1000Thread循环100次的情况下，取的吞吐量是690.5743506874668/sec

### 限流

此处做了两处限流的demo，

一是根据Google的ratelimiter方式，参考了https://segmentfault.com/a/1190000016393473

二是根据redis实现的限流方式，参考了https://blog.51cto.com/14230003/2419614