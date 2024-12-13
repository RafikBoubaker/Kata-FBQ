import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { CommonModule } from '@angular/common';
import { KataService } from './services/kata.service';
import { TransformResponse } from './model/transformResponse';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule], 
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  inputNumber: number | null = null; 
  result: string = ''; 
  errorMessage: string = ''; 

  constructor(private kataService: KataService) {}

  transformNumber(): void {
    
    if (this.inputNumber === null || this.inputNumber < 0 || this.inputNumber > 100) {
      this.resetInput();
      this.errorMessage = 'Veuillez entrer un nombre entre 0 et 100.';
      return;
    }


    this.errorMessage = ''; 
    this.result = ''; 



    this.kataService.transformNumber(this.inputNumber).subscribe({
      next: (response: TransformResponse) => {
        this.result = `Nombre saisi: ${response.nombreSaisie}, Resultat: ${response.resultat}`;
      },
      error: (error) => {
        console.error('Erreur de transformation', error);
        this.errorMessage = 'Erreur lors de la communication avec le backend.';
      }
    });
  }


  resetInput(): void {
    this.inputNumber = null; 
    this.result = '';        
    this.errorMessage = ''; 
  }
}