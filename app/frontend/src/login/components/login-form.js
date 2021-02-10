import React from 'react';
import validate from "./validators/login-validators";
import Button from "react-bootstrap/Button";
import * as API_USERS from "../api/login-api";
import APIResponseErrorMessage from "../../commons/errorhandling/api-response-error-message";
import {Col, Row} from "reactstrap";
import { FormGroup, Input, Label} from 'reactstrap';




class LoginForm extends React.Component {

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
            	username: {
                    value: '',
                    placeholder: 'What is your username?...',
                    valid: false,
                    touched: false,
                },
                password: {
                    value: '',
                    placeholder: 'What is your password?...',
                    valid: false,
                    touched: false,
                    validationRules: {
                        minLength: 3,
                        isRequired: true
                    }
                },
                role: {
                    value: '',
                    placeholder: 'What is your role?...',
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


    
    
    loginUser(login){
    	console.log("in form:"+login);
    	return API_USERS.loginUser(login,(result, status, error) => {
          if (result !== null && (status === 200 || status === 201)) {
          console.log("Success at login:  " + result);
          this.reloadHandler();
      } else {
          this.setState(({
              errorStatus: status,
              error: error
          }));
      }
  });
    }
    
    registerUser(login){
    	console.log(login);
    	return API_USERS.registerUser(login);
    }


    handleSubmit() {
        let login = {
            username: this.state.formControls.username.value,
            password: this.state.formControls.password.value,
            role: this.state.formControls.role.value
        };
        
        console.log(login, this.formType);
        switch(this.formType){
        	case "login":this.loginUser(login);console.log("login form");break;
        	case "register":this.registerUser(login);console.log("register form");break;
        	default:this.loginUser(login);
        }
        
    }

    render() {
        return (
            <div>
            
                <FormGroup id='username'>
                    <Label for='usernameField'> Name: </Label>
                    <Input name='username' id='usernameField' placeholder={this.state.formControls.username.placeholder}
                           onChange={this.handleChange}
                           defaultValue={this.state.formControls.username.value}
                           touched={this.state.formControls.username.touched? 1 : 0}
                           valid={this.state.formControls.username.valid}
                           required
                    />
                    {this.state.formControls.username.touched && !this.state.formControls.username.valid &&
                    <div className={"error-message row"}> * Name must have at least 3 characters </div>}
                </FormGroup>

                <FormGroup id='password'>
                    <Label for='passwordField'> Password: </Label>
                    <Input name='password' id='passwordField' placeholder={this.state.formControls.password.placeholder}
                           onChange={this.handleChange}
                           defaultValue={this.state.formControls.password.value}
                           touched={this.state.formControls.password.touched? 1 : 0}
                           valid={this.state.formControls.password.valid}
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

export default LoginForm;
