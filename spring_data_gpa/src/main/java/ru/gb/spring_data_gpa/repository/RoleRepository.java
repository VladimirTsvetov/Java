package ru.gb.spring_data_gpa.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.spring_data_gpa.model.Role;

public interface RoleRepository extends CrudRepository<Role,Long> {
}
