using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_ArrayManipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();

            var arrElements = line.Split().Select(int.Parse).ToList();

            while (true)
            {
                var inputCommand = Console.ReadLine();

                if (inputCommand == "end")
                {
                    Console.WriteLine($"[{string.Join(", ", arrElements)}]");
                    break;
                }

                var tokens = inputCommand.Split();

                var cmd = tokens[0];

                switch (cmd)
                {
                    case "exchange":
                        var exchangeStartIndex = int.Parse(tokens[1]);
                        arrElements = ExchangeMethod(arrElements, exchangeStartIndex, line);
                        break;
                    case "max":
                        var oddOrEven = tokens[1];
                        GetMax(arrElements, oddOrEven);
                        break;
                    case "min":
                        GetMin(arrElements, tokens[1]);
                        break;
                    case "first":
                        var count = int.Parse(tokens[1]);
                        var type = tokens[2];
                        GetFirstElements(arrElements, count, type);
                        break;
                    case "last":
                        var lcount = int.Parse(tokens[1]);
                        var ltype = tokens[2];
                        GetLastElements(arrElements, lcount, ltype);
                        break;
                }

            }
        }

        private static void GetLastElements(List<int> arrElements, int lcount, string ltype)
        {
            if (lcount > arrElements.Count)
            {
                Console.WriteLine("Invalid count");
            }
            else
            {
                var filteredList = new List<int>();

                var toShow = new List<int>();

                switch (ltype)
                {
                    case "odd":
                        filteredList = arrElements.Where(x => x % 2 == 1).ToList();
                        if (filteredList.Count == 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else
                        {
                            if (lcount > filteredList.Count)
                            {
                                Console.Write("[");
                                Console.Write(string.Join(", ", filteredList));
                                Console.WriteLine("]");

                            }
                            else
                            {

                                toShow.AddRange(filteredList.Skip(filteredList.Count - lcount));

                                Console.Write("[");
                                Console.Write(string.Join(", ", toShow));
                                Console.WriteLine("]");
                            }
                        }
                        toShow.Clear();
                        filteredList.Clear();
                        break;
                    case "even":
                        filteredList = arrElements.Where(x => x % 2 == 0).ToList();
                        if (filteredList.Count == 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else
                        {
                            if (lcount > filteredList.Count)
                            {
                                Console.Write("[");
                                Console.Write(string.Join(", ", filteredList));
                                Console.WriteLine("]");

                            }
                            else
                            {
                                toShow.AddRange(filteredList.Skip(filteredList.Count - lcount));
                                Console.Write("[");
                                Console.Write(string.Join(", ", toShow));
                                Console.WriteLine("]");
                            }
                        }
                        toShow.Clear();
                        filteredList.Clear();
                        break;
                }
            }
        }

        private static void GetFirstElements(List<int> arrElements, int count, string type)
        {
            if (count > arrElements.Count)
            {
                Console.WriteLine("Invalid count");
            }
            else
            {
                var filteredList = new List<int>();

                var toShow = new List<int>();

                switch (type)
                {
                    case "odd":
                        filteredList = arrElements.Where(x => x % 2 == 1).ToList();
                        if (filteredList.Count == 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else
                        {
                            if (count > filteredList.Count)
                            {
                                Console.Write("[");
                                Console.Write(string.Join(", ", filteredList));
                                Console.WriteLine("]");

                            }
                            else
                            {
                                for (int i = 0; i < count; i++)
                                {
                                    toShow.Add(filteredList[i]);
                                }
                                Console.Write("[");
                                Console.Write(string.Join(", ", toShow));
                                Console.WriteLine("]");
                            }
                        }
                        toShow.Clear();
                        break;
                    case "even":
                        filteredList = arrElements.Where(x => x % 2 == 0).ToList();
                        if (filteredList.Count == 0)
                        {
                            Console.WriteLine("[]");
                        }
                        else
                        {
                            if (count > filteredList.Count)
                            {
                                Console.Write("[");
                                Console.Write(string.Join(", ", filteredList));
                                Console.WriteLine("]");

                            }
                            else
                            {
                                for (int i = 0; i < count; i++)
                                {
                                    toShow.Add(filteredList[i]);
                                }
                                Console.Write("[");
                                Console.Write(string.Join(", ", toShow));
                                Console.WriteLine("]");
                            }
                        }
                        toShow.Clear();
                        break;
                }
            }
        }

        private static void GetMin(List<int> arrElements, string v)
        {
            var filteredList = new List<int>();
            switch (v)
            {
                case "odd":
                    filteredList = arrElements.Where(x => x % 2 == 1).ToList();
                    if (filteredList.Count > 0)
                    {
                        var indexOfMinElement = arrElements.LastIndexOf(filteredList.Min());
                        Console.WriteLine(indexOfMinElement);
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                    break;
                case "even":
                    filteredList = arrElements.Where(x => x % 2 == 0).ToList();
                    if (filteredList.Count > 0)
                    {
                        var indexOfMinElement = arrElements.LastIndexOf(filteredList.Min());
                        Console.WriteLine(indexOfMinElement);
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                    break;
            }


        }

        private static void GetMax(List<int> arrElements, string oddOrEven)
        {
            var filteredList = new List<int>();

            switch (oddOrEven)
            {
                case "odd":
                    filteredList = arrElements.Where(x => x % 2 == 1).ToList();
                    if (filteredList.Count > 0)
                    {
                        var indexOfMaxElement = arrElements.LastIndexOf(filteredList.Max());
                        Console.WriteLine(indexOfMaxElement);
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                    break;
                case "even":
                    filteredList = arrElements.Where(x => x % 2 == 0).ToList();
                    if (filteredList.Count > 0)
                    {
                        var indexOfMaxElement = arrElements.LastIndexOf(filteredList.Max());
                        Console.WriteLine(indexOfMaxElement);
                    }
                    else
                    {
                        Console.WriteLine("No matches");
                    }
                    break;


            }
        }

        private static List<int> ExchangeMethod(List<int> arrElements, int exchangeStartIndex, string line)
        {

            var exchangedList = new List<int>();

            if (exchangeStartIndex >= 0 && exchangeStartIndex < arrElements.Count)
            {
                for (int i = exchangeStartIndex + 1; i < arrElements.Count; i++)
                {
                    exchangedList.Add(arrElements[i]);
                }

                for (int i = exchangeStartIndex; i >= 0; i--)
                {
                    exchangedList.Add(arrElements[exchangeStartIndex - i]);
                }
            }
            else
            {
                Console.WriteLine("Invalid index");
                return arrElements;
            }

            return exchangedList;
        }
    }
}
