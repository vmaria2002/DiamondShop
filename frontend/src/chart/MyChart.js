import Chart from "chart.js/auto";
import { Bar } from "react-chartjs-2";
import './PieChart.css'
import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

const PieChart = () => {
const [user, setUser] = useState({
       name:"",
       price: 0,
       description: "",
       material:"",
       size:0,
       availability: 0,
       type:0,
       culoare:""
  });

  const { id } = useParams();
  const { field } = useParams();
  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/api/chart/${field}/${id}`);
    setUser(result.data);
  };


var msg="";
var culoare="alert alert-danger";
var bkt=[];

if(user.culoare==="red" ){
          bkt=[ 'rgba(0, 162, 0, 0.2)',];
}else{
         bkt=['rgba(255, 99, 132, 0.2)',];
}

const labels = mylabels;
const dataProdus = {
  labels: labels,
  datasets: [
    {
       label: "pret",
       backgroundColor: bkt,
       borderColor: "rgb(0,0,0)",
      data: [produs.price].
    },
  ],
}

  return (
    <div className="chart">
    <br></br>

<div class="alert alert-dark" role="alert">
  Produs
</div>
 <div className="chart">
<br></br>
       <div class="card text-white bg-dark mb-3">
         <div class="card-body">
           <div class="card-title"> Raport pentru produsul din magazin
           <p> Informatii: {user.name}
          <p>{user.price}</p>
          <p>{user.description}</p>
          <p>{user.material}</p>
          <p>{user.size}</p>
           </div>
         </div>
       </div>
        <div class="card text-white bg-danger">
        <p>Legenda culorilor:</p>
                 <div>Daca pretul este mai mic de  $1000==>verde.  Daca pretul  mai mare de  $1000==> rosie </div>
         </div>
      <Bar data={dataProdus} />
     <div class="card text-white bg-dark mb-3">
    </div>
  );
};
export default PieChart;