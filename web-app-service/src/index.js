import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import RegistryForm from './RegistryForm';
import Login from './Login';
import Home from './Home';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

ReactDOM.render(
	<React.StrictMode>
		<BrowserRouter>
            <Routes>
                <Route
                    path="/"
                    element={ <div className="contenedor"> <RegistryForm /> </div> }
                />
                {/* The next line is very important for the Navigate component to work */}
                <Route
                    path="/register"
                    element={ <div className="contenedor"> <RegistryForm /> </div> }
                />
                <Route
                    path="/login"
                    element={ <div className="contenedor"> <Login /> </div> }
                />
				<Route
                    path="/home"
                    element={ <div className="contenedor"> <Home /> </div> }
                />
            </Routes>
        </BrowserRouter>
	</React.StrictMode>,
	document.getElementById('root')
);
