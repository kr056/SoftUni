using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_VarkingInvalidation
{
    class Program
    {
        static void Main(string[] args)
        {

            var n = int.Parse(Console.ReadLine());

            var userNames = new List<string>();

            var database = new Dictionary<string, string>();

            var error = true;

            var licensePlate = "";
            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine();

                var tokens = input.Split();
                var command = tokens[0];
                var username = tokens[1];

                if (tokens.Length > 2)
                {
                    licensePlate = tokens[2];
                }

                if (command == "register")
                {
                    var upperArr = licensePlate.Substring(0, 2).ToCharArray();
                    var lastUpperArr = licensePlate.Substring(6, 2).ToCharArray();
                    var middleArr = licensePlate.Substring(2, 4).ToCharArray();

                    var isValid = licensePlate.Length == 8 && char.IsUpper(upperArr[0]) && char.IsUpper(upperArr[1])
                        && char.IsUpper(lastUpperArr[0])
                        && char.IsUpper(lastUpperArr[1])
                        && char.IsDigit(middleArr[0])
                         && char.IsDigit(middleArr[1])
                          && char.IsDigit(middleArr[2])
                           && char.IsDigit(middleArr[3]);

                    if (database.ContainsKey(username))
                    {
                        Console.WriteLine($"ERROR: already registered with plate number {database[username]}");

                    }
                    else if (!isValid)
                    {
                        Console.WriteLine($"ERROR: invalid license plate {licensePlate}");
                        database.Remove(username);
                        error = false;
                    }
                    else if (database.ContainsValue(licensePlate))
                    {
                        Console.WriteLine($"ERROR: license plate {licensePlate} is busy");
                        database.Remove(username);
                        error = false;
                    }
                    else if (isValid)
                    {
                        Console.WriteLine($"{username} registered {licensePlate} successfully");
                        error = true;
                    }


                    if (!database.ContainsKey(username) && error)
                    {
                        database[username] = licensePlate;
                    }

                }

                if (command == "unregister")
                {
                    if (!database.ContainsKey(username))
                    {
                        Console.WriteLine($"ERROR: user {username} not found");
                    }
                    else
                    {
                        Console.WriteLine($"user {username} unregistered successfully");
                        database.Remove(username);
                    }
                }

            }

            foreach (var data in database)
            {
                Console.WriteLine($"{data.Key} => {data.Value}");
            }

        }
    }
}
