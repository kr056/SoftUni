using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_LongestIncreasingSubsequence
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            while (true)
            {
                var commands = Console.ReadLine().Split().ToList();
                string command = commands[0];

                if (command == "print")
                {
                    Console.WriteLine($"[{string.Join(", ", nums)}]");
                    return;
                }

                switch (command)
                {
                    case "add":
                        int index = int.Parse(commands[1]);
                        int element = int.Parse(commands[2]);
                        nums.Insert(index, element);

                        break;
                    case "addMany":
                        int index1 = int.Parse(commands[1]);
                        var elements = new List<int>();

                        for (int i = 0; i < commands.Count - 2; i++)
                        {
                            int element1 = int.Parse(commands[i + 2]);
                            elements.Add(element1);
                            nums.Insert(index1 + i, elements[i]);
                        }
                        break;
                    case "contains":
                        int elementToCheck = int.Parse(commands[1]);

                        if (nums.Contains(elementToCheck))
                        {
                            for (int i = 0; i < nums.Count; i++)
                            {
                                if (nums[i] == elementToCheck)
                                {
                                    Console.WriteLine(i);
                                    break;
                                }
                            }
                        }
                        else
                        {
                            Console.WriteLine("-1");
                        }

                        break;
                    case "remove":
                        int indexOfEToRemove = int.Parse(commands[1]);
                        nums.RemoveAt(indexOfEToRemove);
                        break;
                    case "shift":
                        int posToMove = int.Parse(commands[1]) % nums.Count;
                        var oldE = new List<int>();

                        for (int i = 0; i < posToMove; i++)
                        {
                            oldE.Add(nums[i]);
                            nums.RemoveAt(i);
                            i--;
                            posToMove--;

                        }
                        nums.AddRange(oldE);
                        break;
                    case "sumPairs":
                        var sum = 0;
                        var keepNumsElements = new List<int>();

                        if (nums.Count % 2 == 0)
                        {
                            for (int i = 0; i < nums.Count; i++)
                            {
                                keepNumsElements.Add(nums[i]);
                            }
                            nums.Clear();

                            for (int i = 0; i < keepNumsElements.Count; i++)
                            {
                                sum = keepNumsElements[i] + keepNumsElements[i + 1];
                                nums.Add(sum);
                                i++;
                            }
                        }
                        else
                        {

                            for (int i = 0; i < nums.Count; i++)
                            {
                                keepNumsElements.Add(nums[i]);
                            }
                            nums.Clear();

                            for (int i = 0; i < keepNumsElements.Count - 1; i++)
                            {
                                sum = keepNumsElements[i] + keepNumsElements[i + 1];
                                nums.Add(sum);
                                i++;
                            }
                            nums.Add(keepNumsElements[keepNumsElements.Count - 1]);

                        }

                        break;
                }
            }
        }
    }
}
