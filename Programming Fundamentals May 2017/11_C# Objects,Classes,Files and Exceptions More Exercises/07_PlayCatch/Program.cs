using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace _07_PlayCatch
{
    class Program
    {

        static void Main(string[] args)
        {

            var arr = Console.ReadLine().Split()
                .Select(BigInteger.Parse).ToArray();
            var exceptionCount = 0;
            while (exceptionCount < 3)
            {
                var tokens = Console.ReadLine().Split()
                    .ToArray();
                var command = tokens[0];
                try
                {
                    switch (command)
                    {
                        case "Replace":
                            var index = long.Parse(tokens[1]);
                            var element = long.Parse(tokens[2]);

                            arr[index] = element;

                            break;
                        case "Print":
                            var startIndex = long.Parse(tokens[1]);
                            var endIndex = long.Parse(tokens[2]);
                            arr[endIndex] = arr[endIndex];
                            for (long i = startIndex; i <= endIndex; i++)
                            {

                                if (i == arr.Length - 1)
                                {
                                    Console.WriteLine(arr[i]);
                                }
                                else
                                {
                                    Console.Write(arr[i] + ", ");
                                }
                            }
                            break;
                        case "Show":
                            var showIndex = long.Parse(tokens[1]);

                            Console.WriteLine(arr[showIndex]);
                            break;
                    }

                }
                catch (IndexOutOfRangeException)
                {
                    exceptionCount++;
                    Console.WriteLine("The index does not exist!");
                }
                catch (FormatException)
                {
                    exceptionCount++;
                    Console.WriteLine("The variable is not in the correct format!");
                }
            }

            Console.WriteLine(string.Join(", ", arr));

        }
    }
}
