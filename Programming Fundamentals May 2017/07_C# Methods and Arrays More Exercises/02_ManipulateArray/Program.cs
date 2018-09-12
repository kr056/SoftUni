using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_ManipulateArray
{
    class Program
    {
        static void Main(string[] args)
        {

            var items = Console.ReadLine().Split(' ').ToList();

            var commandsNum = int.Parse(Console.ReadLine());

            for (int i = 0; i < commandsNum; i++)
            {
                var commands = Console.ReadLine().Split(' ').ToArray();

                if (commands[0] == "Distinct")
                {
                    Distinct(items);

                }
                else if (commands[0] == "Reverse")
                {
                    Reverse(items);

                }
                else if (commands[0] == "Replace")
                {
                    int indexPos = int.Parse(commands[1]);

                    string newItem = commands[2];
                    Replace(items, indexPos, newItem);

                }

            }
            Console.WriteLine(string.Join(", ", items));


        }

        static void Distinct(List<string> items)
        {
            for (int i = 0; i < items.Count; i++)
            {
                for (int j = i + 1; j < items.Count; j++)
                {
                    if (items[i] == items[j])
                    {
                        items.RemoveAt(j);
                        j--;
                    }
                }
            }
        }

        static void Reverse(List<string> items)
        {
            items.Reverse();

        }

        static void Replace(List<string> items, int index, string newItem)
        {
            for (int i = 0; i < items.Count; i++)
            {
                if (i == index)
                {
                    items[i] = newItem;

                }
            }

        }

    }
}
