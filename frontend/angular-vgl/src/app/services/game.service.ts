import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Game } from '../common/game';
import { map, Observable, tap } from 'rxjs';
import axios from 'axios';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  private baseUrl = 'http://localhost:8080/api/games';

  constructor(private httpClient: HttpClient) {}

  getGamesList(): Observable<Game[]> {
    return this.httpClient.get<Game[]>(this.baseUrl);
  }
}
