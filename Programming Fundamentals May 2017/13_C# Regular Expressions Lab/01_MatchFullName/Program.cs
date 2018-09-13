using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _01_MatchFullName
{
    class Program
    {
        static void Main(string[] args)
        {

            string input = Console.ReadLine();

            string pattern = @"\b[A-Z][a-z]+\b \b[A-Z][a-z]+\b";

            Regex regex = new Regex(pattern);

            MatchCollection matches = Regex.Matches(input, pattern);

            foreach (Match match in matches)
            {
                Console.Write(match + " ");
            }

            Console.WriteLine();

        }
    }
}
