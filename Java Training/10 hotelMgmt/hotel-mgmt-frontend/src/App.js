// import logo from './logo.svg';
import './App.css';
import HotelEditForm from './components/HotelEditForm';
import HotelForm from './components/HotelForm';
import HotelList from './components/HotelList';

function App() {
  return (
   <div className='app'>
    <header>
      <h1>Hotel Management App</h1>
    </header>
    <main style={{display:"flex",gap:"20px"}}>
      <section className='left' style={{width:"350px"}}>
        <HotelForm/>
        <hr style={{margin:"20px 0"}}></hr>
        <HotelEditForm/>
      </section>
      <section className='right' style={{flex:1}}>
        <HotelList/>
      </section>
    </main>
   </div>
  )
}

export default App;
