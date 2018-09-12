using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SubString
{
    class Program
    {
        public static void Main()
        {
            string text = Console.ReadLine();

            char[] arr = text.ToCharArray();

            int jump = int.Parse(Console.ReadLine());

            bool hasMatch = false;

            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i] == 'p')
                {
                    hasMatch = true;

                    int endIndex = jump;

                    if (endIndex > text.Length)
                    {
                        endIndex = text.Length;
                    }
                    string matchedString = String.Empty;

                    if (endIndex >= (text.Length - i))
                    {
                        matchedString = text.Substring(i, endIndex);

                    }
                    else
                    {
                        matchedString = text.Substring(i, endIndex + 1);

                    }

                    Console.WriteLine(matchedString);
                    i += jump;
                }
            }

            if (!hasMatch)
            {
                Console.WriteLine("no");
            }
        }
    }
}
