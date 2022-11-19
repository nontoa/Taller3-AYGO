import React, { useState } from 'react';
import { Formik, Form, Field } from 'formik';
import axios from 'axios';

const Login = () => {

    const [formSentFailed, changeFormSentFailed] = useState(false);

    return (
        <>
            <Formik
                initialValues={{
                    userName: '',
                    password: ''
                }}
                validate={(values) => {
                    let errors = {};

                    if (!values.userName) {
                        errors.userName = "Please enter a user name";
                    }
                    if (!values.password) {
                        errors.password = "Please enter a password";
                    }

                    return errors;
                }}
                onSubmit={(values, { resetForm }) => { 
                    axios.post('http://localhost:8585/authentication', {
                        userName: values.userName,
                        password: values.password
                    })
                    .then((response) => {                    
                        console.log(response)
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
                            <label htmlFor="password">Password</label>
                            <Field
                                type="text"
                                name="password"
                                placeholder="Password"
                                id="password"
                            />
                            {touched.password && errors.password && <div className="error">{errors.password} </div>}
                        </div>

                        <button type="submit">Login</button>
                        <a href="/Register">User register</a>
                        {formSentFailed && <p className="falla">Invalid credentials</p>}
                    </Form>
                )}
            </Formik>

        </>
    );
}

export default Login;