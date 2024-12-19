import { Component, Input } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'app-product-summary',
  imports: [],
  templateUrl: './product-summary.component.html',
  styleUrl: './product-summary.component.css'
})
export class ProductSummaryComponent {
  @Input() products:Product[]=[]
  numberOfProduct=this.products.length
}