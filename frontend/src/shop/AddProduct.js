import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";


export default function AddProduct() {
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
    await axios.post(`http://localhost:8080/api/produs/newprodus/${id}`, user);
    navigate("/viewShop");
  };
 const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/api/users/update/${user.idItem}`);
    setUser(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">

        <div class="alert alert-warning" role="alert">
          <h2 className="text-center m-4">Product</h2>
        </div>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter the name for product"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Username" className="form-label">
                Description
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Describe the product "
                name="description"
                value={description}
                onChange={(e) => onInputChange(e)}
                 required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Material" className="form-label">
                Material
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Material: aur/argint"
                name="material"
                value={material}
                onChange={(e) => onInputChange(e)}
                required
              />
            </div>
          <div className="mb-3">
          <label htmlFor="text" className="form-label">
            Size
          </label>
          <input
            type={"text"}
            className="form-control"
            placeholder="1/2/3/4"
            name="size"
            value={size}
            onChange={(e) => onInputChange(e)}
            required
          />
        <label htmlFor="text" className="form-label">
          Type
        </label>
        <input
              type={"text"}
              className="form-control"
              placeholder="0/1/2/3"
              name="type"
              value={type}
              onChange={(e) => onInputChange(e)}
              required
        />
        </div>
            <div className="mb-3">
              <label htmlFor="Username" className="form-label">
                Price
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="989.8 "
                name="price"
                value={price}
                onChange={(e) => onInputChange(e)}
                 required
              />
            </div>
               <div class="card text-white bg-warning mb-3">
                      <div class="card-header"><b>Picture for product</b></div>
                      <div class="card-body">
                          <div class="form-row">
                              <div class="form-group col-lg-12 col-md-12 col-sm-12 col-12">
                                  <label for="attach" class="form-label">Please attach a new picture</label>
                                  <input type="file" id="attach" name="nameImg" value={nameImg}
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