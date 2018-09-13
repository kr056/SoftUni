using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _03_MatchHexNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            var hexNumbers = Console.ReadLine();

            var pattern = @"\b(?:0x)?[0-9A-F]+\b";

            var matches = Regex.Matches(hexNumbers, pattern);

            var matchedNums = matches
                .Cast<Match>()
                .Select(a => a.Value)
                .ToArray();

            Console.WriteLine(string.Join(" ", matchedNums));

        }
    }
}
