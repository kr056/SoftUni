using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VaporStore
{
    class Program
    {
        static void Main(string[] args)
        {

            double balance = double.Parse(Console.ReadLine());
            string game = "";

            double end = balance;
            double outfall = 39.99;
            double counterStrike = 15.99;
            double zplinterZell = 19.99;
            double honored = 59.99;
            double roverwatch = 29.99;
            double roverwatchOriginsEdition = 39.99;
            double spent = 0;

            for (int i = 1; i <= 20; i++)
            {
                game = Console.ReadLine();
                switch (game)
                {
                    case "OutFall 4":
                        if (balance >= 39.99)
                        {
                            balance -= outfall;
                            spent += outfall;
                            Console.WriteLine($"Bought {game}");
                        }
                        else
                        {
                            Console.WriteLine("Too Expensive");
                        }
                        break;
                    case "CS: OG":
                        if (balance >= 15.99)
                        {
                            balance -= counterStrike;
                            spent += counterStrike;
                            Console.WriteLine($"Bought {game}");
                        }
                        else
                        {
                            Console.WriteLine("Too Expensive");
                        }

                        break;
                    case "Zplinter Zell":
                        if (balance >= 19.99)
                        {
                            balance -= zplinterZell;
                            spent += zplinterZell;
                            Console.WriteLine($"Bought {game}");
                        }
                        else
                        {
                            Console.WriteLine("Too Expensive");
                        }
                        break;
                    case "Honored 2":
                        if (balance >= 59.99)
                        {
                            balance -= honored;
                            spent += honored;
                            Console.WriteLine($"Bought {game}");
                        }
                        else
                        {
                            Console.WriteLine("Too Expensive");
                        }
                        break;
                    case "RoverWatch":
                        if (balance >= 29.99)
                        {
                            balance -= roverwatch;
                            spent += roverwatch;
                            Console.WriteLine($"Bought {game}");
                        }
                        else
                        {
                            Console.WriteLine("Too Expensive");
                        }
                        break;
                    case "RoverWatch Origins Edition":
                        if (balance >= 39.99)
                        {
                            balance -= roverwatchOriginsEdition;
                            spent += roverwatchOriginsEdition;
                            Console.WriteLine($"Bought {game}");
                        }
                        else
                        {
                            Console.WriteLine("Too Expensive");
                        }
                        break;
                    case "Game Time":
                        break;
                    default:
                        Console.WriteLine("Not Found");
                        break;
                }

                if (game.Equals("Game Time"))
                {
                    Console.WriteLine($"Total spent: ${spent:F2}. Remaining: ${(end - spent):F2}");
                    return;
                }
                else if (balance == 0)
                {
                    Console.WriteLine("Out of money!");
                    return;
                }

            }

        }
    }
}
