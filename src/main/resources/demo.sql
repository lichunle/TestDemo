CREATE TABLE `coupon_type`(
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`coupon_type_code` CHAR(8) NOT NULL COMMENT '券类型编码',
	`coupon_name` VARCHAR(50) NOT NULL COMMENT '券类型名称',
	`issue_count` BIGINT(20) UNSIGNED NOT NULL DEFAULT 999999999999999999 COMMENT '券总发行数量, 0表示不限制, 其他表示实际限制数',
	`issued_count` BIGINT(20) UNSIGNED NOT NULL COMMENT '券已发行数量, 每次发行一张券给用户后该字段+1, 值不能超过issue_count, 避免sum计算',
	`coupon_category` varchar(32) NOT NULL COMMENT '券类型: 满减券(MONEYOFF:10), 折扣券(DISCOUNT:11), 现金券(CASH:12)',
	`coupon_category_value1` bigint(20) UNSIGNED NOT NULL COMMENT '券类型对应的第1个值',
	`coupon_category_value2` bigint(20) UNSIGNED DEFAULT NULL COMMENT '券类型对应的第2个值(如果有的话)',
	`valid_date_type` varchar(16) NOT NULL COMMENT '有效期类型: 顺延有效期:POSTPONED, 固定失效期:ENDFIXED, 固定有效期间:RANGEFIXED',
	`valid_date_value1` bigint(20) NOT NULL COMMENT '有效期类型对应的第一个值',
	`valid_date_value2` bigint(20) DEFAULT NULL COMMENT '有效期类型对应的第二个值',
	`status` varchar(8) NOT NULL DEFAULT 'NEW' COMMENT '券的状态, 新建:NEW, 有效[启用]:VALID, 无效[禁用]:INVALID',
	`logo_url` varchar(1024) DEFAULT NULL COMMENT '券logo样式图片url地址',
	`operate_remark` varchar(200) DEFAULT NULL COMMENT '操作备注',
	`created_by` varchar(32) NOT NULL DEFAULT 'unknown' COMMENT '创建人',
    `updated_by` varchar(32) NOT NULL DEFAULT 'unknown' COMMENT '更新人',
    `approved_by` varchar(32) DEFAULT NULL COMMENT '审批人',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `approve_time` datetime DEFAULT NULL COMMENT '审核通过时间, 即规则生效时间',
	`is_deleted` int(11) NOT NULL DEFAULT '0',
    `version` bigint(20) NOT NULL DEFAULT '0',
	UNIQUE KEY `uk_coupon_type_code` (`coupon_type_code`)
) ENGINE=InnoDB COMMENT '券基本信息关系表';

DROP TABLE IF EXISTS `coupon_type_ext`;
CREATE TABLE `coupon_type_ext`(
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`coupon_type_code` char(8) NOT NULL COMMENT '券类型编码',
	`remark` text DEFAULT NULL COMMENT '券说明',
	UNIQUE KEY `uk_coupon_type_code` (`coupon_type_code`)
) ENGINE=InnoDB COMMENT '券扩展信息关系表';


DROP TABLE IF EXISTS `coupon_store_scope`;
CREATE TABLE `coupon_store_scope`(
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`coupon_type_code` char(8) NOT NULL COMMENT '券类型编码',
	`merchant_code` varchar(16) NOT NULL COMMENT '可使用的商户编码, 如果是全部商户则用ALL代替',
    `store_code` varchar(16) NOT NULL COMMENT '可使用的门店编码, 如果是全部门店则用ALL代替',
	`status` varchar(8) NOT NULL DEFAULT 'VALID' COMMENT '状态, 有效:VALID, 无效:INVALID',
	`is_deleted` int(11) NOT NULL DEFAULT '0',
    `version` bigint(20) NOT NULL DEFAULT '0',
	UNIQUE KEY `uk_coupon_store_scope_1` (`coupon_type_code`, `merchant_code`, `store_code`)
) ENGINE=InnoDB COMMENT '券可用范围关系表';


DROP TABLE IF EXISTS `coupon_pay_scope`;
CREATE TABLE `coupon_pay_scope`(
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`coupon_type_code` char(8) NOT NULL COMMENT '券类型编码',
	`bank_card_type` varchar(16) NOT NULL default 'D' COMMENT '支付卡类型, D:储蓄卡, C:信用卡, 如果是全部支付方式用ALL代替',
    `bank_code` varchar(16) NOT NULL COMMENT '支付卡编号, 如果余额支付bank_code为BALANCE且bank_card_type为D, 如果是全部支付方式用ALL代替',
	`status` varchar(8) NOT NULL DEFAULT 'VALID' COMMENT '状态, 有效:VALID, 无效:INVALID',
	`is_deleted` int(11) NOT NULL DEFAULT '0',
    `version` bigint(20) NOT NULL DEFAULT '0',
	UNIQUE KEY `uk_coupon_pay_scope_1` (`coupon_type_code`, `bank_code`, `bank_card_type`)
) ENGINE=InnoDB COMMENT '券可用支付方式关系表';


