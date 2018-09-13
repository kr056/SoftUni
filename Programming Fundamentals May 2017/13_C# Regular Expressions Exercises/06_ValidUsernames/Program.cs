using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_ValidUsernames
{
    class Program
    {
        static void Main(string[] args)
        {
            var separators = new char[] { ' ', '/', '\\', '(', ')' };

            var input = Console.ReadLine();

            var allUsernames = input.Split(separators, StringSplitOptions.RemoveEmptyEntries).ToArray();

            var pattern = @"^[a-zA-Z][a-zA-Z\d_]{2,24}$";

            var validUsernames = new List<string>();

            foreach (var username in allUsernames)
            {
                var match = Regex.Match(username, pattern);

                if (match.Success)
                {
                    validUsernames.Add(username);
                }
            }

            var maxSum = 0;
            var bestIndex = 0;

            for (int i = 0; i < validUsernames.Count - 1; i++)
            {
                var currentUsername = validUsernames[i].Length;
                var nextUsername = validUsernames[i + 1].Length;
                var currentSum = currentUsername + nextUsername;

                if (currentSum > maxSum)
                {
                    maxSum = currentSum;
                    bestIndex = i;
                }

            }

            Console.WriteLine(validUsernames[bestIndex]);
            Console.WriteLine(validUsernames[bestIndex + 1]);

        }
    }
}
