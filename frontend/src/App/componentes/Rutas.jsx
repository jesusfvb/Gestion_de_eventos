import React from "react";
import {
  BrowserRouter,
  Redirect,
  Route,
  Switch,
} from "react-router-dom/cjs/react-router-dom.min";
import Usuario from "../paginas/administrador/Usuario";
import Solicitudes from "../paginas/coordinador/Solicitudes";
import Error404 from "../paginas/Error404";
import Principal from "../paginas/Principal";
import Evento from "../paginas/usuario/Evento";

export default function Rutas() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/home" component={Principal} />
        <Route exact path="/administrar/usuario" component={Usuario} />
        <Route exact path="/evento" component={Evento} />
        <Route exact path="/registrar/evento" component={Solicitudes} />
        <Redirect exact to="/registrar/evento" from="/" />
        <Route component={Error404} />
      </Switch>
    </BrowserRouter>
  );
}
