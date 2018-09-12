using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_ChangeList
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            int change = 0;
            int change2 = 0;

            while (true)
            {
                var commands = Console.ReadLine().Split(' ').ToArray();

                string command = commands[0];

                if (command == "Odd")
                {
                    GetOdd(nums);
                    return;
                }
                else if (command == "Even")
                {
                    GetEven(nums);
                    return;

                }

                if (commands.Length > 1)
                {
                    change = int.Parse(commands[1]);

                }

                if (commands.Length > 2)
                {
                    change2 = int.Parse(commands[2]);

                }
                switch (command)
                {
                    case "Delete":

                        do
                        {
                            nums.Remove(change);
                        } while (nums.Contains(change));


                        break;
                    case "Insert":
                        nums.Insert(change2, change);
                        break;
                }
            }

        }

        static void GetOdd(List<int> nums)
        {
            var odds = new List<int>();

            for (int i = 0; i < nums.Count; i++)
            {
                if (nums[i] % 2 != 0)
                {
                    odds.Add(nums[i]);
                }
            }
            Console.WriteLine(string.Join(" ", odds));
        }

        static void GetEven(List<int> nums)
        {
            var evens = new List<int>();

            for (int i = 0; i < nums.Count; i++)
            {
                if (nums[i] % 2 == 0)
                {
                    evens.Add(nums[i]);
                }
            }
            Console.WriteLine(string.Join(" ", evens));
        }
    }
}
