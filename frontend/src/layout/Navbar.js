import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import './Navbar.css'

export default function Navbar(){
return(
<div>
 <title>Diamond</title>

<nav className="navbar navbar-expand-lg navbar-dark bg-info">
     <a class="navbar-brand" href="#">
        <img src="/images/products/diamant.png" width="50" height="60" alt=""></img>
      </a>
      <a class="navbar-brand " href="/">Diamond Shop</a>

 <img src="/images/products/header.png" width="6450" height="60" alt=""></img>
  <div className="collapse navbar-collapse" id="navbarText">
    <ul className="navbar-nav mr-auto">

  <li className="nav-item active div-2">
                   <Link className="btn btn-danger mx-2" to={`/ligin`}>LogOut</Link>

</li>
    </ul>
  </div>
</nav>
</div>
)
}