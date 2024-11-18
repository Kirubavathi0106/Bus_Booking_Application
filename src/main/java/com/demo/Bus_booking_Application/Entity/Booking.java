package com.demo.Bus_booking_Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "booking")
@Table
@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;
	@Column(name = "passenger_id")
	private int passengerId;
	@Column(name = "passenger_name")
	private String passengerName;
	@Column(name = "bus_id")
	private int busId;
	@Column(name = "bus_name")
	private String busName;
	@Column(name = "seat_qty")
	private int seatQty;
	@Column(name = "booked_price")
	private int price;
	private int amount;
	@Column(name = "booked_time")
	private LocalDateTime bookedTime;
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getSeatQty() {
		return seatQty;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBookedTime(LocalDateTime bookedTime) {
		this.bookedTime = bookedTime;
	}
}
