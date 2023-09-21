import { Component, OnInit } from '@angular/core';
import { Game } from '../../common/game';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css'],
})
export class GamesComponent implements OnInit {
  games: Game[] = [];

  constructor(private gameService: GameService) {}

  ngOnInit(): void {
    this.listGames();
  }

  private listGames() {
    this.gameService.getGamesList().subscribe(
      (games) => {
        this.games = games;
      },
      (error) => {
        // Handle errors as needed
      }
    );
  }
}
