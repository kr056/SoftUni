using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_LadyBugs
{
    class Program
    {
        static void Main(string[] args)
        {

            int fieldSize = int.Parse(Console.ReadLine());

            var ladybugIndexes = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .Where(a => a >= 0 && a < fieldSize)
                .ToArray();

            var field = new int[fieldSize];

            foreach (var ladybugIndex in ladybugIndexes)
            {
                field[ladybugIndex] = 1;
            }

            while (true)
            {
                var line = Console.ReadLine();

                if (line == "end")
                {
                    break;
                }

                var tokens = line.Split();
                var ladybugIndex = int.Parse(tokens[0]);
                var direction = tokens[1];
                var flyCount = int.Parse(tokens[2]);

                var isInsideArray = ladybugIndex >= 0 && ladybugIndex < fieldSize;

                if (!isInsideArray)
                {
                    continue;
                }

                var ladyBugExists = field[ladybugIndex] == 1;

                if (!ladyBugExists)
                {
                    continue;
                }

                MoveLadyBug(field, ladybugIndex, direction, flyCount);
            }

            Console.WriteLine(string.Join(" ", field));
        }

        private static void MoveLadyBug(int[] field, int ladybugIndex, string direction, int flyCount)
        {
            if (direction == "left")
            {
                flyCount = -flyCount;
            }

            var nextIndex = ladybugIndex + flyCount;

            field[ladybugIndex] = 0;

            var hasLeftArrayOrFoundPlace = false;
            while (!hasLeftArrayOrFoundPlace)
            {
                if (nextIndex < 0 || nextIndex > field.Length - 1)
                {
                    hasLeftArrayOrFoundPlace = true;
                    continue;
                }

                var ladybugAlreadyExistOnIndex = field[nextIndex] == 1;

                if (ladybugAlreadyExistOnIndex)
                {
                    nextIndex += flyCount;
                    continue;
                }

                field[nextIndex] = 1;
                hasLeftArrayOrFoundPlace = true;
            }
        }
    }
}
