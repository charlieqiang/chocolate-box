create database chocolate_box_order_prd;
use chocolate_box_order_prd;

create table if not exists order_info
(
    id               bigint                               not null primary key comment '主键',
    order_no         varchar(50)                          null comment '订单编号',
    order_qty      int                                  null comment '订单数量',
    order_amount     decimal(16, 6)                       null comment '订单金额',
    custom_id        bigint                               null comment '客户id',
    item_id          bigint                               null comment '物品id',
    creator          varchar(100)                         null comment '创建者',
    create_time      timestamp  default CURRENT_TIMESTAMP not null comment '创建的日期',
    modifier_id      bigint                               null comment '修改者id',
    modifier         varchar(100)                         null comment '修改者',
    last_modify_time timestamp  default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    deleted          tinyint(1) default 0                 not null comment '是否删除字段：0-未删除，1-已删除',
    record_version   int(10)    default 1                 null comment '版本号'
)
    comment '订单信息' charset = utf8mb4;