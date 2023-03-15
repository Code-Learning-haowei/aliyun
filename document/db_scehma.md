#### 用户表

|字段名|数据类型|描述|
|----|----|----|
|id|bigint|主键，自增长|
|username|varchar(255)|用户名|
|password|varchar(255)|密码|

#### 装修项目表

|字段名|数据类型|描述|
|----|----|----|
|id|bigint|主键，自增长|
|user_id|bigint|外键，关联用户表|
|name|varchar(255)|项目名称|
|budget|decimal(10,2)|预算|
|cost|decimal(10,2)|花费|
|create_time|datetime|创建时间|
|update_time|datetime|更新时间|
