package auto.prueba.apis.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingAllResponse {
	
	private long bookingid;

	public long getBookingid() {
		return bookingid;
	}

	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}
}
