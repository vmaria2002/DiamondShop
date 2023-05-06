import axios from "axios";
import React, {useEffect, useState, Component,useContext } from "react";
import { Link, useParams, useNavigate } from "react-router-dom";
import './viewShop.css'

export default function ViewShop() {
  const [users, setUsers] = useState([]);
 let navigate = useNavigate()  //sa pt naviga printre pagini!

  const { idItem } = useParams();
  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8081/api/items");
    setUsers(result.data);
  };

   const deleteUser = async (idItem) => {
      await axios.delete(`http://localhost:8081/api/items/${idItem}`);
      loadUsers()
    };

  return (
    <div className="container">

<nav className="navbar2 navbar-expand-lg navbar-dark">
  <div className="collapse navbar-collapse" id="navbarText">
    <ul className="navbar-nav mr-auto">

  <li className="nav-item active div-2 p-3">

      <Link class="btn btn-danger" to="/addproduct">Add New Produs</Link>

     </li>
    </ul>

          <Link className="btn btn-warning mx-2" to={`/homeuser`}>Customer Page </Link>

  </div>
</nav>
    <div class="card p-16">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
          </thead>
          <tbody>
            {users.map((user, index) => (
              <tr>
               <div class="row">
                  <div class="col">
                     <div class="App-logo2 ">
                         <img class="rounded mx-auto d-block img2" src={user.nameImg} alt="Card image cap"/>
                       </div>
                  </div>
                  </div>
                  <div class="col">
                     <div class="card-body">
                         <h5 class="card-title">{user.name}</h5>
                         <p class="card-text">{user.description} </p>
                         <p class="card-text">Material:{user.material} </p>
                         <p class="card-text">Size:{user.size} </p>
                         <p class="card-text">Price:{user.price} </p>
                       </div>
                       <div class="card-footer">
                           <Link  className="btn btn-outline-primary mx-2" to={`/editproduct/${user.idItem}`} > View Product </Link>
                           <button className="btn btn-danger mx-2"
                                   onClick={() => deleteUser(user.idItem)} > Delete
                           </button>
                          </div>
                     </div>
                   </tr>
               ))}
          </tbody>
        </table>
      </div>
      </div>
    </div>
  );
}