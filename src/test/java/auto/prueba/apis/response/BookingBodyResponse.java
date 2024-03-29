package auto.prueba.apis.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingBodyResponse {
	
	@SerializedName("bookingid")
	@Expose
	private String bookingid;

	@SerializedName("booking")
	@Expose
	private BookingIDResponse booking;

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	public BookingIDResponse getBooking() {
		return booking;
	}

	public void setBooking(BookingIDResponse booking) {
		this.booking = booking;
	}
}
