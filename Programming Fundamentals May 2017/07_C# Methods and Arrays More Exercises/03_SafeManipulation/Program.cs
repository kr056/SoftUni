using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_SafeManipulation
{
    class Program
    {
        static void Main(string[] args)
        {

            var items = Console.ReadLine().Split(' ').ToList();

            while (true)
            {

                var commands = Console.ReadLine().Split(' ').ToArray();

                string command = commands[0];

                if (command == "END")
                {
                    break;
                }


                switch (command)
                {
                    case "Distinct":
                        Distinct(items);
                        break;
                    case "Reverse":
                        Reverse(items);
                        break;
                    case "Replace":
                        int indexPos = int.Parse(commands[1]);
                        string newItem = commands[2];
                        if (indexPos < 0 || indexPos >= items.Count)
                        {
                            Console.WriteLine("Invalid input!");

                        }
                        else
                        {

                            Replace(items, indexPos, newItem);

                        }
                        break;
                    default:
                        Console.WriteLine("Invalid input!");
                        break;
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
