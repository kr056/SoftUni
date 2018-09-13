using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _08_UseYourChains_Buddy
{
    class Program
    {
        static void Main(string[] args)
        {
            var pattern = @"<p>(?<message>.+?)<\/p>";

            var inputHTML = Console.ReadLine();

            var matches = Regex.Matches(inputHTML, pattern);

            var currentMatch = string.Empty;

            foreach (Match match in matches)
            {
                currentMatch += match.Groups["message"].Value;
            }

            currentMatch = Regex.Replace(currentMatch, @"[^a-z0-9]", " ");
            currentMatch = Regex.Replace(currentMatch, @"\s+", " ");

            var decryptedText = new StringBuilder();

            foreach (var letter in currentMatch)
            {
                var currentChar = letter;

                if (letter >= 'a' && letter <= 'm')
                {
                    currentChar = (char)(letter + 13);
                }
                else if (letter >= 'n' && letter <= 'z')
                {
                    currentChar = (char)(letter - 13);
                }

                decryptedText.Append(currentChar);
            }

            Console.WriteLine(decryptedText.ToString());

        }
    }
}
