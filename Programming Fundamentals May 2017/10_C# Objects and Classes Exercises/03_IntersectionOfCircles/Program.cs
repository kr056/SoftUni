using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_IntersectionOfCircles
{
    class Circle
    {
        public Point Center { get; set; }
        public int Radius { get; set; }

    }


    class Point
    {
        public int X { get; set; }
        public int Y { get; set; }
    }


    class Program
    {
        static void Main(string[] args)
        {
          var firstCircle = ReadCircle();
            var secondCircle = ReadCircle();

            var distanceBeetweenCircleCenters = DistanceBeetweenCirclesCenters(firstCircle, secondCircle);
            var circleRadiuses = firstCircle.Radius + secondCircle.Radius;

            Console.WriteLine(distanceBeetweenCircleCenters>circleRadiuses ? "No" : "Yes");

        }
        static Circle ReadCircle()
        {
            var circleInfo = Console.ReadLine().Split()
                .Select(int.Parse).ToArray();

            Circle circle = new Circle
            {

                Center = new Point
                {
                    X = circleInfo[0],
                    Y = circleInfo[1],
                },
                Radius = circleInfo[2]
            };
            return circle;
        }
       static double DistanceBeetweenCirclesCenters(Circle first,Circle second)
        {
            var distX = first.Center.X - second.Center.X;
            var distY = first.Center.Y - second.Center.Y;

            return Math.Sqrt(distX*distX + distY * distY);
        }
    }

}