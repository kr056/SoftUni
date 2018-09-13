using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _05_MatchNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            var pattern = @"(^|(?<=\s))-?\d+(\.\d+)?($|(?=\s))";

            var input = Console.ReadLine();

            var matchedNums = Regex.Matches(input, pattern);

            foreach (Match num in matchedNums)
            {
                Console.Write(num.Value + " ");
            }

            Console.WriteLine();
        }
    }
}
