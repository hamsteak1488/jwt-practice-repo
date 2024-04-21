package com.mirae.commerce.auth.jwt.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}