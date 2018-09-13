using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Palindromes
{
    class Program
    {
        static void Main(string[] args)
        {

            char[] delimeters = { ' ', ',', '.', '?', '!' };

            string[] input = Console.ReadLine()
                .Split(delimeters
                , StringSplitOptions.RemoveEmptyEntries)
                .ToArray();

            var palindromes = new List<string>();

            for (int i = 0; i < input.Length; i++)
            {
                if (isPalindrome(input[i]))
                {
                    palindromes.Add(input[i]);
                }
            }

            var sorted = palindromes.Distinct().OrderBy(a => a).ToList();

            Console.WriteLine(string.Join(", ", sorted));
        }

        private static bool isPalindrome(string word)
        {

            var input = word.ToCharArray();

            var reverse = String.Empty;
            for (int i = input.Length - 1; i >= 0; i--)
            {
                reverse += input[i];
            }
            if (reverse == word)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
