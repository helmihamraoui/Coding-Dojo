import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ProductDetailsComponent } from "../product-details/product-details.component";
import { ProductSummaryComponent } from "../product-summary/product-summary.component";

@Component({
  selector: 'app-product-list',
  imports: [CommonModule, ProductDetailsComponent, ProductSummaryComponent],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {
  products = [
    {
      id: 4,
      name: "Laptop",
      price: "1500$",
      description: "A portable computer for work and play"
    },
    {
      id: 5,
      name: "Chair",
      price: "150$",
      description: "Provides comfort and support for your back"
    },
    {
      id: 6,
      name: "Table",
      price: "300$",
      description: "A sturdy surface for work or dining"
    },
    {
      id: 7,
      name: "Watch",
      price: "250$",
      description: "Keeps you punctual and stylish"
    },
    {
      id: 8,
      name: "Speaker",
      price: "100$",
      description: "Enhances your audio experience"
    },
    {
      id: 9,
      name: "Camera",
      price: "800$",
      description: "Captures your memorable moments in high quality"
    }
  ];
}