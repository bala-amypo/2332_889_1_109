public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findByUserId(String userId);
}
