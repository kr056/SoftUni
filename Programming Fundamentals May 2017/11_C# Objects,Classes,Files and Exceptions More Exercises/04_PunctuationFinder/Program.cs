using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _04_PunctuationFinder
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = File.ReadAllText("input.txt");

            string pattern = @"\.|\,|\!|\?|\:";

            var matches = Regex.Matches(input, pattern);

            var matchesFinded = matches.Cast<Match>()
                .Select(a => a.Value)
                .ToArray();

            File.AppendAllText("output.txt", string.Join(", ", matchesFinded));

        }
    }
}
