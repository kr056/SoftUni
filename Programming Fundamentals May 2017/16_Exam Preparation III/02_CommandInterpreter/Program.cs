using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_CommandInterpreter
{
    class Program
    {
        static void Main(string[] args)
        {

            var elements = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();

            while (true)
            {
                var line = Console.ReadLine();

                if (line == "end")
                {
                    break;
                }

                var tokens = line.Split();
                var command = tokens[0];

                switch (command)
                {
                    case "reverse":
                        var startIndex = int.Parse(tokens[2]);
                        var count = int.Parse(tokens[4]);
                        ReverseMethod(elements, startIndex, count);
                        break;
                    case "sort":
                        var reverseStartIndex = int.Parse(tokens[2]);
                        var reverseCount = int.Parse(tokens[4]);
                        SortMethod(elements, reverseStartIndex, reverseCount);
                        break;
                    case "rollLeft":
                        var countForRollLeft = int.Parse(tokens[1]);
                        RollLeftMethod(elements, countForRollLeft);
                        break;
                    case "rollRight":
                        var countForRollRight = int.Parse(tokens[1]);
                        RollRightMethod(elements, countForRollRight);
                        break;
                }
            }

            Console.Write("[");
            Console.Write(string.Join(", ", elements));
            Console.WriteLine("]");
        }



        private static bool isValid(List<string> elements, int start, int count)
        {
            return start >= 0 && start < elements.Count
                 && count >= 0 && (count + start) <= elements.Count;
        }

        private static void SortMethod(List<string> elements, int reverseStartIndex, int reverseCount)
        {
            if (!isValid(elements, reverseStartIndex, reverseCount))
            {
                Console.WriteLine("Invalid input parameters.");
            }
            else
            {
                elements.Sort(reverseStartIndex, reverseCount, null);
            }
        }

        private static void ReverseMethod(List<string> elements, int startIndex, int count)
        {
            if (!isValid(elements, startIndex, count))
            {
                Console.WriteLine("Invalid input parameters.");
            }
            else
            {
                elements.Reverse(startIndex, count);
            }
        }

        private static void RollLeftMethod(List<string> elements, int countForRollLeft)
        {
            if (countForRollLeft < 0)
            {
                Console.WriteLine("Invalid input parameters.");
            }
            else
            {
                var rotations = countForRollLeft % elements.Count;

                for (int i = 0; i < rotations; i++)
                {
                    var firstElement = elements.First();

                    elements.RemoveAt(0);
                    elements.Add(firstElement);
                }
            }
        }

        private static void RollRightMethod(List<string> elements, int countForRollRight)
        {
            if (countForRollRight < 0)
            {
                Console.WriteLine("Invalid input parameters.");
            }
            else
            {
                var rotations = countForRollRight % elements.Count;

                for (int i = 0; i < rotations; i++)
                {
                    var lastElement = elements.Last();

                    elements.RemoveAt(elements.Count - 1);
                    elements.Insert(0, lastElement);
                }
            }
        }
    }
}
