import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../document.service';
import { Document } from '../models/document.model';

@Component({
  selector: 'app-document-list',
  templateUrl: './document-list.component.html',
  styleUrls: ['./document-list.component.css']
})
export class DocumentListComponent implements OnInit {

  documents: Document[] = [];
  filteredDocuments: Document[] = [];
  sortDirection: boolean = true;   
  sortColumn: string = 'weight';   
  documentNames: string[] = [];

  filter = {
    documentType: "",
    probability: null
  }

  constructor(private documentService: DocumentService) {}

  ngOnInit(): void {
    // Triggers doc fetching on page load.
    this.loadDocuments();
  }

  // Fetches documents from api
  loadDocuments(): void {
    this.documentService.getDocuments().subscribe(data => {
      this.documents = data;
      this.documentNames = Array.from(new Set(data.map(doc => doc.documentType)));
      this.filteredDocuments = [...this.documents];
    });
  }

  // Sorts documents based on which column header is currently selected.
  sortDocuments(): void {
    this.filteredDocuments.sort((a, b) => {
      if (this.sortColumn === 'documentType') {
        return this.sortDirection ? a.documentType.localeCompare(b.documentType) : b.documentType.localeCompare(a.documentType);
      } else if (this.sortColumn === 'weight') {
        return this.sortDirection ? a.weight - b.weight : b.weight - a.weight;
      }
      return 0;
    });
  }

  // Filters documents based on input fields.
  filterDocuments(): void {
    this.filteredDocuments = this.documents.filter(document => {
      const matchesDocumentType = this.filter.documentType ? document.documentType === this.filter.documentType : true;
      const matchesProbability = this.filter.probability !== null ? document.weight * 100 > this.filter.probability : true;
      return matchesDocumentType && matchesProbability;
    });

    
    this.sortDocuments();
  }
  
  // Takes input from headers and sets sort direction.
  sortBy(column: string): void {
    if (this.sortColumn === column) {
      this.sortDirection = !this.sortDirection;
    } else {
      this.sortColumn = column;
      this.sortDirection = true;
    }
  
    this.sortDocuments();
  }
}
