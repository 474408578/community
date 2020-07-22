package com.nowcoder.community.util;

/**
 * @author xschen
 *
 *
 */

public class RedisKeyUtil {

    // 拼接key的常量
    private static final String SPLIT = ":";
    // 实体的常量前缀
    private static final String PREFIX_ENTITY_LIKE = "like:entity";

    // 某个实体的赞, 得出实体的赞的key，set集合表示点赞的人。
    // key: like:entity:entityType:entityId -> value: set(userId)  set集合作为value
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }



}
