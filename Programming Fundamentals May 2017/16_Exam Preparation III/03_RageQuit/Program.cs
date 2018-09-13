using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _03_RageQuit
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine();

            var pattern = @"(?<str>.*?)(?<num>(\d+))";

            var matches = Regex.Matches(input, pattern);

            var result = new StringBuilder();

            var modifiedInput = input.ToUpper();

            foreach (Match match in matches)
            {
                var letters = match.Groups["str"].Value.ToUpper();
                var repeatCount = int.Parse(match.Groups["num"].Value);
				
                for (int i = 0; i < repeatCount; i++)
                {
                    result.Append(letters);
                }
            }

            var uniqueSymbolsCount = result.ToString().ToUpper().Distinct().Count();

            Console.WriteLine($"Unique symbols used: {uniqueSymbolsCount}");
            Console.WriteLine(result);
        }
    }
}
