﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PhotoGallery
{
    class Program
    {
        static void Main(string[] args)
        {

            int photoNum = int.Parse(Console.ReadLine());
            int day = int.Parse(Console.ReadLine());
            int month = int.Parse(Console.ReadLine());
            int year = int.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());
            int bytes = int.Parse(Console.ReadLine());
            int width = int.Parse(Console.ReadLine());
            int height = int.Parse(Console.ReadLine());

            double mb = bytes * 1.0;

            Console.WriteLine($"Name: DSC_{photoNum:D4}.jpg");
            Console.WriteLine($"Date Taken: {day:D2}/{month:D2}/{year} {hours:D2}:{minutes:D2}");
            if (bytes > 1000 && bytes < 1000000)
            {
                Console.WriteLine($"Size: {(bytes / 1000)}KB");
            }
            else if (bytes >= 1000000)
            {
                Console.WriteLine($"Size: {Math.Round((mb / 1000000), 1)}MB");
            }
            else
            {
                Console.WriteLine($"Size: {(bytes)}B");
            }

            if (width > height)
            {
                Console.WriteLine($"Resolution: {width}x{height} (landscape)");
            }
            else if (width == height)
            {
                Console.WriteLine($"Resolution: {width}x{height} (square)");
            }
            else if (width < height)
            {
                Console.WriteLine($"Resolution: {width}x{height} (portrait)");
            }

        }
    }
}
