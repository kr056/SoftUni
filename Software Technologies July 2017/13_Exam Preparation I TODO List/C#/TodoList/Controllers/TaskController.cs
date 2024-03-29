﻿using System;
using System.Linq;
using System.Web.Mvc;
using TodoList.Models;

namespace TodoList.Controllers
{
        [ValidateInput(false)]
	public class TaskController : Controller
	{
	    [HttpGet]
        [Route("")]
	    public ActionResult Index()
	    {
	        
            using (var db = new TodoListDbContext())
            {
                var tasks = db.Tasks.ToList();

                return View(tasks);
            }
	        
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
		{
            return View();
		}

		[HttpPost]
		[Route("create")]
        [ValidateAntiForgeryToken]
		public ActionResult Create(Task task)
		{
            if (task == null)
            {
                return RedirectToAction("Index");
            }

            if(string.IsNullOrWhiteSpace(task.Title) || string.IsNullOrWhiteSpace(task.Comments))
            {
                return RedirectToAction("Index");
            }

            if (ModelState.IsValid)
            {
                using (var db = new TodoListDbContext())
                {
                    db.Tasks.Add(task);
                    db.SaveChanges();

                    return RedirectToAction("Index");
                }
            }
            return RedirectToAction("Index");

        }

        [HttpGet]
		[Route("delete/{id}")]
        public ActionResult Delete(int id)
		{
            using (var db = new TodoListDbContext())
            {
                var task = db.Tasks.Find(id);
                if (task == null)
                {
                    return RedirectToAction("Index");
                }

                return View(task);
            }
        }

		[HttpPost]
		[Route("delete/{id}")]
        [ValidateAntiForgeryToken]
		public ActionResult DeleteConfirm(int id)
		{
            using (var db = new TodoListDbContext())
            {
                var task = db.Tasks.Find(id);
                if (task == null)
                {
                    return RedirectToAction("Index");
                }

                db.Tasks.Remove(task);
                db.SaveChanges();

                return RedirectToAction("Index");
            }
        }
	}
}