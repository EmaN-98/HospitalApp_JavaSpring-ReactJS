import React from 'react';
import { Router, Route } from 'react-router';
import Home from './home/home';
import PersonContainer from './person/person-container'
import CaregiverContainer from './caregiver/caregiver-container'
import PatientContainer from './patient/patient-container'
import MedicationContainer from './medication/medication-container'
import ErrorPage from './commons/errorhandling/error-page';
import LoginContainer from './login/login-container';

const createRoutes = () => (
    <Router>
      <Route  path="/person" component={PersonContainer}/>
      <Route  path="/caregiver" component={CaregiverContainer}/>
      <Route  path="/patient" component={PatientContainer}/>
      <Route  path="/medication" component={MedicationContainer}/>
      <Route  path="/login" component={LoginContainer}/>
      </Router>
);

export default createRoutes;