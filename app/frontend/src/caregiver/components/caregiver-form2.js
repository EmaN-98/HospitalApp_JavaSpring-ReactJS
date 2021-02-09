import React from 'react';
import validate from "./validators/caregiver-validators";
import Button from "react-bootstrap/Button";
import * as API_USERS from "../api/caregiver-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Col, Row} from "reactstrap";
import { FormGroup, Input, Label} from 'reactstrap';
//import CaregiverService from "../../services";




class CaregiverForm2 extends React.Component {

	 
        constructor(props) {
            super(props);
            this.toggleForm = this.toggleForm.bind(this);
            this.reloadHandler = this.props.reloadHandler;
            this.formType="delete";
            this.state = {

                errorStatus: 0,
                error: null,

                formIsValid: false,

                formControls: {
                    name: {
                        value: '',
                        placeholder: 'What is your name?...',
                        valid: false,
                        touched: false,
                        validationRules: {
                            minLength: 3,
                            isRequired: true
                        }
                    },
                }
            };
            this.handleChange = this.handleChange.bind(this);
            this.handleSubmit = this.handleSubmit.bind(this);
            
        }
        
       
      
    


    
    toggleForm() {
        this.setState({collapseForm: !this.state.collapseForm});
    }


    handleChange = event => {

        const name = event.target.name;
        const value = event.target.value;

        const updatedControls = this.state.formControls;

        const updatedFormElement = updatedControls[name];

        updatedFormElement.value = value;
        updatedFormElement.touched = true;
        updatedFormElement.valid = validate(value, updatedFormElement.validationRules);
        updatedControls[name] = updatedFormElement;

        let formIsValid = true;
        for (let updatedFormElementName in updatedControls) {
            formIsValid = updatedControls[updatedFormElementName].valid && formIsValid;
        }

        this.setState({
            formControls: updatedControls,
            formIsValid: formIsValid
        });

    };

    registerCaregiver(caregiver) {
        return API_USERS.postCaregiver(caregiver, (result, status, error) => {
            if (result !== null && (status === 200 || status === 201)) {
                console.log("Successfully inserted caregiver with id: " + result);
                this.reloadHandler();
            } else {
                this.setState(({
                    errorStatus: status,
                    error: error
                }));
            }
        });
    }
    
    
    deleteCaregiver(caregiver){
    	
    }
    
//    updateCaregiver() {
//        CaregiverService.update(
//            this.state.currentCaregiver.id,
//            this.state.currentCaregiver
//        )
//            .then(response => {
//                console.log(response.data);
//                this.setState({
//                    message: "Caregiver was updated successfully!"
//                });
//            })
//            .catch(e => {
//                console.log(e);
//            });
//    }
    
//    updateCaregiver(caregiver) {
//        return API_USERS.getCaregivers((result, status, error) => {
//            if (result !== null && (status === 200 || status === 201)) {
//            	result=[...result];
//            	console.log("Successfully got caregivers : " + JSON.stringify(result[0]));
//            	result.forEach(x=>{
//            		if(x.name.trim().localeCompare(caregiver.name.trim())===0){
//            			let requestBody={
//            				id: x.id,
//            				name: x.name,
//            				birthdate: x.birthdate,
//            				gender: x.gender,
//            				address: x.address,
//            				role: x.role,
//            			}
//            			console.log("requestBody: " + JSON.stringify(requestBody));
//            			API_USERS.updateCaregiver(requestBody,(result1, status1, error1)=>{
//            				if(result1 !== null && (status === 200 || status === 201)){
//            					console.log("Successfully updated caregiver with id: " + result1.id);
//            					this.reloadHandler();
//            				}
//            				else{
//            					this.setState(({
//            	                    errorStatus: status,
//            	                    error: error
//            	                }));
//            				}
//            			}
//            		}
//            	})
//                
//            }
//        });
//    }

    handleSubmit() {
        let caregiver = {
            name: this.state.formControls.name.value,
          
        };

        console.log(caregiver);
        switch(this.formType){
        	case "insert":this.registerCaregiver(caregiver);console.log("insert form");break;
        	case "delete":this.deleteCaregiver(caregiver);console.log("delete form");break;
        	//case "update":this.updateCaregiver(caregiver);console.log("update form");break;
        	default:this.registerCaregiver(caregiver);
        }
        
    }

    render() {
        return (
            <div>

                <FormGroup id='name'>
                    <Label for='nameField'> Name: </Label>
                    <Input name='name' id='nameField' placeholder={this.state.formControls.name.placeholder}
                           onChange={this.handleChange}
                           defaultValue={this.state.formControls.name.value}
                           touched={this.state.formControls.name.touched? 1 : 0}
                           valid={this.state.formControls.name.valid}
                           required
                    />
                    {this.state.formControls.name.touched && !this.state.formControls.name.valid &&
                    <div className={"error-message row"}> * Name must have at least 3 characters </div>}
                </FormGroup>

               
                
            

                    <Row>
                        <Col sm={{size: '4', offset: 8}}>
                            <Button type={"submit"}  onClick={this.handleSubmit}>  Submit </Button>
                        </Col>
                    </Row>

                {
                    this.state.errorStatus > 0 &&
                    <APIResponseErrorMessage errorStatus={this.state.errorStatus} error={this.state.error}/>
                }
            </div>
        ) ;
    }
}

export default CaregiverForm2;
