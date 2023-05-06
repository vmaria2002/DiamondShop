import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Navbar from "./layout/Navbar"
import Footer from "./layout/Footer"
import Welcome from "./pages/Welcome"

import MyChartAur from "./chart/MyChartAur"
import MyChartArgint from "./chart/MyChartArgint"
import MyChartMarimeMica from "./chart/MyChartMarimeMica"
import MyChartMarimeMare from "./chart/MyChartMarimeMare"
import MyChartSBratara from "./chart/MyChartSBratara"
import MyChartInel from "./chart/MyChartInel"
import MyChartPandantiv from "./chart/MyChartPandantiv"
import MyChartColier from "./chart/MyChartColier"

import LogIn from "./login/LogIn"
import Register from "./login/Register"
import HomeUser from "./admin/HomeUsers"
import HomeCustomer from "./customer/HomeCustomer"
import AddUser from "./admin/AddUser"
import EditUser from "./admin/EditUser"
import ViewUser from "./admin/ViewUser"
import RaportTXT from "./rapoarte/RaportTXT"
import RaportJSON from "./rapoarte/RaportJSON"
import ViewShop from "./shop/ViewShop"
import AddProduct from "./shop/AddProduct"
import EditProduct from "./shop/EditProduct"
import EditProduct2 from "./shop/EditProduct2"

import {BrowserRouter as Router, Routes, Route} from "react-router-dom"

function App() {
  return (
    <div className="App">
    <Router>
         <Navbar/>
             <Routes>
                 <Route exact path="/" element={<Welcome/>}/>

                 <Route exact path="/homeuser" element={<HomeUser/>}/>
                  <Route exact path="/ligin" element={<LogIn/>}/>
                  <Route exact path="/register" element={<Register/>}/>
                  <Route exact path="/viewShop" element={<ViewShop/>}/>
                   <Route exact path="/adduser" element={<AddUser/>}/>
                   <Route exact path="/addproduct" element={<AddProduct/>}/>
                    <Route exact path="/ligin" element={<LogIn/>}/>
                    <Route exact path="/register" element={<Register/>}/>
                    <Route exact path="/edituser/:id" element={<EditUser/>}/>
                    <Route exact path="/editproduct/:id" element={<EditProduct/>}/>
                    <Route exact path="/editproduct2/:id" element={<EditProduct2/>}/>

                    <Route exact path="/viewuser/:id" element={<ViewUser/>}/>
                    <Route exact path="/txt/:id" element={<RaportTXT/>}/>
                    <Route exact path="/json/:id" element={<RaportJSON/>}/>

                     <Route exact path="/homecustomer" element={<HomeCustomer/>}/>

                     <Route exact path="/myChartAurInel" element={<MyChartAur/>}/>
                     <Route exact path="/myChartArgintInel" element={<MyChartArgint/>}/>
                     <Route exact path="/myChartArgint46" element={<MyChartMarimeMica/>}/>
                     <Route exact path="/myChartArgint47" element={<MyChartMarimeMare/>}/>
                     <Route exact path="/myBratsraSize4" element={<MyChartSBratara/>}/>
                     <Route exact path="/myInelAur" element={<MyChartInel/>}/>
                     <Route exact path="/myPandantiv" element={<MyChartPandantiv/>}/>
                     <Route exact path="/myColier" element={<MyChartColier/>}/>


              </Routes>
        <Footer/>
     </Router>
    </div>
  );
}

export default App;
