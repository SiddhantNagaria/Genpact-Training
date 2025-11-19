import './Navbar.css';
export default function Navbar(){
    return(
        <div className="navbar">
            <a href="/home" id='link'>Home</a>
            <a href="/services" id='link'>Services</a>
            <a href="/products" id='link'>Products</a>
        </div>
    )
}