import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class LoggedInDataService {
  loggedIn = new BehaviorSubject<boolean> (false);
 
}
