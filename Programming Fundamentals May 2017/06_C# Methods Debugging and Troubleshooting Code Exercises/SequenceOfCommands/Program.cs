﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SequenceOfCommands
{
    class Program
    {
        private const char ArgumentsDelimiter = ' ';

        static void Main(string[] args)
        {

            int sizeOfArray = int.Parse(Console.ReadLine());

            long[] array = Console.ReadLine()
                .Split(ArgumentsDelimiter)
                .Select(long.Parse)
                .ToArray();

            string command = Console.ReadLine();

            while (!command.Equals("stop"))
            {
                string line = Console.ReadLine().Trim();
                int[] argss = new int[2];

                if (command.Equals("add") ||
                    command.Equals("substract") ||
                    command.Equals("multiply"))
                {
                    string[] stringParams = line.Split(ArgumentsDelimiter);
                    argss[0] = int.Parse(stringParams[0]);
                    argss[1] = int.Parse(stringParams[1]);

                    PerformAction(array, command, argss);
                }

                PerformAction(array, command, argss);

                PrintArray(array);
                Console.WriteLine('\n');

                command = Console.ReadLine();
            }


        }
        static void PerformAction(long[] arr, string action, int[] args)
        {
            long[] array = arr.Clone() as long[];
            int pos = args[0];
            int value = args[1];

            switch (action)
            {
                case "multiply":
                    array[pos] *= value;
                    break;
                case "add":
                    array[pos] += value;
                    break;
                case "subtract":
                    array[pos] -= value;
                    break;
                case "lshift":
                    ArrayShiftLeft(array);
                    break;
                case "rshift":
                    ArrayShiftRight(array);
                    break;
            }
        }

        private static void ArrayShiftRight(long[] array)
        {
            for (int i = array.Length - 1; i >= 1; i--)
            {
                array[i] = array[i - 1];
            }
        }

        private static void ArrayShiftLeft(long[] array)
        {
            for (int i = 0; i < array.Length - 1; i++)
            {
                array[i] = array[i + 1];
            }
        }

        private static void PrintArray(long[] array)
        {
            for (int i = 0; i < array.Length; i++)
            {
                Console.WriteLine(array[i] + " ");
            }
        }
    }
}
