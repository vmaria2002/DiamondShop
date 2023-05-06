import Chart from "chart.js/auto";
import { Bar } from "react-chartjs-2";
import './PieChart.css'
import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";
var date = new Date();
const MyChartAur = () => {
const [user, setUser] = useState({
    name:"",
    price: 0,
    description: "",
    material:"",
    availability: 0,
    size:0,
    type:0
  });

  const { id } = useParams();
  const { field } = useParams();

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/api/chart/material/${field}/${id}`);
    setUser(result.data);
  };

var bkt=[];
if(user.culoare==="red" ){
          bkt=[ 'rgba(0, 162, 0, 0.2)',];
}else{
         bkt=['rgba(255, 99, 132, 0.2)',];
}

var culoare="alert alert-danger";
var mylabels=[user.description];
const labels = [user.description];
const dataAur = {
  labels: labels,
  datasets: [
    {
       label: "pret",
       backgroundColor: bkt,
      borderColor: "rgb(0,0,0)",

      data: [user.price]
    },
  ],
}
  return (
    <div className="chart">
<br></br>
       <div class="card text-white bg-dark mb-3">
         <div class="card-body">
           <div class="card-title"> Raport pentru cerceii din magazin</div>
            <p> Informatii: {user.name}
            <p>{user.price}</p>
            <p>{user.description}</p>
            <p>{user.material}</p>
            <p>{user.size}</p>
         </div>
       </div>
       <div class="card text-white bg-danger">
       <p>Legenda culorilor:</p>
                <div>Daca pretul este mai mic de  $1000==>verde.  Daca pretul  mai mare de  $1000==> rosie </div>
        </div>
      <Bar data={dataAur} />
     <div class="card text-white bg-dark mb-3">


     </div>

    </div>
  );
};
export default MyChartAur;