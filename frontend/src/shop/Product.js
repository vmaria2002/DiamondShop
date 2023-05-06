import React from 'react';
import { Link, useNavigate } from "react-router-dom";
import './Product.css';

export default function Product(props) {
  const { product, onAdd } = props;
  return (
    <div>
     <div class="row">
        <div class="col">
          <img className="small img2 App-logo2" src={product.image} alt={product.name} />
        </div>
        <div class="col p-3">
         <h3>{product.name}</h3>
           <div> <em> Descriere: {product.descriere}</em> </div>

           <div>${product.price}</div>
           <div> <b>Material:</b> {product.material} </div>
          <div>
            <button type="button" class="btn btn-dark" onClick={() => onAdd(product)}>Add To Cart</button>
            <Link  className="btn btn-outline-danger mx-2" to={`/editproduct2/${product.id}`} > View Product </Link>
          </div>
        </div>
       </div>


    </div>
  );
}