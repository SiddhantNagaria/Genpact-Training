import logo from './logo.svg';
import './App.css';
import First from './First';
import ClickBtn from './ClickBtn';
import Navbar from './Navbar';
import Header from './Header';

function App() {
  return (
    <div className="App">
      <Navbar/>
      <Header/>
      <h1>Welcome to First React App</h1>
      <First name="Siddhant"/>
   <ClickBtn/>
    </div>
  );
}

export default App;
