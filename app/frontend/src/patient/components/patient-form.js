import React from 'react';
import validate from "./validators/patient-validators";
import Button from "react-bootstrap/Button";
import * as API_USERS from "../api/patient-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Col, Row} from "reactstrap";
import { FormGroup, Input, Label} from 'reactstrap';




class PatientForm extends React.Component {

    constructor(props) {
        super(props);
        this.toggleForm = this.toggleForm.bind(this);
        this.reloadHandler = this.props.reloadHandler;
        this.formType=this.props.formType;
        this.state = {

            errorStatus: 0,
            error: null,

            formIsValid: false,

            formControls: {
            	id: {
                    value: '',
                    placeholder: 'ID...',
                    valid: false,
                    touched: false,
                },
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
                birthdate: {
                    value: '',
                    placeholder: 'Birthdate...',
                    valid: false,
                    touched: false,
                    //validationRules: {
                    //    emailValidator: true
                    //}
                },
                gender: {
                    value: '',
                    placeholder: 'Gender...',
                    valid: false,
                    touched: false,
                },
                address: {
                    value: '',
                    placeholder: 'Address...',
                    valid: false,
                    touched: false,
                },
                medical_record: {
                    value: '',
                    placeholder: 'Medical record...',
                    valid: false,
                    touched: false,
                },
                caregiverName: {
                    value: '',
                    placeholder: 'Caregiver name...',
                    valid: false,
                    touched: false,
                },
                doctorName: {
                    value: '',
                    placeholder: 'Doctor name...',
                    valid: false,
                    touched: false,
                },
                role: {
                    value: '',
                    placeholder: 'Role...',
                    valid: false,
                    touched: false,
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

    registerPatient(patient) {
        return API_USERS.postPatient(patient, (result, status, error) => {
            if (result !== null && (status === 200 || status === 201)) {
                console.log("Successfully inserted patient with id: " + result);
                this.reloadHandler();
            } else {
                this.setState(({
                    errorStatus: status,
                    error: error
                }));
            }
        });
    }
    
    updatePatient(patient) {
    	console.log(patient);
    	return API_USERS.updatePatient(patient);
    }
    
    deletePatient(patient) {
    	console.log(patient);
    	return API_USERS.deletePatientById(patient);
    }

    handleSubmit() {
        let patient = {
            id: this.state.formControls.id.value,
            name: this.state.formControls.name.value,
            birthdate: this.state.formControls.birthdate.value,
            gender: this.state.formControls.gender.value,
            address: this.state.formControls.address.value,
            medical_record: this.state.formControls.medical_record.value,
            caregiverName: this.state.formControls.caregiverName.value,
            doctorName: this.state.formControls.doctorName.value,
            role :this.state.formControls.role.value
        };
        
        console.log(patient, this.formType);
        switch(this.formType){
        	case "insert":this.registerPatient(patient);console.log("insert form");break;
        	case "delete":this.deletePatient(patient);console.log("delete form");break;
        	case "update":this.updatePatient(patient);console.log("update form");break;
        	default:this.updatePatient(patient);
        }
        
    }

    render() {
        return (
            <div>
            <FormGroup id='id'>
            <Label for='idField'> Id: </Label>
            <Input name='id' id='idField' placeholder={this.state.formControls.id.placeholder}
                   onChange={this.handleChange}
                   defaultValue={this.state.formControls.id.value}
                   touched={this.state.formControls.id.touched? 1 : 0}
                   valid={this.state.formControls.id.valid}
                   required
            />
            </FormGroup>
        
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

                <FormGroup id='birthdate'>
                    <Label for='birthdateField'> Birthdate: </Label>
                    <Input name='birthdate' id='birthdateField' placeholder={this.state.formControls.birthdate.placeholder}
                           onChange={this.handleChange}
                           defaultValue={this.state.formControls.birthdate.value}
                           touched={this.state.formControls.birthdate.touched? 1 : 0}
                           valid={this.state.formControls.birthdate.valid}
                           required
                    />
                </FormGroup>

                <FormGroup id='gender'>
                <Label for='genderField'> Gender: </Label>
                <Input name='gender' id='genderField' placeholder={this.state.formControls.gender.placeholder}
                       onChange={this.handleChange}
                       defaultValue={this.state.formControls.gender.value}
                       touched={this.state.formControls.gender.touched? 1 : 0}
                       valid={this.state.formControls.gender.valid}
                       required
                />
                </FormGroup>
            
                <FormGroup id='address'>
                    <Label for='addressField'> Address: </Label>
                    <Input name='address' id='addressField' placeholder={this.state.formControls.address.placeholder}
                           onChange={this.handleChange}
                           defaultValue={this.state.formControls.address.value}
                           touched={this.state.formControls.address.touched? 1 : 0}
                           valid={this.state.formControls.address.valid}
                           required
                    />
                </FormGroup>
                
                <FormGroup id='medical_record'>
                	<Label for='medical_recordFiled'> Medical_record: </Label>
                	<Input name='medical_record' id='medical_recordField' placeholder={this.state.formControls.medical_record.placeholder}
                		onChange={this.handleChange}
                		defaultValue={this.state.formControls.medical_record.value}
                		touched={this.state.formControls.medical_record.touched? 1 : 0}
                		valid={this.state.formControls.medical_record.valid}
                		required
                	/>
                </FormGroup>
            
                <FormGroup id='caregiverName'>
                	<Label for='caregiverNameField'> CaregiverName: </Label>
                	<Input name='caregiverName' id='caregiverNameField' placeholder={this.state.formControls.caregiverName.placeholder}
                		onChange={this.handleChange}
                		defaultValue={this.state.formControls.caregiverName.value}
                		touched={this.state.formControls.caregiverName.touched? 1 : 0}
                		valid={this.state.formControls.caregiverName.valid}
                		required
                	/>
                </FormGroup>
                
                <FormGroup id='doctorName'>
                	<Label for='doctorNameField'> DoctorName: </Label>
                	<Input name='doctorName' id='doctorNameField' placeholder={this.state.formControls.doctorName.placeholder}
                		onChange={this.handleChange}
            			defaultValue={this.state.formControls.doctorName.value}
                		touched={this.state.formControls.doctorName.touched? 1 : 0}
                		valid={this.state.formControls.doctorName.valid}
            			required
            		/>
            	</FormGroup>
                
                <FormGroup id='role'>
                	<Label for='roleField'> Role: </Label>
                	<Input name='role' id='roleField' placeholder={this.state.formControls.role.placeholder}
                		onChange={this.handleChange}
                		defaultValue={this.state.formControls.role.value}
                		touched={this.state.formControls.role.touched? 1 : 0}
                		valid={this.state.formControls.role.valid}
                		required
                     />
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

export default PatientForm;
