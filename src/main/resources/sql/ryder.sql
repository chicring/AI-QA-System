-- 题目分类表
CREATE TABLE `qa_category` (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                               `category_name` varchar(50) NOT NULL COMMENT '分类名称',
                               `category_level` int unsigned DEFAULT '1' NOT NULL COMMENT '标签层级 1:一级标签 2:二级标签',
                               `image_url` varchar(256) DEFAULT NULL COMMENT '图标连接',
                               `description` varchar(256) DEFAULT NULL COMMENT '描述',
                               `parent_category_id` bigint DEFAULT NULL COMMENT '父分类ID',
                               `sort_num` int unsigned NOT NULL DEFAULT '0' COMMENT '排序号',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                               `creator` varchar(255) NULL DEFAULT NULL COMMENT '创建者',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='题目分类表';

-- 标签表（支持分级）
CREATE TABLE `qa_tag` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                          `tag_name` varchar(50) NOT NULL COMMENT '标签名称',
                          `category_id` bigint DEFAULT NULL COMMENT '分类ID',
                          `sort_num` int unsigned NOT NULL DEFAULT '0' COMMENT '排序号',
                          `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                          `creator` varchar(255) NULL DEFAULT NULL COMMENT '创建者',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标签表';

-- 题目标签关联表
CREATE TABLE `qa_mapping` (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                              `question_id` bigint NOT NULL COMMENT '题目ID',
                              `category_id` bigint NOT NULL  COMMENT '分类ID',
                              `tag_id` bigint NOT NULL COMMENT '标签ID',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='题目标签关联表';

-- 题目表
CREATE TABLE `qa_question` (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                               `question_id` bigint NOT NULL COMMENT '题目ID',
                               `question_title` varchar(255) NOT NULL COMMENT '题目标题',
                               `question_tips` varchar(255) DEFAULT NULL COMMENT '题目提示',
                               `difficulty` int unsigned NOT NULL DEFAULT '2' COMMENT '难度等级 1:简单 2:中等 3:困难',
                               `view_count` int unsigned NOT NULL DEFAULT '0' COMMENT '浏览次数',
                               `question_status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态 1:正常 0:禁用',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                               `creator` varchar(255) NULL DEFAULT NULL COMMENT '创建者',
                               `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除 0: 未删除 1: 已删除',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='题目表';

-- 题目答案表
CREATE TABLE `qa_answer` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                             `question_id` bigint NOT NULL COMMENT '题目ID',
                             `question_answer` text NOT NULL COMMENT '答案内容',
                             `extended_filed` varchar(200) NULL COMMENT '额外内容',
                             `answer_status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态 1:正常 0:禁用',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                             `creator` varchar(255) NULL DEFAULT NULL COMMENT '创建者',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='题目答案表';


CREATE TABLE `qa_question_history` (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                       `username` varchar(36) NOT NULL COMMENT '用户名',
                                       `question_id` bigint NOT NULL COMMENT '题目ID',
                                        `status` int NOT NULL DEFAULT '1' COMMENT '状态 1:看过 2:已掌握 3:待复习',
                                       `view_count` int unsigned NOT NULL DEFAULT '1' COMMENT '浏览次数',
                                       `last_view_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次查看时间',
                                       `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                       `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='题目历史记录表';

CREATE TABLE `qa_question_favorite` (
                                        `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                        `username` varchar(36) NOT NULL COMMENT '用户名',
                                        `question_id` bigint NOT NULL COMMENT '题目ID',
                                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                        `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                        `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='题目收藏表';


CREATE TABLE `sys_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                            `username` varchar(36) NOT NULL COMMENT '用户名',
                            `password` varchar(255) NULL DEFAULT NULL COMMENT '密码',
                            `nickname` varchar(255) NULL DEFAULT NULL COMMENT '昵称',
                            `email` varchar(255) NULL DEFAULT NULL COMMENT '邮箱',
                            `mobile` varchar(255) NULL DEFAULT NULL COMMENT '手机号',
                            `sex` int NULL DEFAULT NULL COMMENT '性别：1-男性，2-女性',
                            `avatar` text NULL COMMENT '头像（Base64）',
                            `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用：1-启用，0-禁用',
                            `login_ip` varchar(255) NULL DEFAULT NULL COMMENT '最近登录IP',
                            `login_date` datetime(6) NULL DEFAULT NULL COMMENT '最近登录时间',
                            `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                            `creator` varchar(255) NULL DEFAULT NULL COMMENT '创建者',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

CREATE TABLE `sys_role` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                            `name` varchar(255) NULL DEFAULT NULL COMMENT '角色名称',
                            `level` int NULL DEFAULT NULL COMMENT '角色级别：0-9，数字越小级别越高',
                            `type` tinyint NULL DEFAULT NULL COMMENT '角色类型：1-内置，2-自定义',
                            `remark` varchar(255) NULL DEFAULT NULL COMMENT '备注',
                            `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                            `creator` varchar(255) NULL DEFAULT NULL COMMENT '创建者',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic COMMENT='角色表';


CREATE TABLE `sys_permission` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
                                  `name` varchar(255) NULL DEFAULT NULL COMMENT '权限名称',
                                  `scope` varchar(255) NULL DEFAULT NULL COMMENT '权限范围',
                                  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                  `creator` varchar(255) NULL DEFAULT NULL COMMENT '创建者',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic COMMENT='权限表';

CREATE TABLE `sys_user_role` (
                                 `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                 `username` varchar(255) NULL DEFAULT NULL COMMENT '用户名',
                                 `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
                                 `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                 `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                 `creator` varchar(255) NULL DEFAULT NULL COMMENT '创建者',
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `idx_username`(`username` ASC) USING BTREE,
                                 INDEX `idx_role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic COMMENT='用户角色关联表';


CREATE TABLE `sys_role_permission` (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                       `role_id` bigint NOT NULL COMMENT '角色ID',
                                       `permission_id` bigint NOT NULL COMMENT '权限ID',
                                       `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                       `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                       `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
                                       PRIMARY KEY (`id`) USING BTREE,
                                       CONSTRAINT `sys_role_permission_sys_permission_FK` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                       CONSTRAINT `sys_role_permission_sys_role_FK` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic COMMENT='角色权限关联表';


CREATE TABLE `sys_operation_log`  (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作内容',
                                      `method_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求方法',
                                      `request_params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求参数',
                                      `operator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作者',
                                      `operation_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
                                      `time_taken` bigint NULL DEFAULT NULL COMMENT '耗时',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;