import { Formik, Form, Field } from 'formik';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Table, Container} from 'reactstrap';
import React, { useState, useEffect } from "react";

const Home = () => {

    const [posts, setPosts] = useState([]);
    const [activeUsers, setActiveUsers] = useState();

    useEffect(()=>{
        const token = localStorage.getItem("token");
        axios.get('http://localhost:8585/posts',
        { headers: {"Authorization" : token} })
        .then((response) => {                   
            setPosts(response.data);
        }, (error) => {                
            
        });
        axios.get('http://localhost:8585/users/logged',
        { headers: {"Authorization" : token} })
        .then((response) => {                   
            setActiveUsers(response.data);
        }, (error) => {                
            
        });                        
    },[]);

    return (
        <>
            <div>            
                <div>
                    <Formik
                        initialValues={{
                            post: ''
                        }}
                        onSubmit={(values, { resetForm }) => { 

                            const token = localStorage.getItem("token");
                            const userName = localStorage.getItem("userName");
                            axios.post('http://localhost:8585/posts', {
                                message: values.post,
                                owner: userName
                            },{ headers: {"Authorization" : token} })
                            .then((response) => {                    
                                window.location.reload();
                            }, (error) => {                
                                
                            });           
                            resetForm();
                        }}
                    >
                        {() => (
                            <Form className="formulario">
                                <p className="username">Welcome: {localStorage.getItem("userName")}</p>
                                <div className='info'>
                                    <a href="/login">Logout</a>
                                </div>                            
                                <p className="activeUsers">Active users: {activeUsers} </p>
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
                </div>
                <div>
                    <Container>
                        <br></br>
                        <h3 className="tittle">Latest Posts</h3>
                        <br></br>
                        <Table>
                            <thead>
                            <tr>
                            <th>Message</th>    
                            <th>Owner</th>
                            <th>Date</th>
                            </tr>                            
                            </thead>    
                            <tbody>
                                {posts.map((post)=>(
                                    <tr>
                                        <td>{post.message}</td>
                                        <td>{post.owner}</td>
                                        <td>{post.creationDate}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </Table>        
                    </Container>
                </div>       
            </div> 
        </>
    );
}

export default Home;