//James MacAloney
//Yasaman Mirvahabi Sabet
//Stefan Kepinski
//Ronan Behan

using System;

namespace gpFlightReservation
{
    class Program
    {
        static void Main(string[] args)
        {
            int choice = 0;
            CustomerManager cm = new CustomerManager();
            FlightManager fm = new FlightManager();
            BookingManager bm = new BookingManager();

            while(choice != 4)
            {
                Console.WriteLine("-------------------------------------");
                Console.WriteLine("XYZ Airline Limited.");
                Console.WriteLine("Please select an option bellow:\n");
                Console.WriteLine("1: Customer");
                Console.WriteLine("2: Flights");
                Console.WriteLine("3: Bookings");
                choice = Convert.ToInt32(Console.ReadLine());

                switch(choice)
                {
                    case 1:
                        int custChoice = 0;
                        while(custChoice != 4)
                        {
                            Console.WriteLine("\n-------------------------------------");
                            Console.WriteLine("XYZ Airline Limited.");
                            Console.WriteLine(" Customer Menu");
                            Console.WriteLine("Please select an option bellow:\n");
                            Console.WriteLine("1: Add Customer");
                            Console.WriteLine("2: View Cutomers");
                            Console.WriteLine("3: Delete Cutomer");
                            Console.WriteLine("4: Return to Main Menu");

                            custChoice = Convert.ToInt32(Console.ReadLine());

                            if (custChoice == 1)
                            {
                                Console.Write("\n What is the Customer First Name: ");
                                string fName = Console.ReadLine();

                                Console.Write(" What is the Customer Last Name: ");
                                string lName = Console.ReadLine();

                                Console.Write(" Customer Phone number: ");
                                string phoneNum = Console.ReadLine();

                                Console.Write(" What is the Customers email: ");
                                string email = Console.ReadLine();

                                cm.addCustomer(fName, lName, phoneNum, email, 0);
                            }
                            if(custChoice == 2)
                            {
                                Console.Write(cm.printAllCustomers());
                            }
                            if(custChoice == 3)
                            {
                                Console.Write("\n ID of cutomer to be deleted: ");
                                int dltID = Convert.ToInt32(Console.ReadLine());
                                cm.removeCustomer(dltID);
                            }
                        }
                        break;

                    case 2:
                        int flightChoice = 0;
                        while(flightChoice != 5)
                        {
                            Console.WriteLine("\n-------------------------------------");
                            Console.WriteLine("XYZ Airline Limited.");
                            Console.WriteLine(" Booking Menu");
                            Console.WriteLine("Please select an option bellow:\n");
                            Console.WriteLine("1: Add Flight");
                            Console.WriteLine("2: View Flights");
                            Console.WriteLine("3: View a particular Flight");
                            Console.WriteLine("4: Delete a Flight");
                            Console.WriteLine("5: Return to Main Menu");

                            flightChoice = Convert.ToInt32(Console.ReadLine());

                            if (flightChoice == 1)
                            {
                                Console.Write("\n Where is the flight going: ");
                                string destination = Console.ReadLine();

                                Console.Write(" What is the flight origin: ");
                                string origin = Console.ReadLine();

                                Console.Write(" How many seats does the flight have: ");
                                int seats = Convert.ToInt32(Console.ReadLine());


                                fm.addFlight(destination, origin, seats);
                                
                            }
                            else if(flightChoice == 2)
                            {
                                Console.WriteLine(fm.viewAllFlights());
                            }
                            else if(flightChoice == 3)
                            {
                                Console.Write("\n Flight number you want to see: ");
                                int flNum = Convert.ToInt32(Console.ReadLine());
                                Console.WriteLine(fm.viewFlight(flNum));
                            }
                            else if(flightChoice == 4)
                            {
                                Console.Write("\n Flight number you want to delete: ");
                                int flNum = Convert.ToInt32(Console.ReadLine());
                                fm.removeFlight(flNum);
                            }
                        }
                        break;


                    case 3:
                        int bookingChoice = 0;
                        while (bookingChoice != 3)
                        {
                            Console.WriteLine("\n-------------------------------------");
                            Console.WriteLine("XYZ Airline Limited.");
                            Console.WriteLine(" Customer Menu");
                            Console.WriteLine("Please select an option bellow:\n");
                            Console.WriteLine("1: Make Booking");
                            Console.WriteLine("2: View Bookings");
                            Console.WriteLine("3: Back to Main Menu");
                            bookingChoice = Convert.ToInt32(Console.ReadLine());

                            if (bookingChoice == 1)
                            {
                                Console.WriteLine(cm.printAllCustomers());
                                Console.WriteLine(fm.viewAllFlights());

                                Console.Write("\n   Customer ID to make booking: ");
                                int custId = Convert.ToInt32(Console.ReadLine());

                                Console.Write(" Flight Number to make booking: ");
                                int flightNum = Convert.ToInt32(Console.ReadLine());

                                Customer x = cm.getCustomer(custId);
                                Flight y = fm.getFlight(flightNum);
                                string date = DateTime.Now.ToString(@"MM\/dd\/yyyy h\:mm tt");
                                if(x != null && y != null)
                                {
                                    bm.makeBooking(x, y, date);
                                    
                                }
                                else
                                {
                                    if(x == null)
                                    {
                                        Console.WriteLine("CUSTOMER DOES NOT EXIST");

                                    }
                                    if(y == null)
                                    {
                                        Console.WriteLine("FLIGHT DOES NOT EXIST");

                                    }
                                }
                            }
                            if(bookingChoice == 2)
                            {
                                Console.WriteLine(bm.viewAllBookings());
                            }
                        }
                        break;

                    
                }
            }

        }

    }
}

