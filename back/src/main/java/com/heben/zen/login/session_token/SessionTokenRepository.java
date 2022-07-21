package com.heben.zen.login.session_token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface SessionTokenRepository extends JpaRepository<SessionToken, Long> {

    @Query("SELECT t FROM SessionToken t WHERE t.username = ?1 AND t.token = ?2")
    Optional<SessionToken> findSessionToken(String username, String token);

    @Query(value = "SELECT expired FROM session_token WHERE username = ? AND token = ?", nativeQuery = true)
    boolean isSessionTokenExpired(String username, String token);

}
