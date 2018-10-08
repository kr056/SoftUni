const apiKey = '7c3457361f14666c618a2971c74202f8';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  path: string;
  popular: string;
  kids: string;
  dramas: string;
  inTheathres: string;
  movie: string;
  authentication: string;
  detailsAuth: string;

  constructor(private http: HttpClient) {
    this.path = 'https://api.themoviedb.org/3/';
    this.popular = 'discover/movie?sort_by=popularity.desc';
    this.kids = 'discover/movie?certification_country=US&certification.lte=G&sort_by=popularity.desc';
    this.movie = 'movie/';
    this.detailsAuth = '?api_key=';
    this.dramas = 'discover/movie?with_genres=18&primary_release_year=2014';
    this.inTheathres = 'discover/movie?primary_release_date.gte=2018-05-15&primary_release_date.lte=2018-05-22';
    this.authentication = '&api_key=';
  }

  findAMovie(myQuery) {
    let qValue = myQuery.search;

    return this.http.get('https://api.themoviedb.org/3/search/movie?query=' + qValue + this.authentication + apiKey);
  }

  getMostPopularMovies(): Observable<Object> {
    return this.http.get(this.path + this.popular + this.authentication + apiKey);
  }

  getKidsMovies(): Observable<Object> {
    return this.http.get(this.path + this.kids + this.authentication + apiKey);
  }

  getDramaMovies(): Observable<Object> {
    return this.http.get(this.path + this.dramas + this.authentication + apiKey);
  }

  getInTheathresMovies(): Observable<Object> {
    return this.http.get(this.path + this.inTheathres + this.authentication + apiKey);
  }

  getMovie(id): Observable<Object> {
    let movieQuery = this.movie + id;
    
    return this.http.get(this.path + movieQuery + this.detailsAuth + apiKey);
  }
}
