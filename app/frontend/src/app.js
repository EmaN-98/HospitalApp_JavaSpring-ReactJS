import React from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import NavigationBar from './navigation-bar'
import Home from './home/home';
import PersonContainer from './person/person-container'
import CaregiverContainer from './caregiver/caregiver-container'
import LoginContainer from './login/login-container'
import PatientContainer from './patient/patient-container'
import RolecaregiverContainer from './roleCaregiver/rolecaregiver-container'
import RolepatientContainer from './rolePatient/rolepatient-container'
import MedicationContainer from './medication/medication-container'
import ErrorPage from './commons/errorhandling/error-page';
import styles from './commons/styles/project-style.css';

const isDoctorType = function() {
	let typeData = localStorage.getItem('type');
	if(typeData === 'doctor') {
		return true;
	}
	return false;
}

class App extends React.Component {
	
	
    render() {
    	if(isDoctorType()) {
			return (
		            <div className={styles.back}>
		            <Router>
		                <div>
		                    <NavigationBar />
		                    <Switch>
		
		                        <Route
		                            exact
		                            path='/'
		                            render={() => <Home/>}
		                        />
	 
	    	                        <Route
		                    		exact
		                    		path='/caregiver'
	                    			render={() => <CaregiverContainer/>}
		                        />
		                      
		                        
		                        <Route
		                    		exact
		                    		path='/patient'
		                    			render={() => <PatientContainer/>}
		                        />
		                        
		                        <Route
		                			exact
		                			path='/medication'
		                				render={() => <MedicationContainer/>}
		                        />
		                        
		                        <Route
	                			exact
	                			path='/rolecaregiver'
	                				render={() => <RolecaregiverContainer/>}
		                        />
		                        
		                        <Route
	                			exact
	                			path='/rolepatient'
	                				render={() => <RolepatientContainer/>}
		                        />
		                        
		                        <Route exact path="/login" render={() => <LoginContainer/>}/>
		                        
		                        />
		                        
		                        
		                        {/*Error*/}
		                        <Route
		                            exact
		                            path='/error'
		                            render={() => <ErrorPage/>}
		                        />
		
		                        <Route render={() =><ErrorPage/>} />
		                    </Switch>
		                </div>
		            </Router>
		            </div>
		        )
    	}
    else {
    	return (
	            <div className={styles.back}>
	            <Router>
	                <div>
	                  
	                    <Switch>
	
	                        <Route
	                            exact
	                            path='/'
	                            render={() => <Home/>}
	                        />
 
    	                        <Route
	                    		exact
	                    		path='/caregiver'
                    			render={() => <CaregiverContainer/>}
	                        />
	                      
	                        
	                        <Route
	                    		exact
	                    		path='/patient'
	                    			render={() => <PatientContainer/>}
	                        />
	                        
	                        <Route
	                			exact
	                			path='/medication'
	                				render={() => <MedicationContainer/>}
	                        />
	                        
	                        <Route
                			exact
                			path='/rolecaregiver'
                				render={() => <RolecaregiverContainer/>}
	                        />
	                        
	                        <Route
                			exact
                			path='/rolepatient'
                				render={() => <RolepatientContainer/>}
	                        />
	                        
	                        <Route exact path="/login" render={() => <LoginContainer/>}/>
	                        
	                        />
	                        
	                        
	                        {/*Error*/}
	                        <Route
	                            exact
	                            path='/error'
	                            render={() => <ErrorPage/>}
	                        />
	
	                        <Route render={() =><ErrorPage/>} />
	                    </Switch>
	                </div>
	            </Router>
	            </div>
	        )
    }
     };
}

export default App
