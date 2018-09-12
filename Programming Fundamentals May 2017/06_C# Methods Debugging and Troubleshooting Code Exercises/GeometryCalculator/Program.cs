using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GeometryCalculator
{
    class Program
    {
        static void Main(string[] args)
        {

            string type = Console.ReadLine();

            switch (type)
            {
                case "triangle":
                    double side = double.Parse(Console.ReadLine());
                    double height = double.Parse(Console.ReadLine());
                    CalcTriangle(side, height);
                    break;
                case "square":
                    double side2 = double.Parse(Console.ReadLine());
                    CalcSquare(side2);
                    break;
                case "rectangle":
                    double side3 = double.Parse(Console.ReadLine());
                    double height3 = double.Parse(Console.ReadLine());
                    CalcRectangle(side3, height3);
                    break;
                case "circle":
                    double radius = double.Parse(Console.ReadLine());
                    CalcCircle(radius);
                    break;
            }

        }

        static void CalcTriangle(double side, double height)
        {
            double area = side * height / 2;
            Console.WriteLine($"{area:F2}");
        }

        static void CalcSquare(double side2)
        {
            double area = side2 * side2;
            Console.WriteLine($"{area:F2}");
        }

        static void CalcRectangle(double width3, double height3)
        {
            double area = width3 * height3;
            Console.WriteLine($"{area:F2}");
        }

        static void CalcCircle(double radius)
        {
            double area = Math.PI * radius * radius;
            Console.WriteLine($"{area:F2}");
        }
    }
}
