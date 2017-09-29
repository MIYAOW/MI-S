[![License](https://img.shields.io/badge/license-MIT-blue.svg)](http://blog.csdn.net/fjnpysh)

# MI - API 模块  

## 技术要点

- **`Eureka Netflix`** 云端服务发现，一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移

- **`Hystrix Netflix`** 熔断器，容错管理工具，通过熔断机制控制服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力

### V1.0 releases

- 摘录要点
  
  - `完成服务注册中心可集群配置化、高可用性`
  
  - `完成消费者双模式消费` `(常用：Ribbon模式)`
  
  
- 注意事项 
  
  - 若远程调用服务，可能因为hostname名称识别不了。Win系统下# Windx C:\Windows\System32\drivers\etc 设置 指定好对应的hostname即可
  

### 主要模块：

- 注册中心的服务与发现 Eureka server；
  
   - ` √ mi-eureka-server`(注册中心一)
   
   - ` √ mi-eureka-server-bak`(注册中心二)
   
- 服务注册与消费 Eureka Client

   - ` √ mi-eureka-client` (服务提供者一)
   
   - ` √ mi-eureka-client-api` (服务提供者二)
   
   - ` √ mi-eureka-consumer` (服务消费者 双模式案例 Feign Ribbon)
    
- 更新 `README.md` 等相关文档和示例；
