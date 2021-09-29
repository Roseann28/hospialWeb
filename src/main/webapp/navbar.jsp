<html>
<style>

.navbar {
  overflow: hidden;
  background-color: #333;
  font-family: Arial;
}


.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}


.dropdown {
  float: left;
  overflow: hidden;
}


.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}


.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}


.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}


.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}


.dropdown-content a:hover {
  background-color: #ddd;
}


.dropdown:hover .dropdown-content {
  display: block;
}
</style>
<body>
         <div class="navbar">
          <div class="dropdown">
            <button class="dropbtn">Patients
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="http://localhost:8080/HospitalWeb/patient/form">Add patient</a>
              <a href="http://localhost:8080/HospitalWeb/patient/list">View Patients</a>
            </div>
          </div>

          <div class="dropdown">
            <button class="dropbtn">Staff
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="http://localhost:8080/HospitalWeb/staffs/form">Add staff</a>
              <a href="http://localhost:8080/HospitalWeb/staffs/list">View Staff</a>
            </div>
          </div>

          <div class="dropdown">
            <button class="dropbtn">Basic Measurement
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="http://localhost:8080/HospitalWeb/basics/form">Add Basic measurement</a>
              <a href="http://localhost:8080/HospitalWeb/basics/list">View Basic measurement</a>
            </div>
          </div>

          <div class="dropdown">
            <button class="dropbtn">Ailment
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="http://localhost:8080/HospitalWeb/ailment/form">Add Ailment</a>
              <a href="http://localhost:8080/HospitalWeb/ailment/list">View Ailment</a>
            </div>
          </div>
          <div class="dropdown">
            <button class="dropbtn">Test
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="http://localhost:8080/HospitalWeb/test/form">Add Test</a>
              <a href="http://localhost:8080/HospitalWeb/test/list">View Test</a>
            </div>
          </div>

            <div class="dropdown">
            <button class="dropbtn">Admission
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="http://localhost:8080/HospitalWeb/admission/form">Add Patient</a>
              <a href="http://localhost:8080/HospitalWeb/admission/list">View Patient</a>
            </div>
          </div>

          <div class="dropdown">
            <button class="dropbtn">Service
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="http://localhost:8080/HospitalWeb/service/add">Add Service</a>
              <a href="http://localhost:8080/HospitalWeb/service/list">View Service</a>
            </div>
          </div>

           <a href="http://localhost:8080/HospitalWeb/findservice">Finance</a>

           <a href="http://localhost:8080/HospitalWeb/search">Search Patient</a>

        </div>
</body>
</html>