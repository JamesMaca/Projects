using System;
namespace gpFlightReservation
{
    public class BookingManager
    {
        public Booking[] bList;
        public int numBookings;
        public int maxBooking;

        public BookingManager()
        {
            maxBooking = 100;
            numBookings = 0;
            bList = new Booking[maxBooking];
        }

        public void makeBooking(Customer customer, Flight flight, string date)
        {
            if (flight.addCust(customer))
            {
                int bookingNum = numBookings + 1;
                bList[numBookings] = new Booking(customer, flight, bookingNum, date);
                numBookings++;
                Console.WriteLine("\nFlight Booked! \nBooking number: " + bookingNum );
            }
            else
            {
                Console.WriteLine("Sorry this flight is full \n");
            }


        }

        public string viewAllBookings()
        {
            string s = "--- Booking List ---";
            for (int i = 0; i < numBookings; i++)
            {
                s += bList[i].toString() + "\n";
            }
            return s;
        }
    }
}

