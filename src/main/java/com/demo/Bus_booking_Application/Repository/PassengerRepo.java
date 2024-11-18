package com.demo.Bus_booking_Application.Repository;

import com.Project.Bus_Booking_System.Entity.Passenger;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Tag(name = "Passenger - Rest API Controllers", description = "Passenger API")
@RepositoryRestResource(collectionResourceRel = "passenger", path="passenger")
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

	public Passenger findByEmail(@Param("email") String email);
}
