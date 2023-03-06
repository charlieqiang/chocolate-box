create database chocolate_box_storage_prd;
use chocolate_box_storage_prd;

create table if not exists inventory
(
    id               bigint                               not null primary key comment '主键',
    item_id          bigint                               null comment '物品id',
    inventory_qty    int                                  null comment '库存数量',
    creator          varchar(100)                         null comment '创建者',
    create_time      timestamp  default CURRENT_TIMESTAMP not null comment '创建的日期',
    modifier_id      bigint                               null comment '修改者id',
    modifier         varchar(100)                         null comment '修改者',
    last_modify_time timestamp  default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted          tinyint(1) default 0                 not null comment '是否删除字段：0-未删除，1-已删除',
    record_version   int(10)    default 1                 null comment '版本号'
)
    comment '库存表' charset = utf8mb4;