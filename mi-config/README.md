[![License](https://img.shields.io/badge/license-MIT-blue.svg)](http://blog.csdn.net/fjnpysh)

# MI - Config 模块  

## 配置中心

### V1.0 releases

该模块功能只适合开发目前还不是很完善。所以作为案例供大家参考使用。

发布 V1.0 正式版。

- 提供**服务端**与**客户端**支持
- 集中式 管理分布式环境下的应用配置
- 基于 Spring 环境，无缝 与 Spring 应用集成
- 可用于 任何 语言开发的程序
- 默认实现基于 git 仓库，可以进行 版本管理
- 可替换 自定义实现

### 主要更新：

####  **mi-cloud-config-server** 作为配置中心服务端

  - 拉取配置时更新 git 仓库副本，保证是最新结果
  - 支持数据结构丰富，yml, json, properties 等
  - 配合 eureke 可实现服务发现，配合 cloud bus 可实现配置推送更新
  - 配置存储基于 git 仓库，可进行版本管理
  - 简单可靠，有丰富的配套方案
  
####  **mi-cloud-config-client** 默认客户端实现
  - 支持IP地址调用
  - 支持注册服务中心配置

####  **mi-cloud-config-repo** 配置文件存储
  - 文件格式{application}-{profile}.properties对应的配置文件，{label}对应git上不同的分支，默认为master
    
    
- 更新 `README.md` 等相关文档和示例；
