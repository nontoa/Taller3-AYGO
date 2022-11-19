import { Formik, Form, Field } from 'formik';
import axios from 'axios';

const Home = () => {

    return (
        <>
            <Formik
                initialValues={{
                    post: ''
                }}
                onSubmit={(values, { resetForm }) => { 
                    axios.post('http://localhost:8585/loginnn', {
                        userName: values.userName,
                        password: values.password
                    })
                    .then((response) => {                    
                        // JWT
                    }, (error) => {                
      
                    });                    
                    resetForm();
                }}
            >
                {() => (
                    <Form className="formulario">

                        <div>
                            <label htmlFor="post">Post</label>
                            <Field
                                type="text"
                                name="post"
                                placeholder="Type something..."
                                id="post"
                            />
                        </div>

                        <button type="submit">send</button>                                            
                    </Form>
                )}
            </Formik>

        </>
    );
}

export default Home;