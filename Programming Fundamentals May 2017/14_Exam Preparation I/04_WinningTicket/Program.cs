using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _04_WinningTicket
{
    class Program
    {
        static void Main(string[] args)
        {

            var tickets = Console.ReadLine()
                .Split(new char[] { ' ', ',' }, StringSplitOptions.RemoveEmptyEntries)
                .ToList();

            foreach(var ticket in tickets)
            {
                if (ticket.Length != 20)
                {
                    Console.WriteLine("invalid ticket");
                }
                else
                {
                    var length = ticket.Length;

                    var leftPart = ticket.Substring(0, length / 2);
                    var rightPart = ticket.Substring(length / 2);

                    var pattern = @"\@{6,}|\#{6,}|\${6,}|\^{6,}";

                    var leftPartMatch = Regex.Match(leftPart, pattern);
                    var rightPartMatch = Regex.Match(rightPart, pattern);

                    if(leftPartMatch.Success && rightPartMatch.Success)
                    {
                        var matchSymbol = leftPartMatch.ToString().First();
                        var matchLength = Math.Min(leftPartMatch.Length, rightPartMatch.Length);

                        if(leftPartMatch.Length==10 && rightPartMatch.Length == 10)
                        {
                            Console.WriteLine($"ticket \"{ticket}\" - {matchLength}{matchSymbol} Jackpot!");

                        }
                        else
                        {
                            Console.WriteLine($"ticket \"{ticket}\" - {matchLength}{matchSymbol}");

                        }
                    }
                    else
                    {
                        Console.WriteLine($"ticket \"{ticket}\" - no match");
                    }
                }
            }

        }
    }
}
