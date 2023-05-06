import axios from "axios";
import React, {useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
export default function AddUser(){

  let navigate = useNavigate()  //sa pt naviga printre pagini!

const [user, setUser]= useState({
        name:"",
        username:"",
        email:"",
        password:"",
        img:"",
        address:""

});


const{name, username, email, password, img, address} = user

const onInputChange=(e)=>{

setUser({...user, [e.target.name]:e.target.value})

};

const onSubmit = async (e) => {

    e.preventDefault();//sa mu ne apara in path tot ce scriem in formular
    await axios.post("http://localhost:8080/api/users/adduser", user);
    navigate("/homeuser");
  };

return <div className="container p-4">

    <div className="row g-3 requires-validation">
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
              onChange={(e)=>onInputChange(e)}
              required />
            </div>


             <div className="mb-3">
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
              <label htmlFor="Email" className="form-label">
                Email
              </label>
              <input
              type={"text"}
              className="form-control"
              placeholder="maria12@yahoo.com"
              name="email"
              value={email}
              onChange={(e)=>onInputChange(e)}
               required
              />
            </div>

            <div className="mb-3">
              <label htmlFor="Address" className="form-label">
                Adresa
              </label>
              <input
              type={"text"}
              className="form-control"
              placeholder="Cluj, Str. Observatprului 34"
              name="address"
              value={address}
              onChange={(e)=>onInputChange(e)}
               required
              />
            </div>

              <div className="mb-3">
              <label htmlFor="Password" className="form-label">
                Password
              </label>
              <input
              type={"text"}
              className="form-control"
              placeholder="dfgd@487^%42frt"
              name="password"
              value={password}
              onChange={(e)=>onInputChange(e)}
              required
              />
            </div>

               <div class="card text-white bg-warning mb-3">
                      <div class="card-header"><b>Profile photo</b></div>
                      <div class="card-body">
                          <div class="form-row">
                              <div class="form-group col-lg-12 col-md-12 col-sm-12 col-12">
                                  <label for="attach" class="form-label">Please attach your picture</label>
                                  <input type="file" id="attach" name="img" value={img}
                                  onChange={(e)=>onInputChange(e)} accept="application/png,application/vnd.ms-excel"
                                  class="form-control" required/>
                              </div>
                            </div>
                         </div>
                    </div>

            <button type="submit" className="btn btn-outline-primary mx-2 p-9"> Add new User </button>
            <Link className="btn btn-outline-danger mx-2 p-9" to="/homeuser">Cancel </Link>
          </form>
       </div>
    </div>
</div>


}