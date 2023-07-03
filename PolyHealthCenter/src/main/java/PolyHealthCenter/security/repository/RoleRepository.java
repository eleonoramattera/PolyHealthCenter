package PolyHealthCenter.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PolyHealthCenter.security.entity.ERole;
import PolyHealthCenter.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
