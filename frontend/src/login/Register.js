import axios from "axios";
import React, {useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import './Login.css'
export default function AddUser(){
  const [selectedRol, setSelectedRol] = useState('admin'); // Declare a state variable...
  let navigate = useNavigate()  //sa pt naviga printre pagini!

const [user, setUser]= useState({
        name:"",
        username:"",
        email:"",
        password:"",
});

const{name, username, email, password} = user
var tr=0;
var msg="";
let patternNume="[a-zA-Z]{3,}"
let patternUserName="[A-Z][_a-zA-Z0-9]{2,}"
let patternEmail= ".+@.+\\.[a-zA-Z]+"
let patternPassword=".+[a-zA-Z0-9]{3}"

const onInputChange=(e)=>{
setUser({...user, [e.target.name]:e.target.value})
};

const onSubmit = async (e) => {

//await axios.post(`http://localhost:8080/api/users//m_12`, tr);
      e.preventDefault();//sa mu ne apara in path tot ce scriem in formular
        //await axios.post(`http://localhost:8080/api/users/register/m_12`, tr);
        e.preventDefault();//sa mu ne apara in path tot ce scriem in formular
            //await axios.post(`http://localhost:8080/api/users/login/m_12`, tr);
           if(user.name.match(patternNume)===null){
                 alert("Invalid name: Trebuie sa contina cel putin 3 litere");
                 navigate("/register");
            }
            if(user.username.match(patternUserName)===null){
             alert("Invalid username: Trebuie sa incepa cu majuscula. Sa contina litrere mar, mici si _. Cel putin 3 caractere");
            navigate("/register");
            }
            else if(user.email.match(patternEmail)===null){
            alert("Invalid email. Trebuie sa contina litere . @");
            navigate("/register");
            }else if(user.password.match(patternPassword)===null){
            alert("Invalid password. Dimensune 3 caeactere, litere mari, mici, cifre.");
            navigate("/register");
            } else if(user.name==="MariaV"){
            alert("User-ul exista");
            navigate("/register");
             }
            else{  navigate("/homeuser");
              await axios.post("http://localhost:8080/api/users/adduser", user);
             }
  };

return <div className="container bkd p-4">
    <div className="row">
     <div className="col-md-6 offset-md-3 boarder rounded p-4 mt-2 shadow">
           <h2 className="text-center m-4"> Register User</h2>
           <form onSubmit={(e)=>onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
              type={"text"}
              className="form-control"
              placeholder="Maria"
              name="name"
              value={name}
              onChange={(e)=>onInputChange(e)}             />
            </div>
             <div className="mb-3">
              <label htmlFor="Username" className="form-label">
                Username :)
              </label>
              <input
              type={"text"}
              className="form-control"
              placeholder="Mia_1 "
              name="username"
              value={username}
              onChange={(e)=>onInputChange(e)}
              />
            </div>
             <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                Email
              </label>
              <input
              className="form-control"
              placeholder="maria12@yahoo.com"
              name="email"
              value={email}
              onChange={(e)=>onInputChange(e)}
              />
            </div>
              <div className="mb-3">
              <label htmlFor="Password" className="form-label">
                Password
              </label>
              <input
              type={"password"}
              className="form-control"
              placeholder="dfgd@487^%42frt"
              name="password"
              value={password}
              onChange={(e)=>onInputChange(e)}
              />
            </div>
             <div class="alert alert-warning" role="alert">
                          Selectati tipul de utilizator  :
                         <select required
                                name="duration" required
                                   value={user.duration} // ...force the select's value to match the state variable...
                                     onChange={e => onInputChange(e)} // ... and update the state variable on any change!
                                         required >
                                    required
                                               <option value="ADMIN">ADMIN</option>
                                               <option value="CUSTOMER">CUSTOMER</option>


                                            </select>
            </div>
            <button type="submit" className="btn btn-outline-primary" > Add new User </button>
            <Link className="btn btn-outline-danger mx-2 p-9" to="/">Cancel </Link>
          </form>
       </div>
    </div>
</div>


}