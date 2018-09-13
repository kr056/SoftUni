using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _05_OnlyLetters
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine();

            var pattern = @"(?<num>\d+)(?<char>[a-zA-Z])";

            var matches = Regex.Matches(input, pattern);

            var fillteredInput = input;

            foreach (Match match in matches)
            {
                var index = 0;

                if (match.Length > 1)
                {
                    index = match.Index + match.Length - 1;
                }
                else
                {
                    index = match.Index;

                }

                var toReplace = match.Groups["num"].Value;
                fillteredInput = Regex.Replace(fillteredInput, toReplace, $"{input[index]}");
            }

            Console.WriteLine(fillteredInput);
        }
    }
}
