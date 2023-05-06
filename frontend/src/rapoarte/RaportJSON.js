import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {
  const [user, setUser] = useState({
    name: "",
    username: "",
    email: "",
    password:"",
   price: 0,
   description: "",
   material:"",
   size:0,
   availability: 0,
   type:0,
   culoare:""
  });

  const { id } = useParams();

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {


    const result = await axios.get(`http://localhost:8080/api/raport/json/${id}`);

     setUser(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">User Details</h2>

          <div className="card">
            <div className="card-header">
              Details of user id : {user.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Name:</b>
                  {user.name}
                </li>
                <li className="list-group-item">
                  <b>UserName:</b>
                  {user.username}
                </li>
                <li className="list-group-item">
                  <b>Email:</b>
                  {user.email}
                </li>

                <li className="list-group-item">
                  <b>Password:</b>
                  {user.password}
                </li>
              </ul>

              <h2 className="text-center m-4">Details about sleep</h2>

                        <div className="card">
                          <div className="card-header">
                            <ul className="list-group list-group-flush">
                              <li className="list-group-item">
                                <b>Description:</b>
                                {user.description}
                              </li>
                                <p> Informatii: {user.name}
                                <p>{user.price}</p>
                                <p>{user.description}</p>
                                <p>{user.material}</p>
                                <p>{user.size}</p>
                            </ul>
                        </div>
                 </div>
            </div></div>
            <Link className="btn btn-primary my-2" to={"/homeuser"}>
            Back to Home
          </Link>
        </div>
      </div>
    </div>
  );
}