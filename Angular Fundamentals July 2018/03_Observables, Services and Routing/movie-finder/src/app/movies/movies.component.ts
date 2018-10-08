import { Component, OnInit } from '@angular/core';
import { MoviesService } from '../service/movies.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  popularMovies: Object;
  kidsMovies: Object;
  dramaMovies: Object;
  inTheathersMovies: Object;
  searchRes: any;
  isSearched: boolean;

  constructor(private moviesService: MoviesService) { }

  ngOnInit() {
    this.moviesService.getMostPopularMovies()
      .subscribe(data => {
        this.popularMovies = data;
      });
    this.moviesService.getKidsMovies()
      .subscribe(data => {
        this.kidsMovies = data;
      });
    this.moviesService.getDramaMovies()
      .subscribe(data => {
        this.dramaMovies = data;
      });
    this.moviesService.getInTheathresMovies()
      .subscribe(data => {
        this.inTheathersMovies = data;
      });
  }

  search(myQuery) {
    this.moviesService.findAMovie(myQuery)
      .subscribe(data => {
        this.searchRes = data;

        console.log(this.searchRes.results.length);

        if (this.searchRes.results.length > 0) {
          this.isSearched = true;
        } else {
          this.isSearched = false;
        }
      });
  }

}
