package auto.prueba.apis.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BookingIDResponse {
	
	@SerializedName("firstname")
	@Expose
	private String firstname;

	@SerializedName("lastname")
	@Expose
	private String lastname;

	@SerializedName("totalprice")
	@Expose
	private int totalprice;

	@SerializedName("depositpaid")
	@Expose
	private boolean depositpaid;

	@SerializedName("additionalneeds")
	@Expose
	private String additionalneeds;
	
	@SerializedName("bookingdates")
	@Expose
	private BookingDatesResponse bookingdates;

	public BookingDatesResponse getBookingdates() {
		return bookingdates;
	}

	public void setBookingdates(BookingDatesResponse bookingdates) {
		this.bookingdates = bookingdates;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean getDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
}