DROP TABLE IF EXISTS `coupon_cost_share`;
CREATE TABLE `coupon_cost_share`(
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`coupon_type_code` char(8) NOT NULL COMMENT '券类型编码',
	`share_merchant_code` varchar(16) NOT NULL COMMENT '分摊商户编码',
    `share_rate` DECIMAL(5,2) NOT NULL COMMENT '分摊比例',
	`is_deleted` int(11) NOT NULL DEFAULT '0',
    `version` bigint(20) NOT NULL DEFAULT '0',
	UNIQUE KEY `uk_coupon_cost_share_1` (`coupon_type_code`, `share_merchant_code`)
) ENGINE=InnoDB COMMENT '券成本分摊关系表';


DROP TABLE IF EXISTS `user_coupon`;
CREATE TABLE `user_coupon`(
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`user_id` bigint(20) UNSIGNED NOT NULL COMMENT '支付用户ID',
	`member_id` varchar(32) NOT NULL COMMENT '会员ID',
	`coupon_code` char(32) NOT NULL COMMENT '券编号',
	`coupon_type_code` char(8) NOT NULL COMMENT '券类型编码',
	`coupon_name` VARCHAR(50) NOT NULL COMMENT '券类型名称',
	`coupon_category` varchar(32) NOT NULL COMMENT '券类型: 满减券(MONEYOFF:10), 折扣券(DISCOUNT:11), 现金券(CASH:12)',
	`coupon_category_value1` bigint(20) UNSIGNED NOT NULL COMMENT '券类型对应的第1个值',
	`coupon_category_value2` bigint(20) UNSIGNED DEFAULT NULL COMMENT '券类型对应的第2个值(如果有的话)',
	`start_date` datetime NOT NULL COMMENT '券的开始(生效)日期',
	`end_date` datetime NOT NULL COMMENT '券的结束(过期)日期',
	`status` varchar(8) NOT NULL DEFAULT 'VALID' COMMENT '用户的券的状态, 有效:VALID, 冻结:FROZEN, 已经使用:USED, 作废:INVALID, 过期:OVERDUE',
	`gen_type` varchar(16) NOT NULL DEFAULT 'EVENT' COMMENT '券生成类型: 营销事件:EVENT, 手工补券:MANUAL',
	`event_code` varchar(16) NOT NULL COMMENT '营销事件编码',
	`issue_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '券发送时间',
	`sys_id` varchar(16) DEFAULT NULL COMMENT '系统ID',
	`order_no` varchar(64) DEFAULT NULL COMMENT '支付系统为每一个支付单分配的一个唯一编号',
	`merchant_trade_no` varchar(64) DEFAULT NULL COMMENT '商户的订单交易号',
	`use_merchant_code` varchar(64) DEFAULT NULL COMMENT '券使用的商户编码',
	`use_store_code` varchar(64) DEFAULT NULL COMMENT '券使用的门店编码',
	`use_time` datetime DEFAULT NULL COMMENT '券的使用时间',
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`is_deleted` int(11) NOT NULL DEFAULT '0',
    `version` bigint(20) NOT NULL DEFAULT '0',
	UNIQUE KEY `uk_coupon_code` (`coupon_code`)
) ENGINE=InnoDB COMMENT '用户的券表';

DROP TABLE IF EXISTS `user_coupon_trace`;
CREATE TABLE `user_coupon_trace`(
	`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`user_id` bigint(20) UNSIGNED NOT NULL COMMENT '支付用户ID',
	`member_id` varchar(32) NOT NULL COMMENT '会员ID',
	`coupon_code` char(32) NOT NULL COMMENT '券编号',
	`coupon_type_code` char(8) NOT NULL COMMENT '券类型编码',
	`status` varchar(8) NOT NULL DEFAULT 'VALID' COMMENT '用户的券的状态, 有效:VALID, 冻结:FROZEN, 已经使用:USED, 作废:INVALID, 过期:OVERDUE',
	`use_merchant_code` varchar(64) NOT NULL COMMENT '券使用的商户编码',
	`use_store_code` varchar(64) NOT NULL COMMENT '券使用的门店编码',
	`trace_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '券变更时间,例如发行时间,冻结时间, 使用时间等',
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`is_deleted` int(11) NOT NULL DEFAULT '0',
    `version` bigint(20) NOT NULL DEFAULT '0'
) ENGINE=InnoDB COMMENT '券状态变更(生命周期)表';
