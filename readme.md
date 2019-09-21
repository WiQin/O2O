#校园商铺平台项目实战

##实体类：
    1.区域  ID,权重，创建时间，修改时间，名称
    2.用户信息 ID,姓名，头像地址，邮箱，性别，状态，身份标识（顾客，店家，管理员），创建时间，修改时间
        2.1微信账号
        2.2本地账号
    3.头条
    4.店铺类别
    5.店铺
    6.商品类别
    7.商品
        7.1详情图片
        
##sql脚本
数据库名--o2o  
use o2o;  
 
create table 'tb_area'(  
    'area_id' int(2) not null auto_increment,  
    'area_name' varchar(200) nut null,  
    'priority' int(2) default '0',  
    'create_time' datetime default null,  
    'update_time' datetime default null,
    primary key('area_id),
    unique key'UK_AREA'('area_name')
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8  

create table 'tb_person_info'(  
    'user_id' int(10) not null auto_increment,  
    'name' varchar(32) default null,  
    'img_url' varchar(1024) default null,  
    'email' varchar(1024) default null,  
    'gender' varchar(2) default null,  
    'enable_status' int(2) not null default '0' comment '0:禁止,1:允许,  
    'user_type' int(2) not null default '1' comment '1.顾客 2.店家 3.管理员',  
    'create_time' datetime default null,  
    'update_time' datetime default null,
    primary key('user_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8
