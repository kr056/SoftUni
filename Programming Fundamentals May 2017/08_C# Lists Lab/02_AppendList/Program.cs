using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_AppendList
{
    class Program
    {
        static void Main(string[] args)
        {

            var items = Console.ReadLine().Split('|').ToList();
            items.Reverse();

            var results = new List<string>();

            foreach (var item in items)
            {
                List<string> nums = item.Split(' ').ToList();
                foreach (var num in nums)
                {
                    if (num != "")
                    {
                        results.Add(num);
                    }

                }
            }

            Console.WriteLine(string.Join(" ", results));

        }
    }
}
