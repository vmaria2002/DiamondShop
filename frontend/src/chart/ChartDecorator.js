import Chart from "chart.js/auto";
import { Bar, Pie } from "react-chartjs-2";
import './PieChart.css'
import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

const ChartDecorator = () => {
const [user, setUser] = useState({
    name:"",
    price: 0,
    description: "",
    material:"",
    availability: 0,
    size:0,
    type:0,
    culoare:""

  });
  const { id } = useParams();
  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/api/users/getuser/${id}`);
    setUser(result.data);
  };

const nr = user.stress.split(",");

var bkt;
var text="";
var msg="";
var dataa;
var culoare="";
if(user.culoare==="red" ){
          bkt=[ 'rgba(0, 162, 0, 0.2)',];
}else{
         bkt=['rgba(255, 99, 132, 0.2)',];
}

const labels = ["pret"];
const data = {
  labels: labels,
  datasets: [
    {
      label: user.description,
       backgroundColor: bkt,
      borderColor: "rgb(0,0,0)",
      data: dataa,
    },
  ],
};
  return (

<div className="chart">
<br></br>
<div class={user.culoare} role="alert">
</div>
      <Pie data={data} />
      <br></br>
</div>
  );
};
export default ChartDecorator;