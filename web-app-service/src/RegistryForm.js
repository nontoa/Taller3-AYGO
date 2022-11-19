import React, { useState } from 'react';
import { Formik, Form, Field } from 'formik';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
//import https from 'https';

const RegistryForm = () => {

    const [formSentSuccessfully, changeFormSentSuccessfully] = useState(false);
    const [formSentFailed, changeFormSentFailed] = useState(false);
    const navigate = useNavigate();

    return (
        <>
            <Formik
                initialValues={{
                    name: '',
                    userName: '',
                    email: '',
                    password: ''
                }}
                validate={(values) => {
                    let errors = {};

                    if (!values.name) {
                        errors.name = "Please enter a name";
                    }
                    if (!values.userName) {
                        errors.userName = "Please enter a user name";
                    }
                    if (!values.email) {
                        errors.email = "Please enter a valid email";
                    }
                    if (!values.password) {
                        errors.password = "Please enter a password";
                    }

                    return errors;
                }}
                onSubmit={(values, { resetForm }) => {
                    /*var agent = new https.Agent({
                        rejectUnauthorized: false
                    });
                    console.log(agent);
                    axios.post('https://localhost:8585/users', { httpsAgent: agent }, {
                        name: values.name,
                        email: values.email,
                        userName: values.userName,
                        password: values.password
                    })
                        .then((response) => {
                            console.log(response);
                            changeFormSentSuccessfully(true);
                            setTimeout(() => changeFormSentSuccessfully(false), 5000);
                        }, (error) => {
                            console.log(error);
                            changeFormSentFailed(true);
                            setTimeout(() => changeFormSentFailed(false), 5000);
                        }); */   
                    axios.post('http://localhost:8585/users', {
                        name: values.name,
                        email: values.email,
                        userName: values.userName,
                        password: values.password
                    })
                    .then((response) => {                    
                        changeFormSentSuccessfully(true);
                        setTimeout(() => changeFormSentSuccessfully(false), 5000);   
                        navigate('/login');                  
                    }, (error) => {                
                        changeFormSentFailed(true);
                        setTimeout(() => changeFormSentFailed(false), 5000);
                    });                    
                    resetForm();
                }}
            >
                {({ errors, touched }) => (
                    <Form className="formulario">
                        <div>
                            <label htmlFor="name">Name</label>
                            <Field
                                type="text"
                                name="name"
                                placeholder="Name"
                                id="name"
                            />
                            {touched.name && errors.name && <div className="error">{errors.name} </div>}
                        </div>

                        <div>
                            <label htmlFor="userName">UserName</label>
                            <Field
                                type="text"
                                name="userName"
                                placeholder="User name"
                                id="userName"
                            />
                            {touched.userName && errors.userName && <div className="error">{errors.userName} </div>}
                        </div>

                        <div>
                            <label htmlFor="email">Email</label>
                            <Field
                                type="email"
                                name="email"
                                placeholder="Email"
                                id="email"
                            />
                            {touched.email && errors.email && <div className="error">{errors.email} </div>}
                        </div>

                        <div>
                            <label htmlFor="password">Password</label>
                            <Field
                                type="text"
                                name="password"
                                placeholder="Password"
                                id="password"
                            />
                            {touched.password && errors.password && <div className="error">{errors.password} </div>}
                        </div>

                        <button type="submit">Save</button>                    
                        <a href="/login">Login</a>
                        {formSentSuccessfully && <p className="exito">User created</p>}
                        {formSentFailed && <p className="falla">User cannot be created</p>}
                    </Form>
                )}
            </Formik>

        </>
    );
}

export default RegistryForm;