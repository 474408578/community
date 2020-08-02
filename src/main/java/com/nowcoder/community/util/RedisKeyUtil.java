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

    private static final String PREFIX_USER = "like:user";

    private static final String PREFIX_FOLLOWEE = "followee";
    private static final String PREFIX_FOLLOWER = "follower";

    // 某个实体的赞, 得出实体的赞的key，set集合表示点赞的人。
    // like:entity:entityType:entityId -> set(userId)  set集合作为value
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }

    // 某一个用户的赞
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER + SPLIT + userId;
    }

    // 某个用户关注的实体
    // followee:userId:entityType -> zset(entityId, now)
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    // 某个实体拥有的粉丝
    // follower:entityType:entityId -> zset(userId, now)
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }

}
