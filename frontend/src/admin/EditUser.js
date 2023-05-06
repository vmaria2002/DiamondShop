import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";


export default function EditUser() {
  let navigate = useNavigate();

  const { id } = useParams();

  const [user, setUser] = useState({
    name: "",
    username: "",
    email: "",
    password:"",
    address:"",
    img:""
  });

  const {name, username, email, password, img, address } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadUser();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/api/users/update/${id}`, user);
    navigate("/homeuser");
  };

 const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/api/users/update/${user.id}`);
    setUser(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit User</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
                required
              />
            </div>



            <div className="mb-3">
              <label htmlFor="Username" className="form-label">
                Username
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your username"
                name="username"
                value={username}
                onChange={(e) => onInputChange(e)}
                 required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                E-mail
              </label>
              <input
                type={"email"}
                className="form-control"
                placeholder="Enter your e-mail address"
                name="email"
                value={email}
                onChange={(e) => onInputChange(e)}
                required
              />
            </div>

             <div className="mb-3">
          <label htmlFor="Password" className="form-label">
            Password
          </label>
          <input
            type={"password"}
            className="form-control"
            placeholder="Enter your password"
            name="password"
            value={password}
            onChange={(e) => onInputChange(e)}
            required
          />
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
        </div>
               <div class="card text-white bg- mb-3">
                      <div class="card-header"><b>Profile other photo</b></div>
                      <div class="card-body">
                          <div class="form-row">
                              <div class="form-group col-lg-12 col-md-12 col-sm-12 col-12">
                                  <label for="attach" class="form-label">Please attach a new picture</label>
                                  <input type="file" id="attach" name="img" value={img}
                                  onChange={(e)=>onInputChange(e)} accept="application/png,application/vnd.ms-excel"
                                  class="form-control" required/>
                              </div>
                            </div>
                         </div>
                    </div>

            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/homeuser">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}