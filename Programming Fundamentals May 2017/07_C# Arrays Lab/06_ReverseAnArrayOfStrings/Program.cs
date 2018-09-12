using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReverseAnArrayOfStrings
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = Console.ReadLine().
                Split(' ').ToArray();

            for (int i = 0; i < words.Length / 2; i++)
            {
                SwapElements(words, i, words.Length - 1 - i);
            }

            Console.WriteLine(string.Join(" ", words));

        }

        static void SwapElements(string[] arr, int i, int j)
        {
            var oldElement = arr[i];
            arr[i] = arr[j];
            arr[j] = oldElement;
        }

    }
}
