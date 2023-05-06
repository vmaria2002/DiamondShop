import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams, useNavigate } from "react-router-dom";
import './HomeUsers.css'

export default function Home() {
  const [users, setUsers] = useState([]);
 let navigate = useNavigate()  //sa pt naviga printre pagini!

  const { id } = useParams();
  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/api/users/allusers");
    setUsers(result.data);
  };

   const deleteUser = async (id) => {
      await axios.delete(`http://localhost:8080/api/users/deleteuser/${id}`);
      loadUsers()
    };

  return (
    <div className="container">

<nav className="navbar2 navbar-expand-lg navbar-dark">


  <div className="collapse navbar-collapse" id="navbarText">
    <ul className="navbar-nav mr-auto">

  <li className="nav-item active div-2 p-3">

      <Link class="btn btn-danger" to="/adduser">Add New User</Link>

     </li>
    </ul>

      <Link className="btn btn-warning mx-2" to={`/viewShop`}>Products Page </Link>
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
                  <div class="card p-2">
                    <img class="App-logo2 rounded mx-auto d-block img2" src={user.img} alt="Card image cap"/>
                    <div class="card-body">
                      <h5 class="card-title">name: {user.name}</h5>
                      <p class="card-text">ID:{user.id} </p>
                      <p class="card-text">Email:{user.email} </p>
                      <p class="card-text">Adresa:{user.address} </p>
                    </div>
                    <div class="card-footer">

                    <Link className="btn btn-dark mx-2" to={`/viewuser/${user.id}`}>Details order</Link>
                    <Link  className="btn btn-outline-primary mx-2" to={`/edituser/${user.id}`} > Edit User </Link>
                    <button className="btn btn-danger mx-2"
                            onClick={() => deleteUser(user.id)} > Delete
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