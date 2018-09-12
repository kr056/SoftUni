using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CatchTheThief
{
    class Program
    {
        static void Main(string[] args)
        {

            string type = Console.ReadLine();

            int idCount = int.Parse(Console.ReadLine());
            long max = sbyte.MinValue;
            long max1 = int.MinValue;
            long max2 = long.MinValue;
            double sentence = 0;
            for (int i = 0; i < idCount; i++)
            {
                long id = long.Parse(Console.ReadLine());
                switch (type)
                {
                    case "sbyte":
                        if (id <= sbyte.MaxValue)
                        {

                            if (id > max)
                            {
                                max = id;
                            }
                        }
                        break;
                    case "int":
                        if (id <= int.MaxValue)
                        {

                            if (id > max1)
                            {
                                max1 = id;

                            }
                        }
                        break;
                    case "long":
                        if (id <= long.MaxValue)
                        {
                            if (id > max2)
                            {
                                max2 = id;

                            }

                        }
                        break;
                }
            }
            switch (type)
            {
                case "sbyte":
                    if (max < 0)
                    {
                        sentence = max / -128d;
                    }
                    else
                    {
                        sentence = max / 127d;
                    }
                    sentence = Math.Abs(sentence);
                    sentence = Math.Ceiling(sentence);
                    if (sentence == 1)
                    {
                        Console.WriteLine($"Prisoner with id {max} is sentenced to {sentence} year");
                    }
                    else
                    {
                        Console.WriteLine($"Prisoner with id {max} is sentenced to {sentence} years");
                    }
                    break;

                case "int":
                    if (max1 < 0)
                    {
                        sentence = max1 / -128d;
                    }
                    else
                    {
                        sentence = max1 / 127d;

                    }

                    sentence = Math.Abs(sentence);
                    sentence = Math.Ceiling(sentence);

                    if (sentence == 1)
                    {
                        Console.WriteLine($"Prisoner with id {max1} is sentenced to {sentence} year");

                    }
                    else
                    {
                        Console.WriteLine($"Prisoner with id {max1} is sentenced to {sentence} years");

                    }
                    break;

                case "long":
                    if (max2 < 0)
                    {
                        sentence = max2 / -128d;
                    }
                    else
                    {
                        sentence = max2 / 127d;

                    }

                    sentence = Math.Abs(sentence);
                    sentence = Math.Ceiling(sentence);

                    if (sentence == 1)
                    {
                        Console.WriteLine($"Prisoner with id {max2} is sentenced to {sentence} year");

                    }
                    else
                    {
                        Console.WriteLine($"Prisoner with id {max2} is sentenced to {sentence} years");

                    }
                    break;
            }
        }
    }
}
