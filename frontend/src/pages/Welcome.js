import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import './Welcome.css'


export default function Home() {
return(

<div class="container">
  <div class="row">
    <div class="col m-3">
        <img src="/images/products/back.jpg"></img>
    </div>
    <div class="col m-3">

     <div class="card">
        <img class="card-img rounded mx-auto d-bloc img2" src="/images/products/img17.jpg"/>
        <div class="card-body">
          <p class="card-text">O poveste de iubire autentică și un inel de logodnă care o completează. Alege-l din colecția Diamond.</p>
        </div>
      </div>

     <div class="card">
        <img class="card-img rounded mx-auto d-bloc img2" src="/images/products/img7.jpg"/>
        <div class="card-body">
          <p class="card-text">
        Bijuterii inspirate de cel mai frumos „Da”, într-o colecție dedicată unui nou început.</p>
        </div>
      </div>

     <br></br>
     <Link className="btn btn-danger mx-2" to="/register">Register</Link>
     <Link class="btn btn-danger" to="/ligin">LogIn</Link>

    </div>
  </div>
</div>





)
}






