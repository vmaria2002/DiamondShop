import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";


export default function ViewProduct() {
  let navigate = useNavigate();

  const { idItem } = useParams();

  const [user, setUser] = useState({
         name: "",
         price: 0,
         description: "",
         material: "",
         availability: true,
         size: "",
         type: 1,
         nameImg:"",
  });

  const { name,price,description,material,availability, size, type, nameImg } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadUser();
  }, []);

const onSubmit = async (e) => {

    e.preventDefault();//sa mu ne apara in path tot ce scriem in formular
    await axios.post("http://localhost:8081/api/items", user);
    navigate("/viewShop");
  };


 const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/api/users/update/${user.idItem}`);
    setUser(result.data);
  };

  return (
    <div className="container p-3">
         <div class="row">
           <div class="col">
              <div class="card text-white bg-dark p-6">
               <div class="card-header">Product Information</div>
               <div class="card-body">
                 <h5 class="card-title"> Name:  {user.name} </h5>
                 <i><h5 class="card-title">  Description:  {user.description} </h5></i>
                 <h5 class="card-title"> Size:   {user.size} </h5>
                 <h5 class="card-title"> Material:{user.material} </h5>
                 <h5 class="card-title"> Price: ${user.price} </h5>
               </div>
             </div>
            <br></br>
          <Link className="btn btn-outline-danger mx-2 p-6" to="/viewShop">
                Back
          </Link>
           </div>
            <div class="col">
                   <div class="App-logo">
                     <img class="rounded mx-auto d-block img2" src='/images/products/cercei11.jpg' alt="Card image cap"/>
                   </div>
            </div>
        </div>
    </div>
);
}