
### 概要
### 如何在微服务实现灰度发布呢？

灰度发布（又名金丝雀发布）是指在黑与白之间，能够平滑过渡的一种发布方式。在其上可以进行A/B testing，即让一部分用户继续用产品特性A，一部分用户开始用产品特性B，如果用户对B没有什么反对意见，那么逐步扩大范围，把所有用户都迁移到B上面来。
有什么功能
首先我是自定义了一个灰度发布的sdk,引入该包可以实现，指定服务灰度发布，并指定灰度权重

## 项目结构说明
#### 1,test-gateway 网关服务主要控制灰度发布权重
#### 2,test-springboot-gray 需要灰度的服务
#### 3,test-springboot-normal 不需要灰度的服务
#### 4,test-springboot-normal2 不需要灰度的服务2

## 技术细节

#### 1.在网关中引入灰度发布包
```
<dependency>
<groupId>com.zbm.gray</groupId>
<artifactId>springboot-gray-starter</artifactId>
<version>1.0.0-SNAPSHOT</version>
</dependency>
```
#### 2.网关配置灰度策略
```
gray:
loadbalancer:
enabled: true
weight: 20    //灰度权重20%`
```

#### 3.灰度服务A
```
gray:
loadbalancer:
enabled: true
version: 2 //灰度版本号`
```
#### 4.网关接口调用
```
@Autowired
@Qualifier("newRestTemplate")
private RestTemplate restTemplate;
@GetMapping("/testGray")
public String testGray(){
MultiValueMap<String, String> headers=new HttpHeaders();
headers.add("version","2");
HttpEntity<?> requestEntity = new HttpEntity<>(headers);
ResponseEntity<String> exchange = restTemplate.exchange("http://test-gray/api/v1/test", HttpMethod.GET, requestEntity, String.class);
return exchange.getBody();
}
```

#### 说明：如果调用过程中不传递version,那么不会调用到灰度服务上

#### 5.原理说明
首先我们需要在灰度服务引入灰度sdk,然后发布，我们正常服务不需要引入，在网关引入并配置灰度策略，那么会根据负载均衡策略和我们配置的权重选择服务。

### 小结
具体示例代码可见github:https://github.com/zbmzbm/gray-project
需要sdk包的可以加我微信注明来意：zbmzbm00
