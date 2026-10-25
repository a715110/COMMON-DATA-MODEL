package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.UserMessagingIdentifier;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessagingIdentifierRepository extends JpaRepository<UserMessagingIdentifier, Integer> {

  /**
   * Find all identifiers for a user
   */
  List<UserMessagingIdentifier> findByLoginId(String loginId);

  /**
   * Find identifier by user and channel type
   */
  Optional<UserMessagingIdentifier> findByLoginIdAndChannelType(String loginId, String channelType);

  /**
   * Check if identifier exists for user and channel
   */
  boolean existsByLoginIdAndChannelType(String loginId, String channelType);

  /**
   * Find all verified identifiers for a user
   */
  List<UserMessagingIdentifier> findByLoginIdAndVerifiedIndTrue(String loginId);

  /**
   * Delete all identifiers for a user
   */
  void deleteByLoginId(String loginId);

  /**
   * Delete identifier by user and channel type
   */
  void deleteByLoginIdAndChannelType(String loginId, String channelType);
}