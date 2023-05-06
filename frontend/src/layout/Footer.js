import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import './Navbar.css'

export default function Footer(){
return(
<div>

<div class="footer">
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
      <div class="container2 p-5">
        <div class="row textalgncenter">

          <div class="col-md mt-4 ml-3">
            <h5 class=" mb-4 font-weight-bold text-white">
              Residential
            </h5>
            <p class="marginbottom">
              <a href="#" class="colortext">Bracelet</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Charm</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Errings</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Necklage</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Ring</a>
            </p>
            <h5 class=" mb-4 font-weight-bold text-white mt-5">
              Contact
            </h5>
            <p class="marginbottom">
              <a href="#" class="colortext">Customer Service</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Advertise with Us</a>
            </p>
          </div>
          <div class="col-md mt-4 ml-3">
            <h5 class="mb-4 font-weight-bold text-white">Business</h5>
            <p class="marginbottom">
              <a href="#" class="colortext">Wedding</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Gift</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Anniversary</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Baptism </a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Employees</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Woman</a>
            </p>
          </div>
          <div class="col-md mt-4 ml-3">
            <h5 class=" mb-4 font-weight-bold text-white">
              Support
            </h5>
            <p class="marginbottom">
              <a href="#" class="colortext">Help Center</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Availability</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Service Outages</a>
            </p>
            <h5 class=" mb-4 font-weight-bold text-white mt-5">
              Corporate
            </h5>
            <p class="marginbottom">
              <a href="#" class="colortext">Company</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Careers</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Policy Center</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">News (Blog)</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Management Team</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Board of Directors</a>
            </p>
          </div>
          <div class="col-md mt-4 ml-3">
            <h5 class="mb-4 font-weight-bold text-white">Locations</h5>
            <p class="marginbottom">
              <a href="#" class="colortext">Adrian</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Blissfield</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Dundee</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Petersburg</a>
            </p>
            <p class="marginbottom">
              <a href="#" class="colortext">Tecumseh</a>
            </p>
          </div>
          <div class="col-md mt-4">
            <h5 class="mb-4 font-weight-bold text-white">Get Started</h5>
            <h5 class="mb-4 font-weight-bold text-white">Service Area</h5>
            <a href="#!" role="button"><img class="" src="/images/products/diamant2.png"></img></a>

          </div>
        </div>
      </div>
      <div class="container2">
        <div class="text-center p-3 border-top border-dark">
          <p class="colortext1 text-white">© 2023 DiamondShop @MariaV. All Rights Reserved.</p>
        </div>
      </div>
    </div>
</div>

)
}