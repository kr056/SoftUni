using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_SplitByWordCasing
{
    class Program
    {
        static void Main(string[] args)
        {
            var separators = new char[] {',', ';', ':', '.', '!', '(', ')', '"', '\\',
            '/','[',']',' ','\''};

            var words = Console.ReadLine().Split(separators, StringSplitOptions.RemoveEmptyEntries).ToList();

            var lowerCase = new List<string>();
            var upperCase = new List<string>();
            var mixedCase = new List<string>();

            foreach (var word in words)
            {
                bool isAllLower = true;
                bool isAllUpper = true;

                for (int i = 0; i < word.Length; i++)
                {
                    if (Char.IsLower(word[i]))
                    {
                        isAllUpper = false;
                    }
                    else if (Char.IsUpper(word[i]))
                    {
                        isAllLower = false;
                    }
                    else
                    {
                        isAllUpper = false;
                        isAllLower = false;

                    }
                }

                if (isAllUpper)
                {
                    upperCase.Add(word);
                }
                else if (isAllLower)
                {
                    lowerCase.Add(word);
                }
                else
                {
                    mixedCase.Add(word);
                }
            }

            Console.WriteLine("Lower-case: {0}", string.Join(", ", lowerCase));
            Console.WriteLine("Mixed-case: {0}", string.Join(", ", mixedCase));
            Console.WriteLine("Upper-case: {0}", string.Join(", ", upperCase));

        }
    }
}
