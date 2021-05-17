import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-content',
  templateUrl: './home-content.component.html',
  styleUrls: ['./home-content.component.css']
})
export class HomeContentComponent {
  
  men = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        
        return [
          { title:  `Men's T-Shirt`, cols: 3, rows: 1, imageName: "https://i.imgur.com/CKBR1YQ.jpg?1", category: "men-tshirt" },
          { title: `Men's Shirt`, cols: 3, rows: 1, imageName: "https://i.imgur.com/YHhzubs.jpg", category: "men-shirt"  },
          { title: `Men's Jeans`, cols: 3, rows: 1, imageName: "https://i.imgur.com/sEfKUtg.jpg", category: "men-jeans"  }
          
        ];
      }
      return [
        { title: `Men's T-Shirt`, cols: 1, rows: 1, imageName: "https://i.imgur.com/CKBR1YQ.jpg?1",category: "men-tshirt" },
        { title: `Men's Shirt`, cols: 1, rows: 1, imageName: "https://i.imgur.com/YHhzubs.jpg", category: "men-shirt" },
        { title: `Men's Jeans`, cols: 1, rows: 1, imageName: "https://i.imgur.com/sEfKUtg.jpg", category: "men-jeans" }
      ];
    })
  );
  women = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title:  `Women's T-Shirt`, cols: 3, rows: 1, imageName: "https://i.imgur.com/KpusWb7.jpg?1", category: "women-tshirt" },
          { title: `Women's Shirt`, cols: 3, rows: 1, imageName: "https://i.imgur.com/NqUk8nl.jpg?1", category: "women-shirt" },
          { title: `Women's Jeans`, cols: 3, rows: 1, imageName: "https://i.imgur.com/PcisNx0.jpg", category: "women-jeans" }
          
        ];
      }

      return [
        { title: `Women's T-Shirt`, cols: 1, rows: 1, imageName: "https://i.imgur.com/KpusWb7.jpg?1", category: "women-tshirt" },
        { title: `Women's Shirt`, cols: 1, rows: 1, imageName: "https://i.imgur.com/NqUk8nl.jpg?1", category: "women-shirt" },
        { title: `Women's Jeans`, cols: 1, rows: 1, imageName: "https://i.imgur.com/PcisNx0.jpg", category: "women-jeans" }
      ];
    })
  );

  girls = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title:  `Girls' T-Shirt`, cols: 3, rows: 1, imageName: "https://i.imgur.com/BpEqmYz.jpg?1", category: "girls-tshirt" },
          { title: `Girls'  dress`, cols: 3, rows: 1, imageName: "https://i.imgur.com/Ti8jl92.jpg", category: "girls-dress" },
          { title: `Girls'  Jeans`, cols: 3, rows: 1, imageName: "https://i.imgur.com/6ycNImP.jpg", category: "girls-jeans" }
          
        ];
      }

      return [
        { title: `Girls'  T-Shirt`, cols: 1, rows: 1, imageName: "https://i.imgur.com/BpEqmYz.jpg?1", category: "girls-tshirt" },
        { title: `Girls'  dress`, cols: 1, rows: 1, imageName: "https://i.imgur.com/Ti8jl92.jpg", category: "girls-dress" },
        { title: `Girls'  Jeans`, cols: 1, rows: 1, imageName: "https://i.imgur.com/6ycNImP.jpg",category: "girls-jeans" }
      ];
    })
  );
  boys = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title: `Boys' T-Shirt`, cols: 3, rows: 1, imageName: "https://i.imgur.com/QbzuagH.jpg", category: "boys-tshirt" },
          { title: `Boys'  Shirt`, cols: 3, rows: 1, imageName: "https://i.imgur.com/OfoDb8U.jpg", category: "boys-shirt" },
          { title: `Boys'  Jeans`, cols: 3, rows: 1, imageName: "https://i.imgur.com/VHmdKbI.jpg", category: "boys-jeans" }
          
        ];
      }

      return [
        { title: `Boys'  T-Shirt`, cols: 1, rows: 1, imageName: "https://i.imgur.com/QbzuagH.jpg", category: "boys-tshirt" },
        { title: `Boys'  Shirt`, cols: 1, rows: 1, imageName: "https://i.imgur.com/OfoDb8U.jpg", category: "boys-shirt" },
        { title: `Boys'  Jeans`, cols: 1, rows: 1, imageName: "https://i.imgur.com/VHmdKbI.jpg",category: "boys-jeans" }
      ];
    })
  );

  constructor(private breakpointObserver: BreakpointObserver, private router: Router) {
    
  }
  getImage(imageName: String) : string{
    return 'url('+imageName;
  }
  onSeeMoreClick(category: string){
    this.router.navigate(['/products', category]);
  }
}
