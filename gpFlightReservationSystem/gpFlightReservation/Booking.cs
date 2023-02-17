using System;
namespace gpFlightReservation
{
    public class Booking
    {
        public Customer customer;
        public Flight flight;
        public int bookingId;
        public string date;

        public Booking(Customer customer, Flight flight, int bookingId, string date)
        {
            this.customer = customer;
            this.flight = flight;
            this.bookingId = bookingId;
            this.date = date;

        }

        public Customer getCustId()
        {
            return customer;
        }

        public Flight getFlightId()
        {
            return flight;
        }

        public int getBookingId()
        {
            return bookingId;
        }

        public string getDate()
        {
            return date;
        }

        public string toString()
        {
            return "\n Date: " + date +
                   "\n Booking ID: " + bookingId +
                   "\n Customer: " + customer.getFirstName() +
                   "\n Flight Number: " + flight.getFlightNum();
        }
    }
}

