package com.eamapp.crud.crudspringboot.repositorie;

import com.eamapp.crud.crudspringboot.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long>{
}
//esto es para crear una interface, JPA = trae todo lo necesario para la manipulacion de datos