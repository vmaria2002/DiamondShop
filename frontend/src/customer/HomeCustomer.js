import axios from "axios";
import React, {useEffect, useState, Component,useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import cartContext from '../shop/cartContext';
import Header from '../shop/Header';
import Basket from '../shop/Basket';
import Main from '../shop/Main';
import data from '../data'
import './Home.css'


const HomeCustomer = () => {
 const { products } = data;
  const [cartItems, setCartItems] = useState([]);
  const onAdd = (product) => {
    const exist = cartItems.find((x) => x.id === product.id);
    if (exist) {
      setCartItems(
        cartItems.map((x) =>
          x.id === product.id ? { ...exist, qty: exist.qty + 1 } : x
        )
      );
    } else {
      setCartItems([...cartItems, { ...product, qty: 1 }]);
    }
  };
  const onRemove = (product) => {
    const exist = cartItems.find((x) => x.id === product.id);
    if (exist.qty === 1) {
      setCartItems(cartItems.filter((x) => x.id !== product.id));
    } else {
      setCartItems(
        cartItems.map((x) =>
          x.id === product.id ? { ...exist, qty: exist.qty - 1 } : x
        )
      );
    }
  };
    return (

        <div>
        <Header countCartItems={cartItems.length}></Header>
              <div className="row">

                <Main products={products} onAdd={onAdd}></Main>
                <Basket
                  cartItems={cartItems}
                  onAdd={onAdd}
                  onRemove={onRemove}
                ></Basket>
              </div>
        </div>
    );
};

export default HomeCustomer;