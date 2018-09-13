using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _02_MatchPhones
{
    class Program
    {
        static void Main(string[] args)
        {
            var phones = Console.ReadLine();

            var pattern = @"\+359(\-| )2\1((\d{3})\1(\d{4}))\b";

            var phoneMatches = Regex.Matches(phones, pattern);

            var matchedPhones = phoneMatches
                .Cast<Match>()
                .Select(a => a.Value.Trim())
                .ToArray();

            Console.WriteLine(string.Join(", ", matchedPhones));
        }
    }
}
