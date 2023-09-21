import { Injectable } from '@angular/core';
import { Game } from '../common/game';
import axios from 'axios';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  private baseUrl = 'http://localhost:8080/api/games';

  async getGamesList() {
    try {
      const response = await axios.get<Game[]>(this.baseUrl);
      return response.data;
    } catch (error) {
      console.log('Error fetching games:', error);
      throw error;
    }
  }
}

interface GetResponse {
  _embedded: {
    games: Game[];
  };
}
