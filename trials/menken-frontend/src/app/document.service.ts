import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Document } from './models/document.model';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  private apiUrl = 'http://localhost:8080/api/documents/all';

  constructor(private http: HttpClient) {}

  getDocuments(): Observable<Document[]> {
    return this.http.get<Document[]>(this.apiUrl);
  }
}
