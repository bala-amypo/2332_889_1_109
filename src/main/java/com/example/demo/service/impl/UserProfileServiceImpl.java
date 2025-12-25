@Override
public UserProfile updateUserStatus(Long id, boolean active) {
    UserProfile user = getUserById(id);
    user.setActive(active);
    return repository.save(user);
}

@Override
public UserProfile findByUserId(String userId) {
    return repository.findAll()
            .stream()
            .filter(u -> userId.equals(u.getUserId()))
            .findFirst()
            .orElseThrow(() ->
                    new ResourceNotFoundException("User not found"));
}
