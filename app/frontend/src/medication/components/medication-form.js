import React from 'react';
import validate from "./validators/medication-validators";
import Button from "react-bootstrap/Button";
import * as API_USERS from "../api/medication-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Col, Row} from "reactstrap";
import { FormGroup, Input, Label} from 'reactstrap';




class MedicationForm extends React.Component {

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
                    placeholder: 'What is the name?...',
                    valid: false,
                    touched: false,
                    validationRules: {
                        minLength: 3,
                        isRequired: true
                    }
                },
                sideEffects: {
                    value: '',
                    placeholder: 'Side Effects...',
                    valid: false,
                    touched: false,
                },
                dosage: {
                    value: '',
                    placeholder: 'Dosage...',
                    valid: false,
                    touched: false,
                },
                intake_interval: {
                    value: '',
                    placeholder: 'Intake interval...',
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

    registerMedication(medication) {
        return API_USERS.postMedication(medication, (result, status, error) => {
            if (result !== null && (status === 200 || status === 201)) {
                console.log("Successfully inserted medication with id: " + result);
                this.reloadHandler();
            } else {
                this.setState(({
                    errorStatus: status,
                    error: error
                }));
            }
        });
    }
    
    updateMedication(medication) {
    	console.log(medication);
    	return API_USERS.updateMedication(medication);
    }
    
    deleteMedication(medication) {
    	console.log(medication);
    	return API_USERS.deleteMedicationById(medication);
    }

    handleSubmit() {
        let medication = {
            id: this.state.formControls.id.value,
            name: this.state.formControls.name.value,
            sideEffects: this.state.formControls.sideEffects.value,
            dosage: this.state.formControls.dosage.value,
            intake_interval: this.state.formControls.intake_interval.value,
        };
        
        console.log(medication, this.formType);
        switch(this.formType){
        	case "insert":this.registerMedication(medication);console.log("insert form");break;
        	case "delete":this.deleteMedication(medication);console.log("delete form");break;
        	case "update":this.updateMedication(medication);console.log("update form");break;
        	default:this.updateMedication(medication);
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

                <FormGroup id='sideEffects'>
                    <Label for='sideEffectsField'> Birthdate: </Label>
                    <Input name='sideEffects' id='sideEffectsField' placeholder={this.state.formControls.sideEffects.placeholder}
                           onChange={this.handleChange}
                           defaultValue={this.state.formControls.sideEffects.value}
                           touched={this.state.formControls.sideEffects.touched? 1 : 0}
                           valid={this.state.formControls.sideEffects.valid}
                           required
                    />
                </FormGroup>

                <FormGroup id='dosage'>
                <Label for='dosageField'> Gender: </Label>
                <Input name='dosage' id='dosageField' placeholder={this.state.formControls.dosage.placeholder}
                       onChange={this.handleChange}
                       defaultValue={this.state.formControls.dosage.value}
                       touched={this.state.formControls.dosage.touched? 1 : 0}
                       valid={this.state.formControls.dosage.valid}
                       required
                />
                </FormGroup>
            
                <FormGroup id='intake_interval'>
                    <Label for='intake_intervalField'> Address: </Label>
                    <Input name='intake_interval' id='intake_intervalField' placeholder={this.state.formControls.intake_interval.placeholder}
                           onChange={this.handleChange}
                           defaultValue={this.state.formControls.intake_interval.value}
                           touched={this.state.formControls.intake_interval.touched? 1 : 0}
                           valid={this.state.formControls.intake_interval.valid}
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

export default MedicationForm;
