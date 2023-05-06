import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container , Dropdown} from 'react-bootstrap';
import './viewShop.css'
import { Link } from 'react-router-dom';
export default function Header(props) {

  return (
   <header className="block  center">
<nav class="navbar2 navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">
    </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
      <a class="nav-link">
           <Container className='p-4'>
           <Dropdown>
          <Dropdown.Toggle variant=" primary" id="dropdown-basic">
            <img src="./images/products/cercei15.jpg" width="30" height="50" class="d-inline-block align-top" alt="Cercei"/>
          </Dropdown.Toggle>
         <Dropdown.Menu>
            <Dropdown.Item href='/myChart/material/inel/${material}/${id}'>  <Link to="/my-html-page.html" />Cercei Aur</Dropdown.Item>
            <Dropdown.Item href='/myChart/material/inel/${material}/${id}'>Cercei Argint</Dropdown.Item>
            <Dropdown.Item href='/myChart/size/inel/${size}/${id}'>Cercei Marime 46</Dropdown.Item>
            <Dropdown.Item href='/myChart/size/inel/${size}/${id}'>Cercei Marime 47</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
        </Container>
     </a>
      </li>
      <li class="nav-item">
         <a class="nav-link">
                   <Container className='p-4'>
                   <Dropdown>
                  <Dropdown.Toggle variant=" primary" id="dropdown-basic">
                    <img src="./images/products/bratara9.jpg" width="30" height="50" class="d-inline-block align-top" alt="Bratara"/>
                  </Dropdown.Toggle>
                  <Dropdown.Menu>
                    <Dropdown.Item href='/myChart/material/bratara/${material}/${id}'>Bratara Aur</Dropdown.Item>
                    <Dropdown.Item href='/myChart/material/bratara/${material}/${id}'>Bratara Argint</Dropdown.Item>
                    <Dropdown.Item href='/myChart/size/bratara/${size}/${id}'>Bratara Marime 4</Dropdown.Item>
                    <Dropdown.Item href='/myChart/size/bratara/${size}/${id}'>Bratara Marime 5</Dropdown.Item>
                  </Dropdown.Menu>
                </Dropdown>
                </Container>
             </a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link">
           <Container className='p-4'>
           <Dropdown>
          <Dropdown.Toggle variant=" primary" id="dropdown-basic">
            <img src="./images/products/img19.jpg" width="30" height="50" class="d-inline-block align-top" alt="Inele"/>
          </Dropdown.Toggle>
          <Dropdown.Menu>
            <Dropdown.Item href='/myChart/material/inel/${material}/${id}'>Inele Aur</Dropdown.Item>
            <Dropdown.Item href='/myChart/material/inel/${material}/${id}'>Inele Argint</Dropdown.Item>
            <Dropdown.Item href='/myChart/size/inel/${size}/${id}'>Inele Marime 50</Dropdown.Item>
            <Dropdown.Item href='/myChart/size/inel/${size}/${id}'>Inele Marime 54</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
        </Container>
    </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link">
               <Container className='p-4'>
               <Dropdown>
              <Dropdown.Toggle variant=" primary" id="dropdown-basic">
                <img src="./images/products/charm5.jpg" width="30" height="50" class="d-inline-block align-top" alt="Pandantiv"/>
              </Dropdown.Toggle>
              <Dropdown.Menu>
                <Dropdown.Item href='/myChart/material/pamdantiv/${material}/${id}'>Pandantiv Aur</Dropdown.Item>
                <Dropdown.Item href='/myChart/material/pandantiv/${material}/${id}'>Pandantiv Argint</Dropdown.Item>
                <Dropdown.Item href='/myChart/size/pandantiv/${size}/${id}'>Pandantiv  Marime standard</Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>
            </Container>
            </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link">
           <Container className='p-4'>
           <Dropdown>
          <Dropdown.Toggle variant=" primary" id="dropdown-basic">
            <img src="./images/products/lant1.jpg" width="30" height="50" class="d-inline-block align-top" alt="Colier"/>
          </Dropdown.Toggle>
          <Dropdown.Menu>
            <Dropdown.Item href='/myChart/material/colier/${material}/${id}'>Colier Aur</Dropdown.Item>
            <Dropdown.Item href='/myChart/material/colier/${material}/${id}'>Colier Argint</Dropdown.Item>
            <Dropdown.Item href='/myChart/size/colier/${size}/${id}'>Colier  Marime 35</Dropdown.Item>
            <Dropdown.Item href='/myChart/size/colier/${size}/${id}'>Colier  Marime 41</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
        </Container>
        </a>
  </li>
  <li class="nav-item rounded float-right">
      <img src="./images/alb.jpg" width="80" height="50" float="right" margin-left="10px" class="d-inline-block rounded float-right" alt="Colier"/>
  </li>
        <li class="nav-item rounded float-right">
            <div class="bi bi-cart  my-2 my-sm-0 rounded float-right ">
             <a href="#/cart">
                <img src="./images/cart.jpg" width="30" height="50" float="right" margin-left="10px" class="d-inline-block rounded float-right" alt="Colier"/>
               {props.countCartItems ? (
                 <button className="badge">{props.countCartItems}</button>
               ) : (
                 '' )}
              </a>{' '}
            </div>
            </li>
            </ul>
          </div>
        </nav>
    </header>
  );
}