import axios from "axios";
import React, {useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import './Login.css'
export default function LogIn(){

let navigate = useNavigate()  //sa pt naviga printre pagini!
const [selectedRol, setSelectedRol] = useState('admin'); // Declare a state variable...

var userId="MariaV";
var msg="";
const [user, setUser]= useState({
        username:"",
        password:"",
        rol:"",
        path:""

});
var pathX="/homeuser";
var c=0;
const{name, username, email, password, rol} = user

const onInputChange=(e)=>{
setUser({...user, [e.target.name]:e.target.value})
};

const onSubmit = async (e) => {

    e.preventDefault();//sa mu ne apara in path tot ce scriem in formular
    userId=user.username;

    //await axios.post(`http://localhost:8080/api/users/login/m_12`, tr);

    if(user.username==="MariaV"){
    pathX="/homeuser";
    navigate("/homeuser");
   // await axios.post("http://localhost:8080/api/users/adduser", user);
    }else{
            alert("Nu exista contul!")

    }

  };

return <div className="container bkd">

<div style={{
   }}>


    <div className="col-md-6 offset-md-3 boarder rounded p-4 mt-2 shadow">
           <h2 className="text-center m-4"> Login User</h2>
           <form onSubmit={(e)=>onSubmit(e)}>

             <div className="mb-3 alert alert-light p-8">

              <label htmlFor="Username" className="form-label">
                Username :)
              </label>

              <input
              type={"text"}
              className="form-control"
              placeholder="Mari1 "
              name="username"
              value={username}
              onChange={(e)=>onInputChange(e)}
              required/>
            </div>

              <div className="mb-3">
               <div class="alert alert-light p-8" role="alert"><label htmlFor="Password" className="form-label">
                Password
              </label>

              <input
              type={"password"}
              className="form-control"
              placeholder="dfgd@487^%42frt"
              name="password"
              value={password}
              onChange={(e)=>onInputChange(e)}
              required/>
            </div>
 </div>

            <br></br>


          <div class="alert alert-light p-8" role="alert">
                          Selectati tipul de utilizator  :
                         <select required
                                name="rol" required
                                   value={user.rol} // ...force the select's value to match the state variable...
                                     onChange={e => onInputChange(e)} // ... and update the state variable on any change!
                                         required >
                                    required
                                   <option value="ADMIN">ADMIN</option>
                                   <option value="CUSTOMER">CUSTOMER</option>
                          </select>
            </div>

            {user.rol === "ADMIN" ? (
                  <Link className="btn btn-outline-light mx-2 p-9" to="/homeuser">
                    LogIn {user.rol}
                  </Link>
                  ) : (
                  <Link className="btn btn-outline-danger mx-2 p-9" to="/homecustomer">
                          LogIn {user.rol}
                        </Link>
             )}
            <Link className="btn btn-outline-danger mx-2 p-9" to="/">Cancel </Link>
          </form>
       </div>
    </div>
</div>

}